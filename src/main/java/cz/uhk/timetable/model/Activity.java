package cz.uhk.timetable.model;

import java.time.LocalTime;

public class Activity {

    private String code;
    private String name;
    private String day;
    private String startTime;
    private String endTime;
    private String getEndTime;

    public Activity(String pro1, String programovaniI, String pondeli, LocalTime localTime, LocalTime time, String kozel) {
    }

    public Activity(String name, String code, String getEndTime, String endTime, String day, String startTime) {
        this.name = name;
        this.code = code;
        this.getEndTime = getEndTime;
        this.endTime = endTime;
        this.day = day;
        this.startTime = startTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGetEndTime() {
        return getEndTime;
    }

    public void setGetEndTime(String getEndTime) {
        this.getEndTime = getEndTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
