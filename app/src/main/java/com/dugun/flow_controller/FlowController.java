package com.dugun.flow_controller;

import android.content.Context;
import android.content.Intent;
import com.dugun.view.login.LoginActivity;

public class FlowController {

  public static void launchLoginActivity(Context context) {
    Intent intent = new Intent(context, LoginActivity.class);
    context.startActivity(intent);
  }
}
