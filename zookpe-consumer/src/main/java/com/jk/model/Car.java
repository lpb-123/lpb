package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {


    private static final long serialVersionUID = -8821524362887627737L;

    private Integer carId;

    private String carName;


    private Date carTime;

    private String carShow;

    private Double carPrice;



    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getCarTime() {
        return carTime;
    }

    public void setCarTime(Date carTime) {
        this.carTime = carTime;
    }

    public String getCarShow() {
        return carShow;
    }

    public void setCarShow(String carShow) {
        this.carShow = carShow;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }


    @Override
    public String toString() {
        return "car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", carTime=" + carTime +
                ", carShow='" + carShow + '\'' +
                ", carPrice=" + carPrice +

                '}';
    }

}
