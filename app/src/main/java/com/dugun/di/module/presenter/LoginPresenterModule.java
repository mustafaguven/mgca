package com.dugun.di.module.presenter;

import com.dugun.di.scopes.PerActivity;
import com.dugun.ui.login.LoginMvp;
import com.dugun.ui.login.LoginPresenter;
import dagger.Binds;
import dagger.Module;

@Module public abstract class LoginPresenterModule {

  @Binds @PerActivity public abstract LoginMvp.Presenter providePresenter(
      LoginPresenter LoginPresenter
  );
}
