package com.netease.modular.order.debug;

import android.os.Bundle;
import android.util.Log;

import com.netease.common.utils.Cons;
import com.netease.modular.order.R;
//继承的也是 common 中的debug
public class Order_DebugActivity extends Order_DebugBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_debug);

        Log.e(Cons.TAG, "order/debug/Order_DebugActivity");
    }
}
