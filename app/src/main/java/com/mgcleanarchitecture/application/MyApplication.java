package com.mgcleanarchitecture.application;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.mgcleanarchitecture.BuildConfig;
import com.mgcleanarchitecture.di.component.ApplicationComponent;
import com.mgcleanarchitecture.di.component.MyAppComponent;
import com.mgcleanarchitecture.security.AuthenticationController;
import com.squareup.leakcanary.RefWatcher;
import com.squareup.otto.Bus;
import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;
import timber.log.Timber;

public class MyApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Inject Bus bus;
  @Inject AuthenticationController authenticationController;
  @Inject RefWatcher refWatcher;

  @Override public void onCreate() {
    super.onCreate();
    initFabric();
    Fabric.with(this, new Crashlytics());
    injectComponents();
    Timber.plant(new Timber.DebugTree());
  }

  private void initFabric() {
    if (BuildConfig.CRASHLYTICS) {
      final Fabric fabric = new Fabric.Builder(this)
          .kits(new Crashlytics())
          .kits(new Answers())
          .debuggable(true)
          .build();
      Fabric.with(fabric);
    }
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
