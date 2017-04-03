package com.example.administrator.michart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ${sheldon} on 2017/4/3.
 */

public class BaseActivity extends AppCompatActivity {
    public void  startActivity(Class clazz,boolean isFinish){
        startActivity(new Intent(this,clazz));
        if (isFinish){
            finish();
        }
    }
}
