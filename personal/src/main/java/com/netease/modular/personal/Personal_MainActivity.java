package com.netease.modular.personal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.utils.Cons;
import com.netesea.modular.annotation.ARouter;

@ARouter(path = "/personal/Personal_MainActivity")
public class Personal_MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);

        Log.e(Cons.TAG, "personal/Personal_MainActivity");

        if (getIntent() != null) {
            String content = getIntent().getStringExtra("name");
            Log.e(Cons.TAG, "���ղ���ֵ��" + content);
        }
    }

    public void jumpApp(View view) {

    }

    public void jumpOrder(View view) {

    }
}
