package com.example.mvp_test.fragments.login;

public class LoginModelImpl implements LoginModel {

    @Override
    public String getPassword(String username) {
        if (username.equals("tim")) {
            return "solunar";
        }
        else {
            return "";
        }
    }
}