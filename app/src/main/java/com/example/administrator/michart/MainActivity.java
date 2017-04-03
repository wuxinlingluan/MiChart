package com.example.administrator.michart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

//主页
public class MainActivity extends BaseActivity {

    @InjectView(R.id.bt_chat)
    Button btChat;
    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.bt_logout)
    Button btLogout;

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
        ButterKnife.inject(this);

    }
    @OnClick({R.id.bt_chat, R.id.bt_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_chat://聊天
                startChat();
                break;
            case R.id.bt_logout://退出
                logOut();
                break;
        }
    }
    //开始聊天
    private void startChat() {
        if (etUsername.getText().toString().equals(EMClient.getInstance().getCurrentUser())){
            Toast.makeText(this, "不能跟自己聊天", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Intent intent=new Intent(this,ChatActivity.class);
            intent.putExtra(EaseConstant.EXTRA_USER_ID,etUsername.getText().toString().trim());
            intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
            startActivity(intent);
        }

    }
    //退出登陆
    private void logOut() {
        EMClient.getInstance().logout(false, new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(ECLoginActivity.class,true);
            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(MainActivity.this, "退出失败,错误码:"+i+" ,失败原因"+s.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
