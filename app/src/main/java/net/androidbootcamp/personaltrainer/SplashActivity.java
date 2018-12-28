package net.androidbootcamp.personaltrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ImageView imgRotate = (ImageView)findViewById(R.id.imgSplash);
        imgRotate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation));
        final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotation);
        final Animation animation_2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.antirotation);
        final Animation animation_3 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        imgRotate.startAnimation(animation_2);
        animation_2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgRotate.startAnimation(animation_1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation_1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgRotate.startAnimation(animation_3);
                finish();
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

