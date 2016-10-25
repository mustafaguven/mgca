package com.dugun.di.module;

import com.dugun.application.MyApplication;
import com.dugun.util.DeviceUtil;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class DeviceUtilModule {

  @Provides @Singleton DeviceUtil provideDeviceUtil(MyApplication myApplication) {
    return new DeviceUtil(myApplication);
  }
}
