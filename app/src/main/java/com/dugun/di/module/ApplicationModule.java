package com.dugun.di.module;

import com.dugun.application.DugunApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private final DugunApplication application;

  public ApplicationModule(DugunApplication application) {
    this.application = application;
  }

  @Provides @Singleton DugunApplication provideDugunApplication() {
    return this.application;
  }
}
