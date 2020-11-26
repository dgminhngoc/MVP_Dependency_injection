package com.example.mvp_test.fragments.login;

public interface LoginPresenter {
    //Functions for Dependency Injection
    void bind(LoginView view);
    void unbind();
    //Main functions of presenter
    void login();
    void verifyAccount(String username, String password);
}