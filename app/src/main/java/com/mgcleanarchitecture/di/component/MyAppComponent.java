package com.mgcleanarchitecture.di.component;

import com.mgcleanarchitecture.application.MyApplication;
import com.mgcleanarchitecture.di.module.ApplicationModule;
import com.mgcleanarchitecture.di.module.cache.CacheModule;
import com.mgcleanarchitecture.di.module.network.RestServicesModule;
import com.mgcleanarchitecture.di.module.security.AuthenticationControllerModule;
import com.mgcleanarchitecture.di.module.utility.DeviceUtilModule;
import com.mgcleanarchitecture.di.module.utility.LeakCanaryModule;
import com.mgcleanarchitecture.di.module.utility.SpringAnimationUtilModule;
import com.mgcleanarchitecture.di.module.utility.UtilityModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    ApplicationModule.class, UtilityModule.class, RestServicesModule.class, DeviceUtilModule.class,
    SpringAnimationUtilModule.class, CacheModule.class, AuthenticationControllerModule.class,
    LeakCanaryModule.class
}) public interface MyAppComponent extends ApplicationComponent {

  final class InitiliazerClass {
    private InitiliazerClass() {
    }

    public static MyAppComponent init(MyApplication application) {
      return DaggerMyAppComponent.builder()
          .applicationModule(new ApplicationModule(application))
          .build();
    }
  }
}
