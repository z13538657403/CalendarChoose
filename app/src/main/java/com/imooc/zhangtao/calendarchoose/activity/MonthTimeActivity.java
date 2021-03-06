package com.imooc.zhangtao.calendarchoose.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.zhangtao.calendarchoose.R;
import com.imooc.zhangtao.calendarchoose.adapter.MonthTimeAdapter;
import com.imooc.zhangtao.calendarchoose.entity.DayTimeEntity;
import com.imooc.zhangtao.calendarchoose.entity.MonthTimeEntity;
import com.imooc.zhangtao.calendarchoose.entity.UpdataCalendar;

import java.util.ArrayList;
import java.util.Calendar;

import de.greenrobot.event.EventBus;

/**
 * Created by zhangtao on 17/2/27.
 */

public class MonthTimeActivity extends Activity
{
    private TextView startTime;          //开始时间
    private TextView stopTime;           //结束时间

    private RecyclerView recycler;
    private MonthTimeAdapter adapter;
    private ArrayList<MonthTimeEntity> datas;

    public static DayTimeEntity startDay;
    public static DayTimeEntity stopDay;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        EventBus.getDefault().register(this);
    }

    private void initView()
    {
        startTime = (TextView) findViewById(R.id.plan_time_txt_start);
        stopTime = (TextView) findViewById(R.id.plan_time_txt_stop);

        recycler = (RecyclerView) findViewById(R.id.plan_time_calender);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
    }

    private void initData()
    {
        startDay = new DayTimeEntity(0,0,0,0);
        stopDay = new DayTimeEntity(-1,-1,-1,-1);
        datas = new ArrayList<>();

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;

        c.add(Calendar.MONTH,1);
        int nextYear = c.get(Calendar.YEAR);
        int nextMonth = c.get(Calendar.MONTH)+1;

        datas.add(new MonthTimeEntity(year,month));                      //当前月份
        datas.add(new MonthTimeEntity(nextYear,nextMonth));              //下个月
        adapter = new MonthTimeAdapter(datas, MonthTimeActivity.this);
        recycler.setAdapter(adapter);
    }

    public void onEventMainThread(UpdataCalendar event)
    {
        adapter.notifyDataSetChanged();
        startTime.setText(startDay.getMonth()+"月"+startDay.getDay()+"日"+"\n");
        if (stopDay.getDay() == -1)
        {
            stopTime.setText("结束"+"\n"+"时间");
        }
        else
        {
            stopTime.setText(stopDay.getMonth() + "月" + stopDay.getDay() + "日" + "\n");
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
