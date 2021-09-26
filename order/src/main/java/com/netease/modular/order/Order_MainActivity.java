package com.netease.modular.order;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.utils.Cons;
import com.netease.modular.api.ParameterManager;
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

        Log.e(Cons.TAG, "接收参数的值: " + name);
    }

    public void jumpApp(View view) {

    }

    public void jumpPersonal(View view) {

    }
}
