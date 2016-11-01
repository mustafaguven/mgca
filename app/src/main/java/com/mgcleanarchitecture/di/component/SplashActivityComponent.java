package com.mgcleanarchitecture.di.component;

import com.mgcleanarchitecture.di.module.activity.SplashActivityModule;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.ui.splash.SplashActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent {

  public void inject(SplashActivity splashActivity);
}
