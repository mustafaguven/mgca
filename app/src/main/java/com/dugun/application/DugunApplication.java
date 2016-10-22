package com.dugun.application;

import android.app.Application;
import com.dugun.di.component.ApplicationComponent;
import com.dugun.di.component.DugunAppComponent;
import com.squareup.otto.Bus;
import javax.inject.Inject;

public class DugunApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Inject Bus bus;

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

  public Bus getBus() {
    return this.bus;
  }
}
