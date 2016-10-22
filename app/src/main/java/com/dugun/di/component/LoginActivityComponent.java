package com.dugun.di.component;

import com.dugun.di.module.LoginActivityModule;
import com.dugun.login.LoginActivity;
import dagger.Subcomponent;
import javax.inject.Singleton;

@Singleton @Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent {

  void inject(LoginActivity loginActivity);
}
