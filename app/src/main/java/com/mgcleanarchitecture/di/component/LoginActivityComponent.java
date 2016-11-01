package com.mgcleanarchitecture.di.component;

import com.mgcleanarchitecture.di.module.activity.LoginActivityModule;
import com.mgcleanarchitecture.di.module.interactor.LoginInteractorModule;
import com.mgcleanarchitecture.di.module.presenter.LoginPresenterModule;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.ui.login.LoginActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = {
    LoginActivityModule.class, LoginPresenterModule.class, LoginInteractorModule.class
}) public interface LoginActivityComponent {

  void inject(LoginActivity loginActivity);
}
