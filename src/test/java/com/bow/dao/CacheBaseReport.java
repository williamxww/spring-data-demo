package com.bow.dao;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

/**
 * Created by xurui on 2017/5/3.
 */
public class CacheBaseReport {

    /**
     * 数据库字段Id
     */
//    @Id
    @Field("id")
    private Integer id;
    /**
     * EMS Id
     */
    @Field("emsId")
    private Integer emsId;

    /**
     * NE Id
     */
    @Field("neId")
    private Integer neId;

    /**
     * area
     */
    @Field("areaNm")
    private String area;

    /**
     * ne name
     */
    @Field("neNm")
    private String neName;

    /**
     * ne ip
     */
    @Field("neIp")
    private String neIp;

    /**
     * portLogo
     *
     * Port 标识，emsID-neID-boardID(onuID)-portNo拼接成
     */
    @Field("portInd")
    private String portLogo;

    /**
     * 报表起止时间
     */
    @Field("timeRng")
    private String timeRange;

    /**
     * 端口简单名
     */
    @Field("portShortNm")
    private String simpleName;

    /**
     * 扩展字段
     */
    @Transient
    private Map<String, Object> extendedFieldMap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmsId() {
        return emsId;
    }

    public void setEmsId(Integer emsId) {
        this.emsId = emsId;
    }

    public Integer getNeId() {
        return neId;
    }

    public void setNeId(Integer neId) {
        this.neId = neId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNeName() {
        return neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public String getNeIp() {
        return neIp;
    }

    public void setNeIp(String neIp) {
        this.neIp = neIp;
    }

    public String getPortLogo() {
        return portLogo;
    }

    public void setPortLogo(String portLogo) {
        this.portLogo = portLogo;
    }

    public Map<String, Object> getExtendedFieldMap() {
        return extendedFieldMap;
    }

    public void setExtendedFieldMap(Map<String, Object> extendedFieldMap) {
        this.extendedFieldMap = extendedFieldMap;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }
}
