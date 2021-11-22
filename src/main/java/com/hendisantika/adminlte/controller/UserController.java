package com.hendisantika.adminlte.controller;

import com.hendisantika.adminlte.dto.UserDto;
import com.hendisantika.adminlte.model.Users;
import com.hendisantika.adminlte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto.ResponseCreate createUser(@RequestBody UserDto.RequestUser payload){
        return new UserDto.ResponseCreate(userService.save(payload), 200, "success");
    }

    @GetMapping
    public List<Users> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public Users updateUser(@RequestBody UserDto.RequestUpdateUser payload, @PathVariable Long id){
        return userService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public UserDto.BaseResponse delete(@PathVariable Long id){
        userService.delete(id);
        return new UserDto.BaseResponse(200, "success");
    }

}
