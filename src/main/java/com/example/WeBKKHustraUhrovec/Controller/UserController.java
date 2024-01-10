package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Dto.LoginDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserDTO;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Response.LoginResponse;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping(path = "/getUsersList")
    public List<User> getAllUsers() {return userService.getAllUsers();}
    @DeleteMapping(path = "/deleteUser")
    public String deleteUser(@RequestParam String email) {
        return userService.deleteUser(email);
    }
    @PutMapping(path = "/updateUser")
    public User updateUser(@RequestBody UserDTO userDto) {
        return userService.updateUser(userDto);
    }

    @PutMapping(path = "/updateUserRole")
    public User updateUserRole(@RequestParam String id, @RequestParam String role) {
        return userService.updateUserRole(id, role);
    }


}
