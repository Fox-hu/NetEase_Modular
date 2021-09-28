package com.netease.modular;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.utils.Cons;
import com.netease.modular.api.RouterManager;
import com.netease.modular.order.Order_MainActivity;
import com.netesea.modular.annotation.ARouter;
import com.netesea.modular.annotation.Parameter;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {

    @Parameter
    String name;

    @Parameter(name = "agex")
    int age  = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getIntent().getStringExtra("name");
        age = getIntent().getIntExtra("agex",age);

        if (BuildConfig.isRelease) {
            Log.e(Cons.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e(Cons.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }
    }

    public void jumpOrder(View view) {
        RouterManager.getInstance()
                .build("/order/Order_MainActivity")
                .withString("name", "张三")
                .navigation(this,163);
    }

    public void jumpPersonal(View view) {
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withResultString("call", "i am comeback")
                .navigation(this, 163);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Log.e(Cons.TAG, "MainActivity  onActivityResult: " + data.getStringExtra("call"));
        }
    }
}
