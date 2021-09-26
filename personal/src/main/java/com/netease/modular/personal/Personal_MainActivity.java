package com.netease.modular.personal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.utils.Cons;
import com.netease.modular.api.ParameterManager;
import com.netease.modular.api.RouterManager;
import com.netesea.modular.annotation.ARouter;
import com.netesea.modular.annotation.Parameter;

@ARouter(path = "/personal/Personal_MainActivity")
public class Personal_MainActivity extends BaseActivity {

    @Parameter
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);

        Log.e(Cons.TAG, "personal/Personal_MainActivity");

        ParameterManager.getInstance().loadParameter(this);
        Log.e(Cons.TAG, "Personal_MainActivity onCreate: " + name);
    }

    public void jumpApp(View view) {
        RouterManager.getInstance()
                .build("/app/MainActivity")
                .withString("name", "ÕÅÈý")
                .navigation(this);
    }

    public void jumpOrder(View view) {
        RouterManager.getInstance()
                .build("/order/Order_MainActivity")
                .withResultString("call", "i am comeback")
                .navigation(this, 163);
    }
}
