package com.richieoscar.chatty.model;

public class UserResponse {

    private String response;
    private String username;

    public UserResponse(String response, String username) {
        this.response = response;
        this.username = username;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
