package com.dugun.base;

import android.support.v7.app.AppCompatActivity;
import com.dugun.application.DugunApplication;

public class BaseActivity extends AppCompatActivity {

  public DugunApplication getDugunApplication() {
    return (DugunApplication) getApplication();
  }
}
