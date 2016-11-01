package com.mgcleanarchitecture.security;

import android.app.Activity;
import com.mgcleanarchitecture.annotation.AuthenticationRequired;
import com.mgcleanarchitecture.cache.ApplicationCache;
import com.mgcleanarchitecture.flow_controller.FlowController;
import javax.inject.Inject;
import timber.log.Timber;

public class AuthenticationController {

  private final ApplicationCache applicationCache;

  @Inject public AuthenticationController(
      ApplicationCache applicationCache
  ) {
    this.applicationCache = applicationCache;
  }

  public void authenticate(Activity activity) {
    if (activity.getClass().isAnnotationPresent(AuthenticationRequired.class)) {
      Timber.d("authenticationRequired: yes");
      if (this.applicationCache.isUserAuthenticated()) {
        Timber.d("isUserAuthenticated: yes");
      } else {
        activity.finish();
        FlowController.launchLoginActivity(activity);
        Timber.d("isUserAuthenticated: no");
      }
    }
  }
}
