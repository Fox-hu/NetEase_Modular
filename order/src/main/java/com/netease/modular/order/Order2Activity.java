package com.netease.modular.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.netease.arouter.annotation.ARouter;

@ARouter(path = "/order/Order2Activity")
public class Order2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);
    }
}