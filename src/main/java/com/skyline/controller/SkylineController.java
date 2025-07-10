package com.skyline.controller;

import com.skyline.dto.UserDTO;
import com.skyline.entity.elasticsearch.UserElasticSearchDTO;
import com.skyline.service.elasticsearch.UserServiceElasticSearch;
import com.skyline.service.oracle.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@RestController
@Scope("session")
public class SkylineController implements Serializable {

    @Resource
    private IUserService iUserService;

    @Autowired
    private UserServiceElasticSearch userServiceElasticSearch;

    // ORACLE
    @GetMapping(value = "/")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> response =  iUserService.allUsers(UserDTO.builder().build());
        return ResponseEntity.ok(response);
    }

    // ELASTICSEARCH
    @GetMapping(value = "/elastic/users/")
    public ResponseEntity<List<UserElasticSearchDTO>> getAllUsers() {
        List<UserElasticSearchDTO> response =  userServiceElasticSearch.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/elastic/users/{name}")
    public ResponseEntity<List<UserElasticSearchDTO>> getAllUsersByName(@PathVariable String name) {
        List<UserElasticSearchDTO> response =  userServiceElasticSearch.findAllByName(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/elastic/user/{id}")
    public ResponseEntity<UserElasticSearchDTO> getAllById(@PathVariable String id) {
        UserElasticSearchDTO response =  userServiceElasticSearch.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/elastic/user/")
    public ResponseEntity<UserElasticSearchDTO> create(@RequestBody UserElasticSearchDTO userElasticSearchDTO) {
        UserElasticSearchDTO saveUserElasticSearchDTO  = userServiceElasticSearch.save(userElasticSearchDTO);
        return ResponseEntity.ok(saveUserElasticSearchDTO);
    }

    @PutMapping("/elastic/user/{id}")
    public ResponseEntity<UserElasticSearchDTO> update(@PathVariable String id, @RequestBody UserElasticSearchDTO userElasticSearchDTO) {
        userElasticSearchDTO.setId(new BigDecimal(id));
        userElasticSearchDTO = userServiceElasticSearch.saveUser(userElasticSearchDTO);
        return ResponseEntity.ok(userElasticSearchDTO);
    }
}
