package com.hendisantika.adminlte.service;

import com.hendisantika.adminlte.dto.UserDto;
import com.hendisantika.adminlte.dto.UserDto.RequestUser;
import com.hendisantika.adminlte.model.UserProfiles;
import com.hendisantika.adminlte.model.Users;
import com.hendisantika.adminlte.repository.UserProfileRepository;
import com.hendisantika.adminlte.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;

    private final UserProfileRepository userProfileRepository;

    @Override
    public Users loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email);
    }

    public Long save(UserDto.RequestUser payload) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Users user = new Users();
        UserProfiles userProfiles = new UserProfiles();

        user.setEmail(payload.getEmail());
        user.setPassword(encoder.encode(payload.getPassword()));
        user.setAuth(payload.getAuth());

        usersRepository.save(user);

        userProfiles.setUserId(user.getId());

        userProfileRepository.save(userProfiles);
        return user.getId();

    }

    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users findById(Long id){
        return usersRepository.findById(id).get();
    }

    public Users update(Long id, UserDto.RequestUpdateUser payload){
        Users user = usersRepository.findById(id).get();
        user.setName(payload.getName());
        usersRepository.save(user);

        return user;
    }

    public void delete(Long id){
        Users user = usersRepository.findById(id).get();
        usersRepository.delete(user);
    }
}
