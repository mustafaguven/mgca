package com.dugun.di.component;

import com.dugun.application.MyApplication;
import com.dugun.di.module.ApplicationModule;
import com.dugun.di.module.utility.DeviceUtilModule;
import com.dugun.di.module.network.RestServicesModule;
import com.dugun.di.module.utility.SpringAnimationUtilModule;
import com.dugun.di.module.utility.UtilityModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    ApplicationModule.class, UtilityModule.class, RestServicesModule.class, DeviceUtilModule.class,
    SpringAnimationUtilModule.class
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
