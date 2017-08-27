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

    /**
     * 通过$lookup进行查询，外键
     */
    private String oId;

    /**
     * lookup查询用来接收结果
     */
    private List<Onu> right;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
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

    public List<Onu> getRight() {
        return right;
    }

    public void setRight(List<Onu> right) {
        this.right = right;
    }
}
