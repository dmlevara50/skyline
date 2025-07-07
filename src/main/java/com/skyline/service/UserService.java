package com.skyline.service;

import com.skyline.dao.interfaces.IUserRepository;
import com.skyline.dto.UserDTO;
import com.skyline.entity.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Resource
    private IUserRepository iUserRepository;

    public UserDTO newUser() {
        return UserDTO.builder().build();
    }

    @Override
    public UserDTO newUser(UserDTO user) {
        UserEntity userEntity = new UserEntity();
        UserDTO newUser = newUser();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        iUserRepository.persist(userEntity);
        return user;
    }

    @Override
    public List<UserDTO> allUsers(UserDTO user){
        List<UserDTO> usersDTO = new ArrayList<>();
        UserEntity userEntityFind = new UserEntity();
        if (user != null && user.getId() != null) {
            userEntityFind.setId(user.getId());
        }
        if (user != null && user.getName() != null) {
            userEntityFind.setName(user.getName());
        }
        List<UserEntity> usersEntity = iUserRepository.find(userEntityFind);
        usersEntity.stream().forEach(usersEntity1 -> {
            UserDTO mapperUser = newUser();
            mapperUser.setId(usersEntity1.getId());
            mapperUser.setName(usersEntity1.getName());
            usersDTO.add(mapperUser);
        });
        return usersDTO;
    }
}