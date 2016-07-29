package com.geekband.yanjinyi1987.wechat_layout_sim_yanjinyi1987;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView mTimeText,mMainTitle,mSecondCount;
    private Handler handler=new Handler();
    private Handler timeHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimeText = (TextView) findViewById(R.id.create_time);
        mMainTitle = (TextView) findViewById(R.id.main_title);
        mSecondCount = (TextView) findViewById(R.id.second_count);

        //设置下划线，Paint为一个很重要的类
        mMainTitle.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        //显示格式化的日期
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy年MM月dd日"); //日期格式化
        String date = f1.format(new Date()); //对获得时间格式化并输出字符串
        mTimeText.setText(date);
        //读秒设置
        mSecondCount.setText("0s"); //初始化为0s
            //设置读秒线程
        final Runnable update_timer = new Runnable() {
            int count=0; //计秒的变量
            @Override
            public void run() {
                count++; //秒数加1
                mSecondCount.setText(Integer.toString(count)+"s"); //显示
                timeHandler.postDelayed(this,1000); //再次将这个线程加入运行队列，此处用this来代表
            }
        };

        //设置自动跳转
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeHandler.removeCallbacks(update_timer);  //将读秒线程移除
                startActivity(new Intent(MainActivity.this,HomeworkActivity.class)); //跳转到新的Activity
                finish(); //结束这个Activity，因为再次返回这个界面是我们不希望的。
            }
        },5000);

        //读秒初始设置，初始为0s，延迟1s后运行该线程
        timeHandler.postDelayed(update_timer,1000); //初始延迟1s

        //获取手机dpi值
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;

        Log.i("YJY1987","xdpi is "+xdpi);
        Log.i("YJY1987","ydpi is "+ydpi);
    }

}
