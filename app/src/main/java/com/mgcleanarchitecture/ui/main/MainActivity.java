package com.mgcleanarchitecture.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;
import butterknife.BindView;
import com.mgcleanarchitecture.R;
import com.mgcleanarchitecture.annotation.AuthenticationRequired;
import com.mgcleanarchitecture.di.component.MainActivityComponent;
import com.mgcleanarchitecture.di.module.activity.MainActivityModule;
import com.mgcleanarchitecture.ui.base.BaseActivity;

@AuthenticationRequired public class MainActivity extends BaseActivity {

  @BindView(R.id.rlAuthentication) RelativeLayout rlAuthentication;
  private MainActivityComponent component;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    if (component == null) {
      component = getMyApplication().getApplicationComponent().plus(new MainActivityModule(this));
    }
    component.inject(this);
    setContentView(R.layout.main_activity);
  }
}
