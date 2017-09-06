package com.bow.entity;

import org.springframework.data.annotation.Id;

/**
 * @author vv
 * @since 2017/9/6.
 */
public class OnuPmReportLK {

    @Id
    private Integer id;

    private Double upSpeed;

    private Double cpuUsage;

    private Double temperature;

    private String oId;

    private Onu[] right;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUpSpeed() {
        return upSpeed;
    }

    public void setUpSpeed(Double upSpeed) {
        this.upSpeed = upSpeed;
    }

    public Double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Onu[] getRight() {
        return right;
    }

    public void setRight(Onu[] right) {
        this.right = right;
    }
}
