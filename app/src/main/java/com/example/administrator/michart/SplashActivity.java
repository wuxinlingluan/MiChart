package com.example.administrator.michart;

import android.animation.*;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.widget.ImageView;

import com.hyphenate.chat.EMClient;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SplashActivity extends BaseActivity {

    @InjectView(R.id.im)
    ImageView im;
    private long DURRATION=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);
        checkLogined();
    }

    //判断是否登陆
    private void checkLogined() {
        if (EMClient.getInstance().isLoggedInBefore() && EMClient.getInstance().isConnected()) {
            //已经登录
            startActivity(MainActivity.class, true);
        } else {
            //还未登陆
            ObjectAnimator alpha=new ObjectAnimator().ofFloat(im,"alpha",0,1).setDuration(DURRATION);
            alpha.start();
            alpha.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    startActivity(ECLoginActivity.class,true);
                }
            });
        }

    }

}
