package com.dugun.di.module;

import android.app.Activity;
import com.dugun.di.scopes.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
  protected final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity Activity provideActivityContext(){
    return this.activity;
  }
}
