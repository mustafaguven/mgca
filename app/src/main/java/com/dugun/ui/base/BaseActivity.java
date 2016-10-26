package com.dugun.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.dugun.application.MyApplication;
import com.squareup.otto.Bus;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

  @Inject Bus bus;
  @Inject CompositeSubscription subscriptions;

  @Override public void onCreate(
      Bundle savedInstanceState, PersistableBundle persistentState
  ) {
    super.onCreate(savedInstanceState, persistentState);
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
