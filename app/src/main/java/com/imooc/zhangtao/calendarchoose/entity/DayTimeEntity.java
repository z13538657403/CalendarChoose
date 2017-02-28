package com.imooc.zhangtao.calendarchoose.entity;

/**
 * Created by zhangtao on 17/2/27.
 */

public class DayTimeEntity
{
    private int day;
    private int month;
    private int year;
    private int monthPosition;      //属于的月份位置，注意是该日期属于的月份在外层列表中的position，不是月份
    private int dayPosition;        //属于的日期位置，注意是该日期在每个月（内层列表）中的位置

    public DayTimeEntity(int day, int month, int year, int monthPosition)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        this.monthPosition = monthPosition;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonthPosition() {
        return monthPosition;
    }

    public void setMonthPosition(int monthPosition) {
        this.monthPosition = monthPosition;
    }

    public int getDayPosition() {
        return dayPosition;
    }

    public void setDayPosition(int dayPosition) {
        this.dayPosition = dayPosition;
    }
}
