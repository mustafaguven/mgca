package com.mgcleanarchitecture.di.module.utility;

import com.mgcleanarchitecture.util.SpringAnimationUtil;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class SpringAnimationUtilModule {

  @Provides @Singleton SpringAnimationUtil provideSpringAnimationUtil(Bus bus) {
    return new SpringAnimationUtil(bus);
  }
}
