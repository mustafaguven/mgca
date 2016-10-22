package com.dugun.application;

import android.app.Application;
import com.dugun.di.component.ApplicationComponent;
import com.dugun.di.component.DugunAppComponent;

public class DugunApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    injectComponents();
  }

  private void injectComponents() {
    if (this.applicationComponent == null) {
      this.applicationComponent = DugunAppComponent.InitiliazerClass.init(this);
    }
    this.applicationComponent.inject(this);
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
