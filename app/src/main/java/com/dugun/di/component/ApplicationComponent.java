package com.dugun.di.component;

import com.dugun.application.MyApplication;
import com.dugun.di.module.activity.LoginActivityModule;
import com.dugun.di.module.activity.SplashActivityModule;

public interface ApplicationComponent {

  void inject(MyApplication application);

  SplashActivityComponent plus(SplashActivityModule splashActivityModule);

  LoginActivityComponent plus(LoginActivityModule loginActivityModule);
}
