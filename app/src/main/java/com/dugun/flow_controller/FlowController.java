package com.dugun.flow_controller;

import android.content.Context;
import android.content.Intent;
import com.dugun.constant.BundleKey;
import com.dugun.ui.login.LoginActivity;

public class FlowController {

  public static void launchLoginActivity(Context context, int[] startingLocation) {
    Intent intent = new Intent(context, LoginActivity.class).putExtra(BundleKey.STARTING_LOCATION,
        startingLocation);
    context.startActivity(intent);
  }
}
