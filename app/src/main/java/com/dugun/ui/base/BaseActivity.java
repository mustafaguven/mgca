package com.dugun.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.dugun.application.MyApplication;
import com.dugun.util.DeviceUtil;
import com.squareup.otto.Bus;
import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {

  @Inject Bus bus;

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
}
