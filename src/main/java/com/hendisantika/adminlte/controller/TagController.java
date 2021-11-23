package com.hendisantika.adminlte.controller;

import com.hendisantika.adminlte.dto.Dto;
import com.hendisantika.adminlte.model.Tags;
import com.hendisantika.adminlte.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tags")
@RestController
public class TagController {

    @Autowired
    private TagsRepository tagRepository;

    @PostMapping
    public ResponseEntity<Tags> createTag(@RequestBody Dto.RequestTag payload){
        Tags tag = new Tags();
        tag.setName(payload.getName());
        tagRepository.save(tag).getId();
        return new ResponseEntity<Tags>(tag, HttpStatus.valueOf("OK"));
    }

    @GetMapping
    public ResponseEntity<List<Tags>> getTags(){

        return new ResponseEntity<List<Tags>>(tagRepository.findAll(), HttpStatus.valueOf("OK"));
    }

/*
    @GetMapping("/{id}")
    public ResponseEntity<Tags> getTagById(@PathVariable Long id){
        return new ResponseEntity<Tags>(tagRepository.findById(id).get(), HttpStatus.valueOf("OK"));
    }
*/

    @GetMapping("/{name}")
    public ResponseEntity<Tags> getTagByName(@PathVariable String name){
        return new ResponseEntity<Tags>(tagRepository.findByName(name), HttpStatus.valueOf("OK"));
    }
}
