package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Dto.LoginDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserSafeDTO;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Response.LoginResponse;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    @GetMapping(path = "/getUsersList")
    public ResponseEntity<?> getAllUsers(@RequestHeader(value = "Authorization",  required = false) String token) {

        if (token == null || !isAuthenticated(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden");
        }

        List<UserSafeDTO> usersList = userService.getAllUsers();
        return ResponseEntity.ok(usersList);
    }

    @GetMapping(path = "/getNewestUser")
    public String getNewestUser() {return userService.getNewestUser();}

    @GetMapping(path = "/checkTokenExpiration")
    public Boolean checkTokenExpiration(@RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7);
        return userService.checkTokenExpiration(jwtToken);}

    @GetMapping(path = "/getNumberOfUsers")
    public Integer getNumberOfUsers() {return userService.getNumberOfUsers();}
    @DeleteMapping(path = "/deleteUser")
    public String deleteUser(@RequestParam String id) {
        return userService.deleteUser(id);
    }
    @PutMapping(path = "/updateUser")
    public String updateUser(@RequestBody UserDTO userDto) {
        return userService.updateUser(userDto);
    }

    @PutMapping(path = "/updateUserRole")
    public UserSafeDTO updateUserRole(@RequestParam String id, @RequestParam String role) {
        return userService.updateUserRole(id, role);
    }


    private boolean isAuthenticated(String token) {
        if (token != null) {
            // Validate JWT token
            return !jwtTokenUtil.isTokenExpired(token);
        }
        return false;
    }


}
