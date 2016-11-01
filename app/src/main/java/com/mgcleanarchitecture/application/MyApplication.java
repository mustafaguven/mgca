package com.mgcleanarchitecture.application;

import android.app.Application;
import com.mgcleanarchitecture.di.component.ApplicationComponent;
import com.mgcleanarchitecture.di.component.MyAppComponent;
import com.mgcleanarchitecture.security.AuthenticationController;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.otto.Bus;
import javax.inject.Inject;
import timber.log.Timber;

public class MyApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Inject Bus bus;
  @Inject AuthenticationController authenticationController;

  @Override public void onCreate() {
    super.onCreate();
    injectComponents();
    Timber.plant(new Timber.DebugTree());
    if (LeakCanary.isInAnalyzerProcess(this)) {
      return;
    }
    LeakCanary.install(this);
  }

  private void injectComponents() {
    if (this.applicationComponent == null) {
      this.applicationComponent = MyAppComponent.InitiliazerClass.init(this);
    }
    this.applicationComponent.inject(this);
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  public Bus getBus() {
    return this.bus;
  }

  public AuthenticationController getAuthenticationController() {
    return this.authenticationController;
  }
}
