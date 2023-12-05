package com.example.WeBKKHustraUhrovec.UserController;

import com.example.WeBKKHustraUhrovec.Dto.LoginDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserDTO;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Response.LoginResponse;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDto) {

        return userService.addUser(userDto);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDto) {

        LoginResponse loginResponse = userService.loginUser(loginDto);

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(path = "/getUser")
    public User getUser(@RequestParam String email) {
        return userService.getUser(email);
    }
    @DeleteMapping(path = "/deleteUser")
    public void deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
    }
    @PutMapping(path = "/updateUser")
    public User updateUser(@RequestBody UserDTO userDto) {
        return userService.updateUser(userDto);
    }


}
