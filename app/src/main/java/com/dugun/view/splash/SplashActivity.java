package com.dugun.view.splash;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.dugun.R;
import com.dugun.di.component.SplashActivityComponent;
import com.dugun.di.module.SplashActivityModule;
import com.dugun.flow_controller.FlowController;
import com.dugun.view.base.BaseActivity;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

  @Inject Picasso picasso;

  @BindView(R.id.splash_image) ImageView splashImage;

  private SplashActivityComponent component;

  @Override public void onCreate(
      Bundle savedInstanceState
  ) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_activity);
    if (component == null) {
      component =
          getDugunApplication().getApplicationComponent().plus(new SplashActivityModule(this));
    }
    component.inject(this);
    ButterKnife.bind(this);

    picasso.load("http://webrazzi.com/wp-content/uploads/2013/06/dugun_com_logo_square-225x224.jpg")
        //.resize(50, 50)
        //.centerCrop()
        .into(splashImage);

    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        FlowController.launchLoginActivity(SplashActivity.this);
      }
    }, 2000);
  }
}
