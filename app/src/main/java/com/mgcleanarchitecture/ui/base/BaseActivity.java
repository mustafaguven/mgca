package com.mgcleanarchitecture.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.mgcleanarchitecture.application.MyApplication;
import com.squareup.otto.Bus;
import javax.inject.Inject;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

  @Inject Bus bus;
  @Inject CompositeSubscription subscriptions;

  @Override public void onCreate(
      Bundle savedInstanceState
  ) {
    super.onCreate(savedInstanceState);
    getMyApplication().getAuthenticationController().authenticate(this);
  }

  public MyApplication getMyApplication() {
    return (MyApplication) getApplication();
  }

  @Override protected void onStart() {
    super.onStart();
    bus.register(this);
  }

  @Override protected void onStop() {
    bus.unregister(this);
    super.onStop();
  }

  @Override protected void onDestroy() {
    Timber.d("onDestroy => subscriptions.unsubscribe()");
    subscriptions.unsubscribe();
    super.onDestroy();
  }
}
