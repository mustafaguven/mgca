package com.dugun.di.component;

import com.dugun.di.module.LoginActivityModule;
import com.dugun.di.scopes.PerActivity;
import com.dugun.view.login.LoginActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent {

  void inject(LoginActivity loginActivity);
}
