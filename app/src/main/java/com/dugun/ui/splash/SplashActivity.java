package com.dugun.ui.splash;

import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dugun.R;
import com.dugun.di.component.SplashActivityComponent;
import com.dugun.di.module.SplashActivityModule;
import com.dugun.flow_controller.FlowController;
import com.dugun.ui.base.BaseActivity;
import com.dugun.util.DeviceUtil;
import com.dugun.util.SpringAnimationUtil;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;
import hugo.weaving.DebugLog;
import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

  @Inject Picasso picasso;
  @Inject SpringAnimationUtil springAnimationUtil;
  @Inject DeviceUtil deviceUtil;

  @BindView(R.id.splash_image) ImageView splashImage;
  @BindView(R.id.splash_image_2) ImageView splashImage2;
  @BindDimen(R.dimen.splash_image_width) int SPLASH_IMAGE_WIDTH;
  @BindDimen(R.dimen.splash_image_height) int SPLASH_IMAGE_HEIGHT;

  private SplashActivityComponent component;

  @OnClick({ R.id.splash_image, R.id.splash_image_2 }) void splashImageClicked() {
    springAnimationUtil.run();
    FlowController.launchLoginActivity(this, deviceUtil.getStartingLocation(splashImage));
    overridePendingTransition(0, 0);
  }

  @DebugLog @Override public void onCreate(
      Bundle savedInstanceState
  ) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_activity);
    if (component == null) {
      component = getMyApplication().getApplicationComponent().plus(new SplashActivityModule(this));
    }
    component.inject(this);
    ButterKnife.bind(this);

    picasso.load("https://lh3.ggpht"
        + ".com/XL0CrI8skkxnboGct-duyg-bZ_MxJDTrjczyjdU8OP2PM1dmj7SP4jL1K8JQeMIB3AM=w300")
        .into(splashImage);

    picasso.load("http://www.iconsdb.com/icons/preview/orange/android-6-xxl.png")
        .into(splashImage2);
  }

  @Subscribe public void onSpringAnimationEvent(SpringAnimationUtil.UpdateEvent updateEvent) {
    splashImage.setScaleX(updateEvent.getScale());
    splashImage.setScaleY(updateEvent.getScale());
    splashImage2.setScaleX(updateEvent.getScale());
    splashImage2.setScaleY(updateEvent.getScale());
  }
}
