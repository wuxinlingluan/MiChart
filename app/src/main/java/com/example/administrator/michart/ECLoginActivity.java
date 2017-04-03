package com.example.administrator.michart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

//登陆界面
public class ECLoginActivity extends BaseActivity {

    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.et_psw)
    EditText etPsw;
    @InjectView(R.id.bt_register)
    Button btRegister;
    @InjectView(R.id.bt_)
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eclogin);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.bt_register, R.id.bt_})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_register://注册
                signup();
                break;
            case R.id.bt_://登陆
                signin();
                break;
        }
    }
    //登陆
    private void signin() {
    EMClient.getInstance().login(etUsername.getText().toString().trim(), etPsw.getText().toString().trim(), new EMCallBack() {
    @Override
    public void onSuccess() {
        startActivity(new Intent(ECLoginActivity.this,MainActivity.class));
        finish();
    }

    @Override
    public void onError(int i, String s) {
        Toast.makeText(ECLoginActivity.this, "注册失败,错误码:"+i+" ,失败原因"+s.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgress(int i, String s) {

    }
});
    }

    //注册
    private void signup() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        EMClient.getInstance().createAccount(etUsername.getText().toString().trim(),etPsw.getText().toString().trim());
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                        Toast.makeText(ECLoginActivity.this, "注册失败,错误码:"+e.getErrorCode()+" ,失败原因"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }).start();
    }

}
