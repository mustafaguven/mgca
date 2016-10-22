package com.dugun.di.component;

import com.dugun.di.module.SplashActivityModule;
import com.dugun.di.scopes.PerActivity;
import com.dugun.view.splash.SplashActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent {

  void inject(SplashActivity splashActivity);
}
