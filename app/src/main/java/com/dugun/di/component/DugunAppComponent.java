package com.dugun.di.component;

import com.dugun.application.DugunApplication;
import com.dugun.di.module.ApplicationModule;
import com.dugun.di.module.RestServicesModule;
import com.dugun.di.module.UtilityModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { ApplicationModule.class, UtilityModule.class, RestServicesModule.class })
public interface DugunAppComponent extends ApplicationComponent {

  final class InitiliazerClass {
    private InitiliazerClass() {
    }

    public static DugunAppComponent init(DugunApplication application) {
      return DaggerDugunAppComponent.builder()
          .applicationModule(new ApplicationModule(application))
          .build();
    }
  }
}
