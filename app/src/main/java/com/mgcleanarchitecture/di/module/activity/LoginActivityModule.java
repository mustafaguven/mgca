package com.mgcleanarchitecture.di.module.activity;

import android.app.Activity;
import com.mgcleanarchitecture.di.module.ActivityModule;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.ui.login.LoginMvp;
import dagger.Module;
import dagger.Provides;

@Module public class LoginActivityModule extends ActivityModule {

  public LoginActivityModule(Activity activity) {
    super(activity);
  }

  @Provides @PerActivity public LoginMvp.View provideView() {
    return ((LoginMvp.View) provideActivityContext());
  }
}
