package com.hendisantika.adminlte.repository;

import com.hendisantika.adminlte.model.Tags;
import com.hendisantika.adminlte.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {
    Tags findByName(String name);
}
