package com.mgcleanarchitecture.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import com.mgcleanarchitecture.R;
import com.mgcleanarchitecture.di.component.LoginActivityComponent;
import com.mgcleanarchitecture.di.module.activity.LoginActivityModule;
import com.mgcleanarchitecture.model.TestModel;
import com.mgcleanarchitecture.ui.base.RevealBackgroundedActivity;
import com.mgcleanarchitecture.util.KeyboardUtil;
import javax.inject.Inject;

public class LoginActivity extends RevealBackgroundedActivity implements LoginMvp.View {

  @Inject KeyboardUtil keyboardUtil;
  @Inject LoginMvp.Presenter presenter;

  @BindView(R.id.evMail) EditText evMail;
  @BindView(R.id.evPassword) EditText evPassword;

  private LoginActivityComponent loginComponent;

  @OnEditorAction({ R.id.evMail, R.id.evPassword }) boolean onEditorAction(
      TextView v, int actionId, KeyEvent event
  ) {
    if (actionId == EditorInfo.IME_ACTION_DONE) {
      keyboardUtil.hideKeyboard();
      presenter.onLoginClicked(evMail.getText().toString(), evPassword.getText().toString());
      return true;
    }
    return false;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (loginComponent == null) {
      loginComponent =
          getMyApplication().getApplicationComponent().plus(new LoginActivityModule(this));
    }
    loginComponent.inject(this);

    setContentView(R.layout.login_activity);
    ButterKnife.bind(this);
    setupRevealBackground();
  }

  @Override public void showTestModel(TestModel testModel) {
    Toast.makeText(this, testModel.getBody(), Toast.LENGTH_SHORT).show();
  }

  @Override public void showInvalidMailWarning(@StringRes int resId) {
    evMail.requestFocus();
    evMail.setError(getString(resId));
  }

  @Override public void showInvalidPasswordWarning(@StringRes int resId) {
    evPassword.requestFocus();
    evPassword.setError(getString(resId));
  }

  @Override protected void onDestroy() {

    super.onDestroy();
  }
}
