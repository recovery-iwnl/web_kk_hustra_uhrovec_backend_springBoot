package com.example.WeBKKHustraUhrovec.Dto;

import com.example.WeBKKHustraUhrovec.Enum.UserRole;

public class UserSafeDTO {
    private int userID;
    private String userName;
    private UserRole role;

    public UserSafeDTO(int userID, String userName, UserRole role) {
        this.userID = userID;
        this.userName = userName;
        this.role = role;
    }

    public UserSafeDTO() {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
