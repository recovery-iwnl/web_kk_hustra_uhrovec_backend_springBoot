package com.example.WeBKKHustraUhrovec.Entity;

import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "user_id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;

    @Column(name = "username", length = 255)
    @Size(min = 8, max = 255, message = "Username must be at least 8 characters and less than 255 characters")
    @NotEmpty
    private String userName;

    @Column(name = "email", length = 255)
    @Email( message = "Invalid email address")
    @Size (max = 255, message = "Email must be less than 255 characters")
    @NotEmpty
    private String email;

    @Column(name = "password", length = 255)
    @Size(min = 8, max = 255, message = "Password must be at least 8 characters and less than 255 characters")
    @NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20)
    private UserRole role;


    public User(int userID, String userName, String email, String password, UserRole role) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
