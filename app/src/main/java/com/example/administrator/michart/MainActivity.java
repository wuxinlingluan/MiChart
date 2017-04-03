package com.example.administrator.michart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hyphenate.chat.EMClient;

//主页
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 判断sdk是否登录成功过，并没有退出和被踢，否则跳转到登陆界面
        if (!EMClient.getInstance().isLoggedInBefore()) {
            Intent intent = new Intent(this, ECLoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

    }
}
