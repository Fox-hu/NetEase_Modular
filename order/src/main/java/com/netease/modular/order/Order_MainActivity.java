package com.netease.modular.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.utils.Cons;
import com.netease.modular.api.ParameterManager;
import com.netease.modular.api.RouterManager;
import com.netesea.modular.annotation.ARouter;
import com.netesea.modular.annotation.Parameter;

@ARouter(path = "/order/Order_MainActivity")
public class Order_MainActivity extends BaseActivity {

    @Parameter
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);

        Log.e(Cons.TAG, "order/Order_MainActivity");

        //懒加载 , 跳转到哪里加载到哪里
        ParameterManager.getInstance().loadParameter(this);

        Log.e(Cons.TAG, "Order_MainActivity  : " + name);
    }

    public void jumpApp(View view) {
        RouterManager.getInstance()
                .build("/app/MainActivity")
                .withString("name", "张三")
                .navigation(this);
    }

    public void jumpPersonal(View view) {
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withResultString("name", "张三")
                .navigation(this, 163);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Log.e(Cons.TAG, "Order_MainActivity  onActivityResult: " + data.getStringExtra("call"));
        }
    }
}
