package com.example.mvp_test.fragments.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvp_test.fragments.main.MainFragment;
import com.example.mvp_test.R;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment implements LoginView {

    private TextInputEditText   edtUserName;
    private TextInputEditText   edtPassword;
    private Button              btnLogin;

    @Inject
    LoginPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.bind(this);

        edtUserName = view.findViewById(R.id.edt_username);
        edtPassword = view.findViewById(R.id.edt_password);
        btnLogin    = view.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();

                presenter.verifyAccount(username, password);
            }
        });
    }

    @Override
    public void doLogin() {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_container, new MainFragment(), MainFragment.class.getName()).commit();
    }

    @Override
    public void doShowMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter.unbind();
    }
}