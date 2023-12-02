package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Dto.LoginDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserDTO;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Response.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    String addUser(UserDTO userDto);

    LoginResponse loginUser(LoginDTO loginDto);

    User getUser(UserDTO userDTO);
}
