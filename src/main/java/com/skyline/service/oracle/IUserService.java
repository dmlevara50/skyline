package com.skyline.service.oracle;

import com.skyline.dto.UserDTO;

import java.util.List;

public interface  IUserService {
    UserDTO newUser();
    UserDTO newUser(UserDTO user);
    List<UserDTO> allUsers(UserDTO user);
}
