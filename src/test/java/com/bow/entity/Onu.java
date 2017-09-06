package com.bow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author vv
 * @since 2017/8/26.
 */
@Document
public class Onu {

    @Id
    private String id;

    private Integer emsId;

    private Integer neId;

    private Integer boardId;

    private Integer oltPonPortId;

    private Integer onuId;

    private String onuName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getOltPonPortId() {
        return oltPonPortId;
    }

    public void setOltPonPortId(Integer oltPonPortId) {
        this.oltPonPortId = oltPonPortId;
    }

    public Integer getOnuId() {
        return onuId;
    }

    public void setOnuId(Integer onuId) {
        this.onuId = onuId;
    }

    public String getOnuName() {
        return onuName;
    }

    public void setOnuName(String onuName) {
        this.onuName = onuName;
    }
}
