package com.mgcleanarchitecture.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.mgcleanarchitecture.application.MyApplication;

public final class DeviceUtil {

  private static final float MAGIC_DIVIDER = 160f;
  private final MyApplication myApplication;
  private int deviceWidth = 0;
  private int deviceHeight = 0;
  private int statusBarHeight = 0;

  public DeviceUtil(MyApplication application) {
    this.myApplication = application;
  }

  public int getDeviceWidth() {
    if (deviceWidth > 0) {
      return deviceWidth;
    }
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    deviceWidth = size.x;
    return deviceWidth;
  }

  public int getDeviceHeight() {
    if (deviceHeight > 0) {
      return deviceHeight;
    }
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    deviceHeight = size.y;
    return deviceHeight;
  }

  public int getStatusBarHeight() {
    if (statusBarHeight > 0) {
      return statusBarHeight;
    }
    int result = 0;
    int resourceId =
        this.myApplication.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      result = this.myApplication.getResources().getDimensionPixelSize(resourceId);
    }
    statusBarHeight = result;
    return statusBarHeight;
  }

  public int getDeviceHeightWithoutStatusBar() {
    return getDeviceHeight() - getStatusBarHeight();
  }

  public float convertDpToPixel(float dp) {
    DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
    float px = dp * (metrics.densityDpi / MAGIC_DIVIDER);
    return Math.round(px);
  }

  private WindowManager getWindowManager() {
    return (WindowManager) this.myApplication.getSystemService(Context.WINDOW_SERVICE);
  }

  public int[] findStartingLocation(View view) {
    int[] startingLocation = new int[2];
    view.getLocationOnScreen(startingLocation);
    startingLocation[0] = (startingLocation[0] + (view.getWidth() / 2));
    startingLocation[1] = (startingLocation[1] + (view.getHeight() / 2) - getStatusBarHeight());
    return startingLocation;
  }
}
