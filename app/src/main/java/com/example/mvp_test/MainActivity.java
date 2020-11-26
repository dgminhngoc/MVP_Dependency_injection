package com.example.mvp_test;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.mvp_test.fragments.login.LoginFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_container, new LoginFragment(), LoginFragment.class.getName()).commit();
    }
}