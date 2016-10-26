package com.dugun.di.module.activity;

import android.app.Activity;
import com.dugun.di.module.ActivityModule;
import com.dugun.di.scopes.PerActivity;
import com.dugun.ui.login.LoginMvp;
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
