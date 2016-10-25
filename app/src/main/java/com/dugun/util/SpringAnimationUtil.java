package com.dugun.util;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.squareup.otto.Bus;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class SpringAnimationUtil implements SpringListener {

  private final static double TENSION = 800;
  private final static double DAMPER = 20; //friction
  private Spring mSpring;
  private final Bus bus;

  @Inject public SpringAnimationUtil(Bus bus) {
    this.bus = bus;
    SpringSystem mSpringSystem = SpringSystem.create();
    mSpring = mSpringSystem.createSpring();
    mSpring.addListener(this);
    SpringConfig config = new SpringConfig(TENSION, DAMPER);
    mSpring.setSpringConfig(config);
  }

  @Override public void onSpringUpdate(Spring spring) {
    bus.post(new UpdateEvent(EventType.ON_UPDATE, spring, getScale(spring)));
    if (getScale(spring) < 0.7f) {
      setEndValue(0f);
    }
  }

  @Override public void onSpringAtRest(Spring spring) {
    bus.post(new UpdateEvent(EventType.AT_REST, spring, getScale(spring)));
  }

  @Override public void onSpringActivate(Spring spring) {
    bus.post(new UpdateEvent(EventType.ON_ACTIVATE, spring, getScale(spring)));
  }

  @Override public void onSpringEndStateChange(Spring spring) {
    bus.post(new UpdateEvent(EventType.ON_ENDSTATECHANGE, spring, getScale(spring)));
  }

  private float getScale(Spring spring) {
    float value = (float) spring.getCurrentValue();
    return 1f - (value * 0.5f);
  }

  public void setEndValue(float val) {
    mSpring.setEndValue(val);
  }

  public void run() {
    setEndValue(1f);
  }

  public final class UpdateEvent {

    public EventType getEventType() {
      return eventType;
    }

    public Spring getSpring() {
      return spring;
    }

    public float getScale() {
      return scale;
    }

    private final EventType eventType;
    private final Spring spring;
    private final float scale;

    UpdateEvent(EventType type, Spring spring, float scale) {
      this.eventType = type;
      this.spring = spring;
      this.scale = scale;
    }
  }

  private enum EventType {ON_UPDATE, AT_REST, ON_ACTIVATE, ON_ENDSTATECHANGE}
}
