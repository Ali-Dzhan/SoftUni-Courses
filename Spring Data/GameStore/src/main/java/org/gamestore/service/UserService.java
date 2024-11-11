package org.gamestore.service;

import org.gamestore.data.entities.User;
import org.gamestore.service.dtos.UserCreateDto;

public interface UserService {
    String registerUser(UserCreateDto userCreateDto);
    String loginUser(String email, String password);
    String logout();
    User getLoggedInUser();
}
