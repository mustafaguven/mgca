package com.mgcleanarchitecture.ui.login;

import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.model.TestModel;
import com.mgcleanarchitecture.network.TestService;
import javax.inject.Inject;
import rx.Observable;
import rx.Scheduler;

@PerActivity public class LoginInteractor implements LoginMvp.Interactor {

  private final TestService testService;
  private final Scheduler mainScheduler;
  private final Scheduler workerScheduler;

  @Inject public LoginInteractor(
      TestService testService, Scheduler mainScheduler, Scheduler workerScheduler
  ) {
    this.testService = testService;
    this.mainScheduler = mainScheduler;
    this.workerScheduler = workerScheduler;
  }

  @Override public Observable<TestModel> getTestModel() {

    return testService.getTestModel("1").subscribeOn(workerScheduler).observeOn(mainScheduler);
    /*testModel.subscribe(new Subscriber<TestModel>() {
      @Override public void onCompleted() {
        Log.e("oncompleted", "asdasd");
      }

      @Override public void onError(Throwable e) {
        Log.e("error", e.getMessage());
      }

      @Override public void onNext(TestModel testModel) {
        Log.e("onnext", testModel.getTitle());
      }
    });*/
  }
}
