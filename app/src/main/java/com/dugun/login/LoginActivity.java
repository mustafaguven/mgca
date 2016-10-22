package com.dugun.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.dugun.R;
import com.dugun.base.BaseActivity;
import com.dugun.di.component.LoginActivityComponent;
import com.dugun.di.module.LoginActivityModule;
import com.dugun.di.name.Name;
import javax.inject.Inject;
import javax.inject.Named;

public class LoginActivity extends BaseActivity {

  @BindView(R.id.label) TextView label;
  @Inject @Named(Name.WORKER) String worker;

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

    label.setText(worker);
  }
}
