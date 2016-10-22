package com.dugun.di.component;

import com.dugun.application.DugunApplication;
import com.dugun.di.module.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { ApplicationModule.class }) public interface DugunAppComponent
    extends ApplicationComponent {


  final class InitiliazerClass {
    private InitiliazerClass(){
    }

    public static DugunAppComponent init(DugunApplication application){
      return DaggerDugunAppComponent.builder()
          .applicationModule(new ApplicationModule(application))
          .build();
    }
  }
}
