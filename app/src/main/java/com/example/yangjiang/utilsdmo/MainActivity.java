package com.example.yangjiang.utilsdmo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.yutils.JsonManager;
import com.yutils.Logger;
import com.yutils.NetworkUtils;
import com.yutils.TimeUtils;
import com.yutils.YFileUtils;
import com.yutils.YUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
  List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        for (int i=0;i<10;i++){
            list.add("ai+"+i);
        }

    }


    @OnClick({R.id.button2, R.id.button3, R.id.button4,R.id.button5, R.id.button6, R.id.button7, R.id.button8,R.id.button9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button2:
                Logger.d("MainActivity","asdasda");
                YUtils.Toast("哈哈");
                break;
            case R.id.button3:
                YUtils.Toast(TimeUtils.formDateString(new Date(),TimeUtils.DATE_TYPE_YD));
                break;
            case R.id.button4:
                YUtils.Toast("是否虚拟导航键："+YUtils.isNavigationBarExist2(this));
                break;
            case R.id.button5:
                  String lists= JsonManager.beanToJson(list);
                YUtils.Toast("json："+lists);
                break;
            case R.id.button6:
                CountDownTimer cc= TimeUtils.countDown(this, 60, 1, new TimeUtils.CountDownListener() {
                    @Override
                    public void onFinish(String text) {
                        YUtils.Toast("onFinish："+text);
                    }

                    @Override
                    public void onTick(long millisUntilFinished, String text) {
                        YUtils.Toast("onTick："+text);
                    }
                });
                break;
            case R.id.button7:
                YUtils.Toast("视频时长："+TimeUtils.fromVideoTime(100));
                break;
            case R.id.button8:
                YUtils.Toast("视频文件："+ YFileUtils.formatFileSizeAll(1500000L));
                break;
            case R.id.button9:
                YUtils.Toast("网络："+ NetworkUtils.isNetWorkAvailable());
                break;
        }
    }
}
