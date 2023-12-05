package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Dto.LoginDTO;
import com.example.WeBKKHustraUhrovec.Dto.UserDTO;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Repo.UserRepo;
import com.example.WeBKKHustraUhrovec.Response.LoginResponse;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.exception.UserUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwdEncoder;

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
                this.passwdEncoder.encode(userDto.getPassword())
        );

        userRepo.save(user);

        return user.getUserName();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDto) {
        User user = userRepo.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPasswd = user.getPassword();
            System.out.println("Entered Password: " + password);
            System.out.println("Encoded Password in DB: " + encodedPasswd);
            if (passwdEncoder.matches(password, encodedPasswd)) {
                Optional<User> userN = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPasswd);
                if (userN.isPresent()) {
                    return new LoginResponse("Login Successful", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Doesn't Match", false);
            }

        } else {
            return new LoginResponse("Email Doesn't Exist", false);
        }
    }

    @Override
    public User getUser(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepo.findByEmail(email);
        userRepo.deleteById(user.getUserID());
    }

    @Override
    public User updateUser(User userN) {
        User user = userRepo.findById(userN.getUserID()).orElse(null);
        if (user != null) {
            // Check if the new username is already taken by another user
            if (!user.getUserName().equals(userN.getUserName()) && userRepo.existsByUserName(userN.getUserName())) {
                throw new UserUpdateException("Username is already taken");
            }
            // Check if the new email is already registered by another user
            if (!user.getEmail().equals(userN.getEmail()) && userRepo.existsByEmail(userN.getEmail())) {
                throw new UserUpdateException("Email is already registered");
            }

            // Update user details
            user.setUserName(userN.getUserName());
            user.setEmail(userN.getEmail());
            //user.setPassword(userN.getPassword());
            user.setPassword(userN.getPassword());

            return userRepo.save(user);
        } else {
            throw new UserUpdateException("User not found");
        }
    }


}
