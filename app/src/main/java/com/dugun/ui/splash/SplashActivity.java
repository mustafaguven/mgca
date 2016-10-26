package com.dugun.ui.splash;

import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dugun.R;
import com.dugun.di.component.SplashActivityComponent;
import com.dugun.di.module.activity.SplashActivityModule;
import com.dugun.flow_controller.FlowController;
import com.dugun.ui.base.BaseActivity;
import com.dugun.util.DeviceUtil;
import com.dugun.util.SpringAnimationUtil;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

  @Inject Picasso picasso;
  @Inject SpringAnimationUtil springAnimationUtil;
  @Inject DeviceUtil deviceUtil;

  @BindView(R.id.iv_splash) ImageView ivSplash;

  private SplashActivityComponent component;

  @OnClick(R.id.iv_splash) void ivSplashClicked() {
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
