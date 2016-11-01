package com.mgcleanarchitecture.di.module;

import android.app.Activity;
import com.mgcleanarchitecture.di.scopes.PerActivity;
import com.mgcleanarchitecture.util.KeyboardUtil;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module public class ActivityModule {
  protected final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  public @Provides @PerActivity Activity provideActivityContext() {
    return this.activity;
  }

  public @Provides @PerActivity Picasso providePicasso() {
    return Picasso.with(this.activity);
  }

  public @Provides @PerActivity KeyboardUtil provideKeyboardUtil() {
    return new KeyboardUtil(this.activity);
  }

  public @Provides @PerActivity CompositeSubscription provideCompositeSubscription() {
    return new CompositeSubscription();
  }
}
