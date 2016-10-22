package com.dugun.di.module;

import android.app.Activity;
import com.dugun.di.scopes.PerActivity;
import dagger.Module;

@Module public class SplashActivityModule extends ActivityModule {

  public SplashActivityModule(Activity activity) {
    super(activity);
  }
}
