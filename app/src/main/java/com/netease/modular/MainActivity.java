package com.netease.modular;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.netease.common.base.BaseActivity;
import com.netease.common.utils.Cons;
import com.netease.modular.api.ARouterLoadGroup;
import com.netease.modular.api.ARouterLoadPath;
import com.netease.modular.apt.ARouter$$Group$$app;
import com.netease.modular.apt.ARouter$$Path$$app;
import com.netease.modular.order.Order_MainActivity;
import com.netease.modular.personal.Personal_MainActivity;
import com.netease.modular.test.ARouter$$Group$$order;
import com.netease.modular.test.ARouter$$Path$$order;
import com.netesea.modular.annotation.ARouter;
import com.netesea.modular.annotation.Parameter;
import com.netesea.modular.annotation.model.RouterBean;

import java.util.Map;

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

        //        Intent intent = new Intent(this, Order_MainActivity.class);
//        intent.putExtra("name", "simon");
//        startActivity(intent);

        // 最终集成化模式，所有子模块app/order/personal通过APT生成的类文件都会打包到apk里面，不用担心找不到
        ARouterLoadGroup group = new ARouter$$Group$$app();
        Map<String, Class<? extends ARouterLoadPath>> map = group.loadGroup();
        // 通过order组名获取对应路由路径对象
        Class<? extends ARouterLoadPath> clazz = map.get("app");

        try {
            // 类加载动态加载路由路径对象
            ARouter$$Path$$app path = (ARouter$$Path$$app) clazz.newInstance();
            Map<String, RouterBean> pathMap = path.loadPath();
            // 获取目标对象封装
            RouterBean bean = pathMap.get("/app/TestActivity");

            if (bean != null) {
                Intent intent = new Intent(this, bean.getClazz());
                intent.putExtra("username","zhangsan");
                intent.putExtra("gender",true);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void jumpPersonal(View view) {

    }
}
