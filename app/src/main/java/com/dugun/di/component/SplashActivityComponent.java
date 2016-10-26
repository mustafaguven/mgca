package com.dugun.di.component;

import com.dugun.di.module.activity.SplashActivityModule;
import com.dugun.di.scopes.PerActivity;
import com.dugun.ui.splash.SplashActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent {

  public void inject(SplashActivity splashActivity);
}
