package com.dugun.view.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.dugun.R;
import com.dugun.di.component.LoginActivityComponent;
import com.dugun.di.module.LoginActivityModule;
import com.dugun.di.name.Name;
import com.dugun.model.TestModel;
import com.dugun.network.TestService;
import com.dugun.view.base.BaseActivity;
import javax.inject.Inject;
import javax.inject.Named;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

public class LoginActivity extends BaseActivity {

  @BindView(R.id.label) TextView label;
  @Inject TestService testService;
  @Inject @Named(Name.WORKER) Scheduler worker;
  @Inject @Named(Name.MAIN) Scheduler main;

  private LoginActivityComponent loginComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (loginComponent == null) {
      loginComponent =
          getDugunApplication().getApplicationComponent().plus(new LoginActivityModule(this));
    }
    loginComponent.inject(this);

    setContentView(R.layout.login_activity);
    ButterKnife.bind(this);

    Observable<TestModel> testModel =
        testService.getTestModel("1").subscribeOn(worker).observeOn(main);
    testModel.subscribe(new Subscriber<TestModel>() {
      @Override public void onCompleted() {
        Log.e("oncompleted", "asdasd");
      }

      @Override public void onError(Throwable e) {
        Log.e("error", e.getMessage());
      }

      @Override public void onNext(TestModel testModel) {
        Log.e("onnext", testModel.getTitle());
        label.setText(testModel.getBody());
      }
    });
  }
}
