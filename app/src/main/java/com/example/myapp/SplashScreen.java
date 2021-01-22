package com.example.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rakesh on 1/14/18.
 */

public class SplashScreen extends AppCompatActivity {

    private boolean isFirstAnimation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*Simple hold animation to hold ImageView in the centre of the screen at a slightly larger
        scale than the ImageView's original one.*/
        Animation hold = AnimationUtils.loadAnimation(this, R.anim.hold);

        /* Translates ImageView from current position to its original position, scales it from
        larger scale to its original scale.*/
        final Animation translateScale = AnimationUtils.loadAnimation(this, R.anim.translate_scale);

        final ImageView imageView = findViewById(R.id.header_icon);
//        TextView welcome_messgae=findViewById(R.id.welcome_messgae);

        translateScale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isFirstAnimation) {
                    imageView.clearAnimation();
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                isFirstAnimation = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        hold.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.clearAnimation();
                imageView.startAnimation(translateScale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(hold);


    }
}














//public class SplashActivity extends AppCompatActivity {
//ImageView ivTop,ivLoad,ivBttm;
//TextView textView;
//CharSequence charSequence;
//int index;
//long delay=200;
//Handler handler=new  Handler();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//        ivTop=findViewById(R.id.iv_top);
//        ivLoad=findViewById(R.id.iv_load);
//        ivBttm=findViewById(R.id.iv_bttm);
//        textView=findViewById(R.id.text_view);
//
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        Animation animation1= AnimationUtils.loadAnimation(this
//                ,R.anim.top_wave);
//        ivTop.setAnimation(animation1);
//        ObjectAnimator objectAnimator=ObjectAnimator.ofPropertyValuesHolder(
//                ivLoad,
//                PropertyValuesHolder.ofFloat("scaleX",1.2f),
//                PropertyValuesHolder.ofFloat("scaleY",1.2f)
//        );
//        objectAnimator.setDuration(500);
//        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        objectAnimator.start();
//
//
//
//        animatText(("Loading"));
//
//    }
//    Runnable runnable=new Runnable() {
//        @Override
//        public void run() {
//            textView.setText(charSequence.subSequence(0,index++));
//            if(index<=charSequence.length()){
//                handler.postDelayed(runnable,delay);
//            }
//        }
//    };
//    public  void animatText(CharSequence cs)
//    {
//        charSequence=cs;
//        index=0;
//        textView.setText("");
//        handler.removeCallbacks(runnable);
//        handler.postDelayed(runnable,delay);
//    }
//}









