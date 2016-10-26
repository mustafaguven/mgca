package com.dugun.di.module.interactor;

import com.dugun.di.name.Name;
import com.dugun.di.scopes.PerActivity;
import com.dugun.network.TestService;
import com.dugun.ui.login.LoginInteractor;
import com.dugun.ui.login.LoginMvp;
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
