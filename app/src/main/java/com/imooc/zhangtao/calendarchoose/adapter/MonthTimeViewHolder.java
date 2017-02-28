package com.imooc.zhangtao.calendarchoose.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.imooc.zhangtao.calendarchoose.R;

/**
 * Created by zhangtao on 17/2/27.
 */

public class MonthTimeViewHolder extends RecyclerView.ViewHolder
{
    public TextView plan_time_txt_month;
    public RecyclerView plan_time_recycler_content;
    public Context context;

    public MonthTimeViewHolder(View itemView , Context context)
    {
        super(itemView);
        this.context = context;
        plan_time_recycler_content = (RecyclerView) itemView.findViewById(R.id.plan_time_recycler_content);
        plan_time_txt_month = (TextView) itemView.findViewById(R.id.plan_time_txt_month);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 7 , GridLayoutManager.VERTICAL, false);
        plan_time_recycler_content.setLayoutManager(layoutManager);
    }
}
