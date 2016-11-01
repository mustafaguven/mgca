package com.mgcleanarchitecture.di.module.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.mgcleanarchitecture.application.MyApplication;
import com.mgcleanarchitecture.cache.ApplicationCache;
import com.mgcleanarchitecture.cache.UserCache;
import com.mgcleanarchitecture.di.name.Name;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class CacheModule {

  @Provides @Singleton @Named(Name.APPLICATION_SHARED_PREFERENCES)
  SharedPreferences provideApplicationSharedPreference(MyApplication application) {
    return application.getSharedPreferences(
        Name.APPLICATION_SHARED_PREFERENCES, Context.MODE_PRIVATE);
  }

  @Provides @Singleton @Named(Name.USER_SPECIFIED_SHARED_PREFERENCES)
  SharedPreferences provideUserSharedPreference(MyApplication application) {
    return application.getSharedPreferences(
        Name.USER_SPECIFIED_SHARED_PREFERENCES, Context.MODE_PRIVATE);
  }

  @Provides @Singleton ApplicationCache provideApplicationCache(
      @Named(Name.APPLICATION_SHARED_PREFERENCES) SharedPreferences applicationPreferences, Gson gson
  ) {
    return new ApplicationCache(applicationPreferences, gson);
  }

  @Provides @Singleton UserCache provideUserCache(
      @Named(Name.USER_SPECIFIED_SHARED_PREFERENCES) SharedPreferences userPreferences, Gson gson
  ) {
    return new UserCache(userPreferences, gson);
  }
}
