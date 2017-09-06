package com.bow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author vv
 * @since 2017/8/26.
 */
@Document
public class OnuPmReport {

    @Id
    private Integer id;

    /**
     * 内嵌从表的引用
     */
    @DBRef
    private Onu onu;

    private Double upSpeed;

    private Double cpuUsage;

    private Double temperature;

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

    public Onu getOnu() {
        return onu;
    }

    public void setOnu(Onu onu) {
        this.onu = onu;
    }

}
