package com.netease.modular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.netesea.modular.annotation.ARouter;

@ARouter(path = "/app/TestActivity")
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}