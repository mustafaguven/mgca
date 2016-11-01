package com.mgcleanarchitecture.ui.login;

import com.mgcleanarchitecture.R;
import com.mgcleanarchitecture.cache.UserCache;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.model.TestModel;
import com.mgcleanarchitecture.ui.base.BaseSubscriber;
import javax.inject.Inject;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

@PerActivity public class LoginPresenter implements LoginMvp.Presenter {

  private final LoginMvp.View view;
  private final LoginMvp.Interactor interactor;
  private final CompositeSubscription subscriptions;
  private final UserCache userPreference;

  @Inject LoginPresenter(
      LoginMvp.View view, LoginMvp.Interactor interactor, CompositeSubscription subscriptions,
      UserCache userPreference
  ) {
    this.view = view;
    this.interactor = interactor;
    this.subscriptions = subscriptions;
    this.userPreference = userPreference;
  }

  @Override public void onLoginClicked(String mail, String password) {
    if (!isValidMail(mail)) {
      view.showInvalidMailWarning(R.string.login_invalid_evMail_text);
    } else if (!isValidPassword(password)) {
      view.showInvalidPasswordWarning(R.string.login_invalid_evPassword_text);
    } else {
      subscriptions.add(subscriberForTestModel());
    }
  }

  private Subscription subscriberForTestModel() {
    return interactor.getTestModel().subscribe(new BaseSubscriber<TestModel>() {
      @Override public void onNext(TestModel testModel) {
        userPreference.setUser(testModel);
        view.showTestModel(testModel);
      }
    });
  }

  private boolean isValidMail(String mail) {
    return !mail.isEmpty();
  }

  private boolean isValidPassword(String password) {
    return !password.isEmpty();
  }
}
