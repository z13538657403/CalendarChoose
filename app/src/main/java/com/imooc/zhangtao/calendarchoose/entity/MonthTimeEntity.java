package com.imooc.zhangtao.calendarchoose.entity;

/**
 * Created by zhangtao on 17/2/27.
 */

public class MonthTimeEntity
{
    private int year;
    private int month;

    public MonthTimeEntity(int year, int month)
    {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
