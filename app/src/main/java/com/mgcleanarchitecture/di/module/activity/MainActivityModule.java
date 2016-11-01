package com.mgcleanarchitecture.di.module.activity;

import android.app.Activity;
import com.mgcleanarchitecture.di.module.ActivityModule;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.ui.main.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module public class MainActivityModule extends ActivityModule {

  public MainActivityModule(Activity activity) {
    super(activity);
  }

  @Provides @PerActivity public MainActivity provideView() {
    return (MainActivity) provideActivityContext();
  }
}
