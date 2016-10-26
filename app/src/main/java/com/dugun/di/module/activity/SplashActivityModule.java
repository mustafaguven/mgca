package com.dugun.di.module.activity;

import android.app.Activity;
import com.dugun.di.module.ActivityModule;
import dagger.Module;

@Module public class SplashActivityModule extends ActivityModule {

  public SplashActivityModule(Activity activity) {
    super(activity);
  }
}
