package com.mgcleanarchitecture.cache;

import android.content.SharedPreferences;
import com.google.gson.Gson;

public class ApplicationCache {

  private final SharedPreferences applicationSharedPreferences;
  private final Gson gson;
  private boolean userAuthenticated;

  public ApplicationCache(SharedPreferences applicationPreferences, Gson gson) {
    this.applicationSharedPreferences = applicationPreferences;
    this.gson = gson;
  }

  public boolean isUserAuthenticated() {
    return userAuthenticated;
  }
}
