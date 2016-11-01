package com.mgcleanarchitecture.di.module.activity;

import android.app.Activity;
import com.mgcleanarchitecture.di.module.ActivityModule;
import dagger.Module;

@Module public class SplashActivityModule extends ActivityModule {

  public SplashActivityModule(Activity activity) {
    super(activity);
  }
}
