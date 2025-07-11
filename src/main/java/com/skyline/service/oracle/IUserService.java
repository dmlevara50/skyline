package com.skyline.service.oracle;

import com.skyline.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface  IUserService {
    UserDTO newUser(UserDTO user);
    List<UserDTO> allUsers(UserDTO user);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
