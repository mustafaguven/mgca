package com.dugun.di.module;

import com.dugun.application.MyApplication;
import com.dugun.util.DeviceUtil;
import dagger.Module;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private final MyApplication application;

  @Inject DeviceUtil deviceUtil;

  public ApplicationModule(MyApplication application) {
    this.application = application;
  }

  @Provides @Singleton MyApplication provideMyApplication() {
    return this.application;
  }

  public DeviceUtil getDeviceUtil() {
    return this.deviceUtil;
  }
}
