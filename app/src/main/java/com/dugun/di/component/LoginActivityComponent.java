package com.dugun.di.component;

import com.dugun.di.module.activity.LoginActivityModule;
import com.dugun.di.module.interactor.LoginInteractorModule;
import com.dugun.di.module.presenter.LoginPresenterModule;
import com.dugun.di.scopes.PerActivity;
import com.dugun.ui.login.LoginActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = {
    LoginActivityModule.class, LoginPresenterModule.class, LoginInteractorModule.class
}) public interface LoginActivityComponent {

  void inject(LoginActivity loginActivity);
}
