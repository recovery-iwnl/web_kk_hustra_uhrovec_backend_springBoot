package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Dto.LoginDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserSafeDTO;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Repo.CommentRepo;
import com.example.WeBKKHustraUhrovec.Repo.UserRepo;
import com.example.WeBKKHustraUhrovec.Response.LoginResponse;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.exception.UserUpdateException;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwdEncoder;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String addUser(UserDTO userDto) {

        if (userRepo.existsByUserName(userDto.getUserName())) {
            return "Username is already taken";
        }

        if (userRepo.existsByEmail(userDto.getEmail())) {
            return "Email is already registered";
        }


        User user = new User(
                userDto.getUserID(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getPassword(),
                UserRole.FAN
        );

        userRepo.save(user);
        user.setPassword(this.passwdEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return user.getUserName();
    }

    public LoginResponse loginUser(LoginDTO loginDto) {
        if (loginDto.getPassword() == null || loginDto.getEmail() == null) {
            return new LoginResponse("Wrong parameters", false, null);
        }
        User user = userRepo.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPasswd = user.getPassword();
            if (passwdEncoder.matches(password, encodedPasswd)) {
                Optional<User> userN = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPasswd);
                if (userN.isPresent()) {
                    String token = jwtTokenUtil.generateToken(userN.get());
                    return new LoginResponse("Login Successful", true, token);
                } else {
                    return new LoginResponse("Login Failed", false, null);
                }
            } else {
                return new LoginResponse("Password Doesn't Match", false, null);
            }

        } else {
            return new LoginResponse("Email Doesn't Exist", false, null);
        }
    }


    @Override
    public User getUserByToken(String token) {
        Claims claims = jwtTokenUtil.extractClaims(token);
        String email = claims.getSubject();
        return userRepo.findByEmail(email);
    }

    @Override
    public List<UserSafeDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserSafeDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserSafeDTO userSafeDTO = new UserSafeDTO();
            userSafeDTO.setUserID(user.getUserID());
            userSafeDTO.setUserName(user.getUserName());
            userSafeDTO.setRole(user.getRole());
            userDTOs.add(userSafeDTO);
        }
        return userDTOs;
    }

    @Override
    @Transactional
    public String deleteUser(String id) {
        if (userRepo.findByUserID(Integer.parseInt(id)) == null) {
            return "User doesn't exist";
        } else {
            User user = userRepo.findByUserID(Integer.parseInt(id));
            commentRepo.deleteAllByUser(user);
            userRepo.deleteById(user.getUserID());
            return "User " + user.getUserName() + " was deleted.";
        }
    }



    @Override
    public String getNewestUser() {
        Optional<User> newestUser = userRepo.findTopByOrderByUserIDDesc();
        return newestUser.map(User::getUserName).orElse(null);
    }

    @Override
    public Integer getNumberOfUsers() {
        return Math.toIntExact(userRepo.count());
    }

    @Override
    public String updateUser(UserDTO userDto) {
        User user = userRepo.findById(userDto.getUserID()).orElse(null);
        if (user != null) {
            if (!user.getUserName().equals(userDto.getUserName()) && userRepo.existsByUserName(userDto.getUserName())) {
                throw new UserUpdateException("Username is already taken");
            }
            if (!user.getEmail().equals(userDto.getEmail()) && userRepo.existsByEmail(userDto.getEmail())) {
                throw new UserUpdateException("Email is already registered");
            }

            user.setUserName(userDto.getUserName());
            user.setEmail(userDto.getEmail());
            if (!Objects.equals(userDto.getPassword(), "")) {
                user.setPassword(this.passwdEncoder.encode(userDto.getPassword()));
            }
            user.setRole(userDto.getRole());
            userRepo.save(user);
            return "User has been updated.";
        } else {
            throw new UserUpdateException("User not found");
        }
    }

    @Override
    public UserSafeDTO updateUserRole(String id, String role) {
        User user = userRepo.findById(Integer.valueOf(id)).orElse(null);
        if (user != null) {
            user.setRole(UserRole.valueOf(role));
            userRepo.save(user);
            UserSafeDTO userSafeDTO = new UserSafeDTO();
            userSafeDTO.setUserID(user.getUserID());
            userSafeDTO.setUserName(user.getUserName());
            userSafeDTO.setRole(user.getRole());
            return userSafeDTO;
        } else {
            throw new UserUpdateException("User not found");
        }
    }


}
