package com.mgcleanarchitecture.di.module.security;

import com.mgcleanarchitecture.cache.ApplicationCache;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.security.AuthenticationController;
import dagger.Module;
import javax.inject.Singleton;

@Module public class AuthenticationControllerModule {
  @PerActivity @Singleton AuthenticationController provideAuthenticationController(
      ApplicationCache applicationCache
  ) {
    return new AuthenticationController(applicationCache);
  }
}
