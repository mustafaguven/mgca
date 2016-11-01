package com.mgcleanarchitecture.di.module.interactor;

import com.mgcleanarchitecture.di.name.Name;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.network.TestService;
import com.mgcleanarchitecture.ui.login.LoginInteractor;
import com.mgcleanarchitecture.ui.login.LoginMvp;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import rx.Scheduler;

@Module public class LoginInteractorModule {

  @Provides @PerActivity public LoginMvp.Interactor provideInteractor(
      TestService testService, @Named(Name.MAIN_SCHEDULER) Scheduler mainScheduler,
      @Named(Name.WORKER_SCHEDULER) Scheduler workerScheduler
  ) {
    return new LoginInteractor(testService, mainScheduler, workerScheduler);
  }
}
