package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Dto.LoginDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserDTO;
import com.example.WeBKKHustraUhrovec.Response.LoginResponse;

public interface UserService {

    String addUser(UserDTO userDto);

    LoginResponse loginUser(LoginDTO loginDto);
}
