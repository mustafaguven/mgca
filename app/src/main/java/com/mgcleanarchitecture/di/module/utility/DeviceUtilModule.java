package com.mgcleanarchitecture.di.module.utility;

import com.mgcleanarchitecture.application.MyApplication;
import com.mgcleanarchitecture.util.DeviceUtil;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class DeviceUtilModule {

  @Provides @Singleton DeviceUtil provideDeviceUtil(MyApplication myApplication) {
    return new DeviceUtil(myApplication);
  }
}
