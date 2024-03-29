package com.myframeanimation.bmichaelh13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.myframeanimation.bmichaelh13.R.id;

import static com.myframeanimation.bmichaelh13.R.id.*;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable batAnimation;
    private ImageView batImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batImage = (ImageView) findViewById(BatId);
        batImage.setBackgroundResource(R.drawable.bat_anim);
        batAnimation = (AnimationDrawable) batImage.getBackground();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        batAnimation.start();

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Animation startanimation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadein_animation);
                    batImage.startAnimation(startanimation);


                
                batAnimation.stop();
            }
        }, 50);

        return super.onTouchEvent(event);
    }
}
