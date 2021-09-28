package com.netease.modular.order;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.utils.Cons;
import com.netease.arouter.api.ParameterManager;
import com.netease.arouter.api.RouterManager;
import com.netease.arouter.annotation.ARouter;
import com.netease.arouter.annotation.Parameter;

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
                .withResultString("call", "wo shi call")
                .navigation(this,163);
    }

    public void jumpPersonal(View view) {
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withResultString("name", "ZhangSan")
                .navigation(this, 163);
    }


}
