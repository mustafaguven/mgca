package com.mgcleanarchitecture.di.module.utility;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mgcleanarchitecture.di.name.Name;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module public class UtilityModule {

  @Provides @Singleton public Bus provideBus() {
    return new Bus(ThreadEnforcer.MAIN);
  }

  @Provides @Singleton public Gson providesGson() {
    return new GsonBuilder().create();
  }

  @Provides @Singleton @Named(Name.MAIN_SCHEDULER) public Scheduler provideMainScheduler() {
    return AndroidSchedulers.mainThread();
  }

  @Provides @Singleton @Named(Name.WORKER_SCHEDULER) public Scheduler provideWorkerScheduler() {
    return Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR);
  }
}
