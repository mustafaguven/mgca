package com.dugun.di.module;

import android.app.Activity;
import com.dugun.di.name.Name;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module public class LoginActivityModule extends ActivityModule {

  public LoginActivityModule(Activity activity) {
    super(activity);
  }

  @Provides @Named(Name.WORKER) String provideOrnek() {
    return "ashdlashd";
  }
}
