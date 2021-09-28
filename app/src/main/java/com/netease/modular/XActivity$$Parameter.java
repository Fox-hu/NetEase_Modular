package com.netease.modular;

import com.netease.arouter.api.core.ParameterLoad;

public class XActivity$$Parameter implements ParameterLoad {

    @Override
    public void loadParameter(Object target) {
        //一次
        MainActivity t = (MainActivity) target;
        //循环
        t.name = t.getIntent().getStringExtra("name");
        t.age = t.getIntent().getIntExtra("age",t.age);
    }
}
