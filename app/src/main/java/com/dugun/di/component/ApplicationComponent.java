package com.dugun.di.component;

import com.dugun.application.DugunApplication;
import com.dugun.di.module.LoginActivityModule;
import com.dugun.di.module.SplashActivityModule;

public interface ApplicationComponent {

  void inject(DugunApplication application);

  SplashActivityComponent plus(SplashActivityModule splashActivityModule);

  LoginActivityComponent plus(LoginActivityModule loginActivityModule);
}
