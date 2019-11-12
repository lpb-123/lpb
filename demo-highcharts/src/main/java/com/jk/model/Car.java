package com.jk.model;

import java.util.Date;

public class Car {

private Integer carid;
private String carname;
private Integer cartype;
private Date cartime;
private Double carshu;

    public Integer getCarid() {
        return carid;
    }

    public String getCarname() {
        return carname;
    }

    public Integer getCartype() {
        return cartype;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public void setCartype(Integer cartype) {
        this.cartype = cartype;
    }

    public Date getCartime() {
        return cartime;
    }

    public void setCartime(Date cartime) {
        this.cartime = cartime;
    }

    public Double getCarshu() {
        return carshu;
    }

    public void setCarshu(Double carshu) {
        this.carshu = carshu;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", carname='" + carname + '\'' +
                ", cartype=" + cartype +
                ", cartime=" + cartime +
                ", carshu=" + carshu +
                '}';
    }
}
