package com.mgcleanarchitecture.di.module.utility;

import com.mgcleanarchitecture.application.MyApplication;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class LeakCanaryModule {
  @Provides @Singleton RefWatcher provideLeakCanaryRefWatcher(MyApplication application) {
    return LeakCanary.install(application);
  }
}
