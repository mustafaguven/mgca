package com.dugun.view.splash;

import android.os.Bundle;
import com.dugun.R;
import com.dugun.flow_controller.FlowController;
import com.dugun.view.base.BaseActivity;

public class SplashActivity extends BaseActivity {

  @Override public void onCreate(
      Bundle savedInstanceState
  ) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_activity);
    try {
      Thread.sleep(2000);
      FlowController.launchLoginActivity(this);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
