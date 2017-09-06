package com.bow.dao;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * ONU PON口数据缓存
 *
 * @author xurui
 * @since 2017-05-04 14:27:37
 */
public class CacheONUPONPortReport extends CacheBaseReport implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -741841453443125055L;

	/**
	 * board id
	 */
	@Field("boardId")
	private Integer boardId;

	/**
	 * onu id
	 */
	@Field("onuId")
	private Integer onuId;

	/**
	 * Onu pon端口id
	 */
	@Field("portNo")
	private Integer portNo;

	/**
	 * 盘名
	 */
	@Field("boardNm")
	private String boardName;

	/**
	 * OLT PON口名
	 */
	@Field("oltPonPrtNm")
	private String oltPonPortName;

	/**
	 * ONU名
	 */
	@Field("onuNm")
	private String onuName;

	/**
	 * ONU服务等级
	 * <p>
	 * <p>
	 * 取值来源：EMS代理 使用报表: 链路、ONU PON口流量、光功率等
	 */
	@Field("onuSerType")
	private String onuServiceType;

	/**
	 * Onu PON口名
	 */
	@Field("portNm")
	private String portName;

	/**
	 * Onu认证标识
	 */
	@Field("onuMark")
	private String onuCertificationMark;

	/**
	 * ONU物理地址mac或物理SN
	 */
	@Field("phySn")
	private String phySn;

	/**
	 * ONU密码
	 */
	@Field("onuPwd")
	private String onuPassword;

	/**
	 * ONU逻辑sn
	 */
	@Field("logicSn")
	private String logicSn;

	/**
	 * ONU逻辑sn密码
	 */
	@Field("logicSnPwd")
	private String logicSnPassword;

	/**
	 * OLT PON口接收ONU的光功率最大值
	 *
	 * 性能码: 1529 使用报表: PON口接收ONU
	 */
	@Field("rcvOnuOpMax")
	private Double opticalPowerMax;

	/**
	 * OLT PON口接收ONU的光功率最小值
	 *
	 * 性能码: 1529 使用报表: PON口接收ONU
	 */
	@Field("rcvOnuOpMin")
	private Double opticalPowerMin;

	/**
	 * 接收光功率峰值
	 * 
	 * 性能码: 1528 使用报表: 光功率
	 */
	@Field("rcvOpMax")
	private Double receiveOpticalPowerMax;

	/**
	 * 接收光功率谷值
	 * 
	 * 性能码: 1528 使用报表: 光功率
	 */
	@Field("rcvOpMin")
	private Double receiveOpticalPowerMin;

	/**
	 * 发送光功率峰值
	 * 
	 * 性能码: 1527 使用报表: 光功率
	 */
	@Field("sndOpMax")
	private Double sendOpticalPowerMax;

	/**
	 * 发送光功率谷值
	 * 
	 * 性能码: 1527 使用报表: 光功率
	 */
	@Field("sndOpMin")
	private Double sendOpticalPowerMin;

	/**
	 * 上行光衰峰值
	 * 
	 * 性能码: 3045 使用报表: 光功率
	 */
	@Field("uoaMax")
	private Double upOpticalAttenuationMax;

	/**
	 * 上行光衰谷值
	 * 
	 * 性能码: 3045 使用报表: 光功率
	 */
	@Field("uoaMin")
	private Double upOpticalAttenuationMin;

	/**
	 * 下行光衰峰值
	 * 
	 * 性能码: 3046 使用报表: 光功率
	 */
	@Field("doaMax")
	private Double downOpticalAttenuationMax;

	/**
	 * 下行光衰谷值
	 * 
	 * 性能码: 3046 使用报表: 光功率
	 */
	@Field("doaMin")
	private Double downOpticalAttenuationMin;

	/**
	 * 温度峰值(°C)
	 * <p>
	 * <p>
	 * 取值来源：PAS系统，ONU PON口温度峰值。
	 */
	@Field("tmprtMax")
	private Double temperatureMax;

	/**
	 * 温度谷值(°C)
	 * <p>
	 * <p>
	 * 取值来源：PAS系统，ONU PON口温度谷值。
	 */
	@Field("tmprtMin")
	private Double temperatureMin;

	/**
	 * 电流峰值(°C)
	 * <p>
	 * <p>
	 * 取值来源：PAS系统，ONU PON口电流峰值。
	 */
	@Field("electricMax")
	private Double electricityMax;

	/**
	 * 电流谷值(°C)
	 * <p>
	 * <p>
	 * 取值来源：PAS系统，ONU PON口电流谷值。
	 */
	@Field("electricMin")
	private Double electricityMin;

	/**
	 * 电压峰值
	 * <p>
	 * <p>
	 * 取值来源：PAS系统，ONU PON口电压峰值。
	 */
	@Field("voltageMax")
	private Double voltageMax;

	/**
	 * 电压谷值
	 * <p>
	 * <p>
	 * 取值来源：PAS系统，ONU PON口电压谷值。
	 */
	@Field("voltageMin")
	private Double voltageMin;

	/**
	 * 端口速率 使用报表：流量
	 */
	@Field("rate")
	private Double portRate;

	/**
	 * 端口配置的保证带宽，使用报表：流量
	 */
	@Field("confGbw")
	private Double guaranteedBW;

	/**
	 * 下行速率忙时均值
	 * 
	 * 性能码: 3195 使用报表: 流量
	 */
	@Field("dbsAvg")
	private Double downBusySpeedAvg;

	/**
	 * 下行速率峰值
	 * 
	 * 性能码: 1491 使用报表: 流量
	 */
	@Field("dsMax")
	private Double downSpeedMax;

	/**
	 * 下行速率均值
	 *
	 * 性能码: 1491 使用报表: 流量
	 */
	@Field("dsAvg")
	private Double downSpeedAvg;

	/**
	 * 下行速率谷值
	 * 
	 * 性能码: 1491 使用报表: 流量
	 */
	@Field("dsMin")
	private Double downSpeedMin;

	/**
	 * 下行速率均值--源端口接收流量均值
	 * 
	 * 性能码: 1491 使用报表: 链路
	 */
	@Field("srcPrtRcvAvg")
	private Double srcPortReceiveFlowAvg;

	/**
	 * 上行速率忙时均值
	 * 
	 * 性能码: 3194 使用报表: 流量
	 */
	@Field("ubsAvg")
	private Double upBusySpeedAvg;

	/**
	 * 上行速率峰值
	 * 
	 * 性能码: 1488 使用报表: 流量
	 */
	@Field("usMax")
	private Double upSpeedMax;

	/**
	 * 上行速率均值
	 *
	 * 性能码: 1488 使用报表: 流量
	 */
	@Field("usAvg")
	private Double upSpeedAvg;

	/**
	 * 上行速率谷值
	 * 
	 * 性能码: 1488 使用报表: 流量
	 */
	@Field("usMin")
	private Double upSpeedMin;

	/**
	 * 上行速率均值-- 源端口发送流量均值
	 * <P>
	 * 宿在网元上
	 * 
	 * 性能码: 1488 使用报表: 链路
	 */
	@Field("srcPrtSndAvg")
	private Double srcPortSendFlowAvg;

	/**
	 * 端口带宽利用率峰值
	 * 
	 * 性能码: 3196 使用报表: 流量
	 */
	@Field("bwuMax")
	private Double bwuMax;

	/**
	 * 端口带宽利用率忙时均值
	 * 
	 * 性能码: 3197 使用报表: 流量
	 */
	@Field("bwuBusyAvg")
	private Double bwuBusyAvg;

	/**
	 * 端口带宽利用率忙时计算点数
	 *
	 * 性能码: 3197 使用报表: 流量
	 */
	@Field("bwuBusyMax")
	private Double bwuBusyMax;

	/**
	 * 端口带宽繁忙度
	 *
	 * 性能码: 3198 使用报表: 流量
	 */
	@Field("bwHeatPct")
	private Double bwBusyness;

	/**
	 * 端口带宽繁忙度总采集数
	 *
	 * 性能码: 3198 使用报表: 流量
	 */
	@Field("bwHeatMax")
	private Double bwBusynessMax;

	/**
	 * 端口带宽繁忙度越限数
	 *
	 * 性能码: 3198 使用报表: 流量
	 */
	@Field("bwHeatMin")
	private Double bwBusynessMin;

	/**
	 * 端口丢包数
	 * 
	 * 性能码: 3199 使用报表: 流量
	 */
	@Field("packetLssNum")
	private Double packetLossCount;
	/**
	 * 上行误码率峰值
	 * <p>
	 * 性能码: 3047 使用报表: 流量
	 */
	@Field("mUErrRt")
	private Double maxUpErrorRate;
	/**
	 * 下行误码率峰值
	 * <p>
	 * 性能码: 3048 使用报表: 流量
	 */
	@Field("mDErrRt")
	private Double maxDownErrorRate;
	/**
	 * 上行丢包率峰值
	 * <p>
	 * 性能码: 3223 使用报表: 流量
	 */
	@Field("mUPktLsRt")
	private Double maxUpPacketLossRate;
	/**
	 * 下行丢包率峰值
	 * <p>
	 * 性能码: 3225 使用报表: 流量
	 */
	@Field("mDPktLsRt")
	private Double maxDownPacketLossRate;

	/**
	 * 上行带宽利用率峰值
	 *
	 * 性能码: 1490 使用报表:TOP N
	 */
	@Field("ubwpMax")
	private Double upBandwidthUtilizationMax;

	/**
	 * 上行带宽利用率均值
	 *
	 * 性能码: 1490 使用报表:TOP N
	 */
	@Field("ubwpAvg")
	private Double upBandwidthUtilizationAvg;

	/**
	 * 上行带宽利用率谷值
	 *
	 * 性能码: 1490 使用报表:
	 */
	@Field("ubwpMin")
	private Double upBandwidthUtilizationMin;

	/**
	 * 下行带宽利用率峰值
	 *
	 * 性能码: 1493 使用报表:TOP N 下钻
	 */
	@Field("dbwpMax")
	private Double downBandwidthUtilizationMax;

	/**
	 * 下行带宽利用率均值
	 *
	 * 性能码: 1493 使用报表:
	 */
	@Field("dbwpAvg")
	private Double downBandwidthUtilizationAvg;

	/**
	 * 下行带宽利用率谷值
	 *
	 * 性能码: 1493 使用报表:
	 */
	@Field("dbwpMin")
	private Double downBandwidthUtilizationMin;

	/**
	 * ONU PON口上行速率均值
	 * <p>
	 * 性能码: 3200 使用报表: 链路
	 */
	@Field("destPrtSndAvg")
	private Double destPortSendFlowAvg;

	/**
	 * ONU PON口下行速率均值
	 * <p>
	 * 性能码: 3201 使用报表: 链路
	 */
	@Field("destPrtRcvAvg")
	private Double destPortReceiveFlowAvg;

	/**
	 * 接收方向源/宿端口流量占用率
	 *
	 * <p>
	 * 取值来源：PON流量工具由源端口接收方向(ONU PON口下行)平均流速（Mb/s）/ 宿端口接收方向（ONU
	 * PON口下行）平均流速（Mb/s）计算。 使用报表：链路
	 */
	@Field("receiveTrffcOcpPct")
	private Double receiveTrafficOccupancyRate;

	/**
	 * 发送方向源/宿端口流量占用率
	 *
	 * <p>
	 * 取值来源：PON流量工具由源端口发送方向（ONU PON口上行）平均流速（Mb/s）/ 宿端口发送方向（ONU
	 * PON口上行）平均流速（Mb/s）计算。 使用报表：链路
	 */
	@Field("sendTrffcOcpPct")
	private Double sendTrafficOccupancyRate;

	/**
	 * 端口配置的保证带宽利用率忙时均值(%)
	 *
	 * <p>
	 * 取值来源：PON流量工具根据上下行忙时流速和保证带宽计算。 使用报表：ONU PON口 流量报表
	 */
	@Field("confGbwpAvg")
	private Double guaranteedBWUBusyAvg;

	public Double getDestPortSendFlowAvg() {
		return destPortSendFlowAvg;
	}

	public void setDestPortSendFlowAvg(Double destPortSendFlowAvg) {
		this.destPortSendFlowAvg = destPortSendFlowAvg;
	}

	public Double getDestPortReceiveFlowAvg() {
		return destPortReceiveFlowAvg;
	}

	public void setDestPortReceiveFlowAvg(Double destPortReceiveFlowAvg) {
		this.destPortReceiveFlowAvg = destPortReceiveFlowAvg;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public Integer getOnuId() {
		return onuId;
	}

	public void setOnuId(Integer onuId) {
		this.onuId = onuId;
	}

	public Integer getPortNo() {
		return portNo;
	}

	public void setPortNo(Integer portNo) {
		this.portNo = portNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getOltPonPortName() {
		return oltPonPortName;
	}

	public void setOltPonPortName(String oltPonPortName) {
		this.oltPonPortName = oltPonPortName;
	}

	public String getOnuName() {
		return onuName;
	}

	public void setOnuName(String onuName) {
		this.onuName = onuName;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public String getOnuCertificationMark() {
		return onuCertificationMark;
	}

	public void setOnuCertificationMark(String onuCertificationMark) {
		this.onuCertificationMark = onuCertificationMark;
	}

	public Double getPortRate() {
		return portRate;
	}

	public void setPortRate(Double portRate) {
		this.portRate = portRate;
	}

	public Double getGuaranteedBW() {
		return guaranteedBW;
	}

	public void setGuaranteedBW(Double guaranteedBW) {
		this.guaranteedBW = guaranteedBW;
	}

	public Double getReceiveOpticalPowerMax() {
		return receiveOpticalPowerMax;
	}

	public void setReceiveOpticalPowerMax(Double receiveOpticalPowerMax) {
		this.receiveOpticalPowerMax = receiveOpticalPowerMax;
	}

	public Double getReceiveOpticalPowerMin() {
		return receiveOpticalPowerMin;
	}

	public void setReceiveOpticalPowerMin(Double receiveOpticalPowerMin) {
		this.receiveOpticalPowerMin = receiveOpticalPowerMin;
	}

	public Double getSendOpticalPowerMax() {
		return sendOpticalPowerMax;
	}

	public void setSendOpticalPowerMax(Double sendOpticalPowerMax) {
		this.sendOpticalPowerMax = sendOpticalPowerMax;
	}

	public Double getSendOpticalPowerMin() {
		return sendOpticalPowerMin;
	}

	public void setSendOpticalPowerMin(Double sendOpticalPowerMin) {
		this.sendOpticalPowerMin = sendOpticalPowerMin;
	}

	public Double getUpOpticalAttenuationMax() {
		return upOpticalAttenuationMax;
	}

	public void setUpOpticalAttenuationMax(Double upOpticalAttenuationMax) {
		this.upOpticalAttenuationMax = upOpticalAttenuationMax;
	}

	public Double getUpOpticalAttenuationMin() {
		return upOpticalAttenuationMin;
	}

	public void setUpOpticalAttenuationMin(Double upOpticalAttenuationMin) {
		this.upOpticalAttenuationMin = upOpticalAttenuationMin;
	}

	public Double getDownOpticalAttenuationMax() {
		return downOpticalAttenuationMax;
	}

	public void setDownOpticalAttenuationMax(Double downOpticalAttenuationMax) {
		this.downOpticalAttenuationMax = downOpticalAttenuationMax;
	}

	public Double getDownOpticalAttenuationMin() {
		return downOpticalAttenuationMin;
	}

	public void setDownOpticalAttenuationMin(Double downOpticalAttenuationMin) {
		this.downOpticalAttenuationMin = downOpticalAttenuationMin;
	}

	public Double getOpticalPowerMax() {
		return opticalPowerMax;
	}

	public void setOpticalPowerMax(Double opticalPowerMax) {
		this.opticalPowerMax = opticalPowerMax;
	}

	public Double getOpticalPowerMin() {
		return opticalPowerMin;
	}

	public void setOpticalPowerMin(Double opticalPowerMin) {
		this.opticalPowerMin = opticalPowerMin;
	}

	public Double getDownBusySpeedAvg() {
		return downBusySpeedAvg;
	}

	public void setDownBusySpeedAvg(Double downBusySpeedAvg) {
		this.downBusySpeedAvg = downBusySpeedAvg;
	}

	public Double getDownSpeedMax() {
		return downSpeedMax;
	}

	public void setDownSpeedMax(Double downSpeedMax) {
		this.downSpeedMax = downSpeedMax;
	}

	public Double getDownSpeedMin() {
		return downSpeedMin;
	}

	public void setDownSpeedMin(Double downSpeedMin) {
		this.downSpeedMin = downSpeedMin;
	}

	public Double getSrcPortReceiveFlowAvg() {
		return srcPortReceiveFlowAvg;
	}

	public void setSrcPortReceiveFlowAvg(Double srcPortReceiveFlowAvg) {
		this.srcPortReceiveFlowAvg = srcPortReceiveFlowAvg;
	}

	public Double getUpBusySpeedAvg() {
		return upBusySpeedAvg;
	}

	public void setUpBusySpeedAvg(Double upBusySpeedAvg) {
		this.upBusySpeedAvg = upBusySpeedAvg;
	}

	public Double getUpSpeedMax() {
		return upSpeedMax;
	}

	public void setUpSpeedMax(Double upSpeedMax) {
		this.upSpeedMax = upSpeedMax;
	}

	public Double getUpSpeedMin() {
		return upSpeedMin;
	}

	public void setUpSpeedMin(Double upSpeedMin) {
		this.upSpeedMin = upSpeedMin;
	}

	public Double getSrcPortSendFlowAvg() {
		return srcPortSendFlowAvg;
	}

	public void setSrcPortSendFlowAvg(Double srcPortSendFlowAvg) {
		this.srcPortSendFlowAvg = srcPortSendFlowAvg;
	}

	public Double getBwuMax() {
		return bwuMax;
	}

	public void setBwuMax(Double bwuMax) {
		this.bwuMax = bwuMax;
	}

	public Double getBwuBusyAvg() {
		return bwuBusyAvg;
	}

	public void setBwuBusyAvg(Double bwuBusyAvg) {
		this.bwuBusyAvg = bwuBusyAvg;
	}

	public Double getBwuBusyMax() {
		return bwuBusyMax;
	}

	public void setBwuBusyMax(Double bwuBusyMax) {
		this.bwuBusyMax = bwuBusyMax;
	}

	public Double getBwBusyness() {
		return bwBusyness;
	}

	public void setBwBusyness(Double bwBusyness) {
		this.bwBusyness = bwBusyness;
	}

	public Double getBwBusynessMax() {
		return bwBusynessMax;
	}

	public void setBwBusynessMax(Double bwBusynessMax) {
		this.bwBusynessMax = bwBusynessMax;
	}

	public Double getBwBusynessMin() {
		return bwBusynessMin;
	}

	public void setBwBusynessMin(Double bwBusynessMin) {
		this.bwBusynessMin = bwBusynessMin;
	}

	public Double getPacketLossCount() {
		return packetLossCount;
	}

	public void setPacketLossCount(Double packetLossCount) {
		this.packetLossCount = packetLossCount;
	}

	public Double getUpBandwidthUtilizationMax() {
		return upBandwidthUtilizationMax;
	}

	public void setUpBandwidthUtilizationMax(Double upBandwidthUtilizationMax) {
		this.upBandwidthUtilizationMax = upBandwidthUtilizationMax;
	}

	public Double getUpBandwidthUtilizationAvg() {
		return upBandwidthUtilizationAvg;
	}

	public void setUpBandwidthUtilizationAvg(Double upBandwidthUtilizationAvg) {
		this.upBandwidthUtilizationAvg = upBandwidthUtilizationAvg;
	}

	public Double getUpBandwidthUtilizationMin() {
		return upBandwidthUtilizationMin;
	}

	public void setUpBandwidthUtilizationMin(Double upBandwidthUtilizationMin) {
		this.upBandwidthUtilizationMin = upBandwidthUtilizationMin;
	}

	public Double getDownBandwidthUtilizationMax() {
		return downBandwidthUtilizationMax;
	}

	public void setDownBandwidthUtilizationMax(Double downBandwidthUtilizationMax) {
		this.downBandwidthUtilizationMax = downBandwidthUtilizationMax;
	}

	public Double getDownBandwidthUtilizationAvg() {
		return downBandwidthUtilizationAvg;
	}

	public void setDownBandwidthUtilizationAvg(Double downBandwidthUtilizationAvg) {
		this.downBandwidthUtilizationAvg = downBandwidthUtilizationAvg;
	}

	public Double getDownBandwidthUtilizationMin() {
		return downBandwidthUtilizationMin;
	}

	public void setDownBandwidthUtilizationMin(Double downBandwidthUtilizationMin) {
		this.downBandwidthUtilizationMin = downBandwidthUtilizationMin;
	}

	public Double getReceiveTrafficOccupancyRate() {
		return receiveTrafficOccupancyRate;
	}

	public void setReceiveTrafficOccupancyRate(Double receiveTrafficOccupancyRate) {
		this.receiveTrafficOccupancyRate = receiveTrafficOccupancyRate;
	}

	public Double getSendTrafficOccupancyRate() {
		return sendTrafficOccupancyRate;
	}

	public void setSendTrafficOccupancyRate(Double sendTrafficOccupancyRate) {
		this.sendTrafficOccupancyRate = sendTrafficOccupancyRate;
	}

	public Double getMaxUpErrorRate() {
		return maxUpErrorRate;
	}

	public void setMaxUpErrorRate(Double maxUpErrorRate) {
		this.maxUpErrorRate = maxUpErrorRate;
	}

	public Double getMaxDownErrorRate() {
		return maxDownErrorRate;
	}

	public void setMaxDownErrorRate(Double maxDownErrorRate) {
		this.maxDownErrorRate = maxDownErrorRate;
	}

	public Double getMaxUpPacketLossRate() {
		return maxUpPacketLossRate;
	}

	public void setMaxUpPacketLossRate(Double maxUpPacketLossRate) {
		this.maxUpPacketLossRate = maxUpPacketLossRate;
	}

	public Double getMaxDownPacketLossRate() {
		return maxDownPacketLossRate;
	}

	public void setMaxDownPacketLossRate(Double maxDownPacketLossRate) {
		this.maxDownPacketLossRate = maxDownPacketLossRate;
	}

	public String getOnuServiceType() {
		return onuServiceType;
	}

	public void setOnuServiceType(String onuServiceType) {
		this.onuServiceType = onuServiceType;
	}

	public Double getGuaranteedBWUBusyAvg() {
		return guaranteedBWUBusyAvg;
	}

	public void setGuaranteedBWUBusyAvg(Double guaranteedBWUBusyAvg) {
		this.guaranteedBWUBusyAvg = guaranteedBWUBusyAvg;
	}

	public Double getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(Double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public Double getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(Double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public Double getVoltageMax() {
		return voltageMax;
	}

	public void setVoltageMax(Double voltageMax) {
		this.voltageMax = voltageMax;
	}

	public Double getVoltageMin() {
		return voltageMin;
	}

	public void setVoltageMin(Double voltageMin) {
		this.voltageMin = voltageMin;
	}

	public Double getElectricityMax() {
		return electricityMax;
	}

	public void setElectricityMax(Double electricityMax) {
		this.electricityMax = electricityMax;
	}

	public Double getElectricityMin() {
		return electricityMin;
	}

	public void setElectricityMin(Double electricityMin) {
		this.electricityMin = electricityMin;
	}

	public String getPhySn() {
		return phySn;
	}

	public void setPhySn(String phySn) {
		this.phySn = phySn;
	}

	public String getOnuPassword() {
		return onuPassword;
	}

	public void setOnuPassword(String onuPassword) {
		this.onuPassword = onuPassword;
	}

	public String getLogicSn() {
		return logicSn;
	}

	public void setLogicSn(String logicSn) {
		this.logicSn = logicSn;
	}

	public String getLogicSnPassword() {
		return logicSnPassword;
	}

	public void setLogicSnPassword(String logicSnPassword) {
		this.logicSnPassword = logicSnPassword;
	}

	public Double getDownSpeedAvg() {
		return downSpeedAvg;
	}

	public void setDownSpeedAvg(Double downSpeedAvg) {
		this.downSpeedAvg = downSpeedAvg;
	}

	public Double getUpSpeedAvg() {
		return upSpeedAvg;
	}

	public void setUpSpeedAvg(Double upSpeedAvg) {
		this.upSpeedAvg = upSpeedAvg;
	}
}
