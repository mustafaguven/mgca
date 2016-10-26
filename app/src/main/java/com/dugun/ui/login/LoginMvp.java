package com.dugun.ui.login;

import android.support.annotation.StringRes;
import com.dugun.model.TestModel;
import com.dugun.ui.base.PresenterLifecycle;
import rx.Observable;

public interface LoginMvp {

  interface View {

    void showTestModel(TestModel testModel);

    void showInvalidMailWarning(@StringRes int login_invalid_evMail_text);

    void showInvalidPasswordWarning(@StringRes int login_invalid_evPassword_text);
  }

  interface Presenter extends PresenterLifecycle {

    void onLoginClicked(String toString, String s);
  }

  interface Interactor {
    Observable<TestModel> getTestModel();
  }
}
