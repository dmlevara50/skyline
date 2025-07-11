package com.skyline.service.oracle;

import com.skyline.dao.interfaces.oracle.IUserRepository;
import com.skyline.dto.UserDTO;
import com.skyline.entity.oracle.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Resource
     IUserRepository iUserRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDTO newUser(UserDTO user) {
        Long ID_ROL = 2L;
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUserEntity(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPass(encoder.encode(user.getPassword()));
        userEntity.setRol(ID_ROL);
        iUserRepository.saveAndFlush(userEntity);
        return user;
    }

    @Override
    public List<UserDTO> allUsers(UserDTO user) {
        List<UserDTO> usersDTO = new ArrayList<>();
        UserEntity userEntityFind = new UserEntity();
        if (user != null && user.getId() != null) {
            userEntityFind.setIdUserEntity(user.getId());
        }
        if (user != null && user.getName() != null) {
            userEntityFind.setName(user.getName());
        }
        List<UserEntity> usersEntity = iUserRepository.findAll();
        usersEntity.stream().forEach(usersEntity1 -> {
            UserDTO mapperUser = UserDTO.builder().id(usersEntity1.getIdUserEntity()).name(usersEntity1.getName()).build();
            usersDTO.add(mapperUser);
        });
        return usersDTO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = iUserRepository.findAllByName(username);
        return new org.springframework.security.core.userdetails.User(userEntity.get().getName(),
                userEntity.get().getPass(),
                getAuthorities(userEntity.get()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserEntity userEntity) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}