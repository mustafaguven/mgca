package com.dugun.di.component;

import com.dugun.application.DugunApplication;
import com.dugun.di.module.LoginActivityModule;

public interface ApplicationComponent {

  void inject(DugunApplication application);

  LoginActivityComponent plus(LoginActivityModule loginActivityModule);
}
