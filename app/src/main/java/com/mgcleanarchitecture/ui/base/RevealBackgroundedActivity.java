package com.mgcleanarchitecture.ui.base;

import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.mgcleanarchitecture.R;
import com.mgcleanarchitecture.constant.BundleKey;
import com.mgcleanarchitecture.customview.RevealBackgroundView;

public class RevealBackgroundedActivity extends BaseActivity {

  protected void setupRevealBackground() {
    ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
    final RevealBackgroundView revealBackgroundView = new RevealBackgroundView(this);
    revealBackgroundView.setLayoutParams(
        new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));
    rootView.addView(revealBackgroundView, 0);

    if (getIntent() != null && getIntent().hasExtra(BundleKey.STARTING_LOCATION)) {
      revealBackgroundView.setFillPaintColor(
          ContextCompat.getColor(this, R.color.revealBackgroundViewColor));
      final int[] startingLocation = getIntent().getIntArrayExtra(BundleKey.STARTING_LOCATION);
      revealBackgroundView.getViewTreeObserver()
          .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override public boolean onPreDraw() {
              revealBackgroundView.getViewTreeObserver().removeOnPreDrawListener(this);
              revealBackgroundView.startFromLocation(startingLocation);
              return true;
            }
          });
    } else {
      revealBackgroundView.setToFinishedFrame();
    }
  }
}
