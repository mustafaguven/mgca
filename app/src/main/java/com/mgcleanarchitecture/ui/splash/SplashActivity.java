package com.mgcleanarchitecture.ui.splash;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mgcleanarchitecture.BuildConfig;
import com.mgcleanarchitecture.R;
import com.mgcleanarchitecture.di.component.SplashActivityComponent;
import com.mgcleanarchitecture.di.module.activity.SplashActivityModule;
import com.mgcleanarchitecture.flow_controller.FlowController;
import com.mgcleanarchitecture.ui.base.BaseActivity;
import com.mgcleanarchitecture.util.DeviceUtil;
import com.mgcleanarchitecture.util.SpringAnimationUtil;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

  @Inject Picasso picasso;
  @Inject SpringAnimationUtil springAnimationUtil;
  @Inject DeviceUtil deviceUtil;

  @BindView(R.id.ivSplash) ImageView ivSplash;
  @BindView(R.id.tvVersion) TextView tvVersion;

  private SplashActivityComponent component;

  @OnClick(R.id.ivSplash) void ivSplashClicked() {
    FlowController.launchLoginActivity(
        SplashActivity.this, deviceUtil.findStartingLocation(ivSplash));
  }

  @Override public void onCreate(
      Bundle savedInstanceState
  ) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_activity);
    if (component == null) {
      component = getMyApplication().getApplicationComponent().plus(new SplashActivityModule(this));
    }
    component.inject(this);
    ButterKnife.bind(this);

    loadImages();
    tvVersion.setText(BuildConfig.VERSION_NAME);
  }

  private void loadImages() {
    picasso.load("https://lh3.ggpht"
        + ".com/XL0CrI8skkxnboGct-duyg-bZ_MxJDTrjczyjdU8OP2PM1dmj7SP4jL1K8JQeMIB3AM=w300")
        .into(ivSplash);

    //http://webrazzi.com/wp-content/uploads/2013/06/dugun_com_logo_square-225x224.jpg
  }


/*
  SPRING ANIMATION ORNEK
  @Subscribe public void onSpringAnimationEvent(SpringAnimationUtil.UpdateEvent updateEvent) {
    ivSplash.setScaleX(updateEvent.getScale());
    ivSplash.setScaleY(updateEvent.getScale());
    if (updateEvent.getEventType() == SpringAnimationUtil.EventType.AT_REST) {
      Log.e("onSpringAnimat: ", String.valueOf(updateEvent.getScale()));
    }
  }

  @Override public boolean onTouch(View view, MotionEvent motionEvent) {
    switch (motionEvent.getAction()) {
      case MotionEvent.ACTION_DOWN:
        springAnimationUtil.run();
        return true;
      case MotionEvent.ACTION_UP:
        springAnimationUtil.rest();
        return true;
    }
    return false;
  }*/
}
