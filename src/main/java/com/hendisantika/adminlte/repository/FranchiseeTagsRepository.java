package com.hendisantika.adminlte.repository;

import com.hendisantika.adminlte.model.FranchiseeTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseeTagsRepository extends JpaRepository<FranchiseeTags, Long> {
}
