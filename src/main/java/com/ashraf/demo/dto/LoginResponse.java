package com.ashraf.demo.dto;

import com.ashraf.demo.model.User;

public class LoginResponse {
    String message;
    String status;
    User user;
    public LoginResponse(String message, String status,User user) {
        this.message = message;
        this.status = status;
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
