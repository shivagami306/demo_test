package com.n47.multitenancydemo.controller;

public class UserRequestBody {
    private String name;

    public UserRequestBody() {
    }

    public UserRequestBody(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
