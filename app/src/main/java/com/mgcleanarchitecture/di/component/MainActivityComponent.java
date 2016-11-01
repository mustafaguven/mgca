package com.mgcleanarchitecture.di.component;

import com.mgcleanarchitecture.di.module.activity.MainActivityModule;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.ui.main.MainActivity;
import dagger.Subcomponent;

@PerActivity @Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {

  void inject(MainActivity mainActivity);
}
