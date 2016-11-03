package com.mgcleanarchitecture.security;

import android.app.Activity;
import com.mgcleanarchitecture.cache.ApplicationCache;
import javax.inject.Inject;

public class AuthenticationController {

  private final ApplicationCache applicationCache;

  @Inject public AuthenticationController(
      ApplicationCache applicationCache
  ) {
    this.applicationCache = applicationCache;
  }

  public void authenticate(Activity activity) {
    //GeneratedClass generatedClass = new GeneratedClass();
    /*if (activity.getClass().isAnnotationPresent(AuthenticationRequired.class)) {
      Timber.d("authenticationRequired: yes");
      if (this.applicationCache.isUserAuthenticated()) {
        Timber.d("isUserAuthenticated: yes");
      } else {
        activity.finish();
        FlowController.launchLoginActivity(activity);
        Timber.d("isUserAuthenticated: no");
      }
    }*/
  }
}
