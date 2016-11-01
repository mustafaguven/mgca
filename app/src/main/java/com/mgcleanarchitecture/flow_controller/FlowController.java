package com.mgcleanarchitecture.flow_controller;

import android.content.Context;
import android.content.Intent;
import com.mgcleanarchitecture.constant.BundleKey;
import com.mgcleanarchitecture.ui.login.LoginActivity;
import com.mgcleanarchitecture.ui.main.MainActivity;

public class FlowController {

  public static void launchLoginActivity(Context context) {
    launchLoginActivity(context, null);
  }

  public static void launchLoginActivity(Context context, int[] startingLocation) {
    Intent intent = new Intent(context, LoginActivity.class).putExtra(BundleKey.STARTING_LOCATION,
        startingLocation);
    context.startActivity(intent);
  }

  public static void launchMainActivity(Context context) {
    Intent intent = new Intent(context, MainActivity.class);
    context.startActivity(intent);
  }
}
