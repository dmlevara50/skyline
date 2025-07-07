package com.skyline.controller;

import com.skyline.dto.UserDTO;
import com.skyline.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@Scope("session")
public class SkylineController implements Serializable {

    @Resource
    private IUserService iUserService;

    @GetMapping(value = "/")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> response =  iUserService.allUsers(UserDTO.builder().build());
        return ResponseEntity.ok(response);
    }


}
