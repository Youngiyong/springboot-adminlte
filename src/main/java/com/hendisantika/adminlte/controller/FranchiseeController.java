package com.hendisantika.adminlte.controller;

import com.hendisantika.adminlte.dto.Dto;
import com.hendisantika.adminlte.model.FranchiseeTags;
import com.hendisantika.adminlte.model.Franchisees;
import com.hendisantika.adminlte.repository.FranchiseeTagsRepository;
import com.hendisantika.adminlte.repository.FranchiseesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("franchisees")
public class FranchiseeController {

    @Autowired
    private FranchiseesRepository franchiseesRepository;

    @Autowired
    private FranchiseeTagsRepository franchiseeTagsRepository;

    @PostMapping
    public void createFranchisee(@RequestBody Dto.RequestFranchisee payload){
    }

    @GetMapping
    public List<Franchisees> findAllFranchisees(){
        return franchiseesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Franchisees getFranchisee(@PathVariable Long id){
        return franchiseesRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public Franchisees updateFranchisee(@PathVariable Long id, @RequestBody Dto.RequestUpdateFranchisee payload){
        return franchiseesRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteFranchisee(@PathVariable Long id){
        Franchisees franchisee = franchiseesRepository.findById(id).get();
        franchisee.setDeletedAt(LocalDateTime.now());
        franchiseesRepository.save(franchisee);
    }
}
