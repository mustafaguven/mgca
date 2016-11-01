package com.mgcleanarchitecture.di.module.presenter;

import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.ui.login.LoginMvp;
import com.mgcleanarchitecture.ui.login.LoginPresenter;
import dagger.Binds;
import dagger.Module;

@Module public abstract class LoginPresenterModule {

  @Binds @PerActivity public abstract LoginMvp.Presenter providePresenter(
      LoginPresenter LoginPresenter
  );
}
