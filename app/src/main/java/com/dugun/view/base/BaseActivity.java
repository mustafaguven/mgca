package com.dugun.view.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.dugun.application.DugunApplication;

public class BaseActivity extends AppCompatActivity {

  @Override public void onCreate(
      Bundle savedInstanceState, PersistableBundle persistentState
  ) {
    super.onCreate(savedInstanceState, persistentState);
  }

  public DugunApplication getDugunApplication() {
    return (DugunApplication) getApplication();
  }
}
