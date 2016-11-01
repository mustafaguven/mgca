package com.mgcleanarchitecture.di.component;

import com.mgcleanarchitecture.application.MyApplication;
import com.mgcleanarchitecture.di.module.activity.LoginActivityModule;
import com.mgcleanarchitecture.di.module.activity.SplashActivityModule;

public interface ApplicationComponent {

  void inject(MyApplication application);

  SplashActivityComponent plus(SplashActivityModule splashActivityModule);

  LoginActivityComponent plus(LoginActivityModule loginActivityModule);
}
