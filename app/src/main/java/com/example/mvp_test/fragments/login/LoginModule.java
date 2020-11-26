package com.example.mvp_test.fragments.login;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class LoginModule {

    @Provides
    LoginModel provideLoginModel() {
        return new LoginModelImpl();
    }

    @Provides
    LoginPresenter provideLoginPresenter(LoginModel model) {
        return new LoginPresenterImpl(model);
    }
}
