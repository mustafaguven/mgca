package com.mgcleanarchitecture.cache;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.mgcleanarchitecture.model.TestModel;

public class UserCache {

  private TestModel user;
  private final SharedPreferences userPreferences;
  private final Gson gson;

  public UserCache(SharedPreferences userPreferences, Gson gson) {
    this.userPreferences = userPreferences;
    this.gson = gson;
  }

  public void setUser(TestModel user) {
    this.user = user;
    this.userPreferences.edit().putString(CacheKey.USER_DATA, gson.toJson(this.user)).apply();
  }

  public TestModel getUser() {
    if (this.user == null) {
      if (this.userPreferences.contains(CacheKey.USER_DATA)) {
        String userData = this.userPreferences.getString(CacheKey.USER_DATA, null);
        if (userData != null) {
          this.user = gson.fromJson(userData, TestModel.class);
        }
      }
    }
    return this.user;
  }
}
