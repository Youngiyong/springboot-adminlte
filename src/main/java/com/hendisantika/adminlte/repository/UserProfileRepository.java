package com.hendisantika.adminlte.repository;

import com.hendisantika.adminlte.model.UserProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfiles, Long> {
}