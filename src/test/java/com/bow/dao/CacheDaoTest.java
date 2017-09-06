package com.bow.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个过滤条件的排序字段 使用字段名和别名的区别
 *
 * @author wwxiang
 * @since 2017/6/9.
 */
public class CacheDaoTest {

	private MongoTemplate template;

	@Before
	public void setup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("mongo.xml");
		template = context.getBean(MongoTemplate.class);
	}

	@Test
	public void save() {
		for (int bat = 100; bat < 500; bat++) {
            List<CacheONUPONPortReport> reports = buildReport(bat * 10000, (bat + 1) * 10000);
			template.insert(reports, "cacheONUPONPortReport");
			System.out.println("stored num " + ((bat + 1) * 10000));
		}
	}



	public List<CacheONUPONPortReport> buildReport(int begin, int end) {
		List<CacheONUPONPortReport> list = new ArrayList();

		for (int i = begin;i < end;i ++) {
			CacheONUPONPortReport cache = new CacheONUPONPortReport();
			cache.setEmsId(10000);
			cache.setNeId(19930320 + i % 100);
			cache.setBoardId(20170411 + i % 10000);
			cache.setOnuId(19700000 + i);
			cache.setPortNo(i % 10);
			cache.setPortLogo(cache.getEmsId() + "-" + cache.getNeId() + "-" + cache.getBoardId() + "-" + cache.getPortNo());

			cache.setPortName("EC8B[4]:PON"+i+":PON["+i+"]-AN5006-04[19]:PON1_flag" + i);
			cache.setBoardName("EC8B["+i+"]_flag" + i);
			cache.setOltPonPortName("EC8B[4]:PON5_flag" + i);
			cache.setOnuName("PON[5]-AN5006-04["+i+"]_flag" + i);
			cache.setNeName("网元AN5516-01_10.207.1.1_flag" + i);
			cache.setArea("ems1-武汉_flag" + i);
			cache.setSimpleName("网元AN5516-01_10.207.1."+i+"/\\n4/5/19_flag" + i);
			cache.setNeIp("10.207.1."+i+"_flag" + i);

			if (i % 2 == 0) {
				cache.setOnuServiceType("普通客户");
			} else {
				cache.setOnuServiceType("Vip");
			}
			cache.setOnuCertificationMark("::54-4b-40-94-d4-50:_flag" + i);
			cache.setOnuPassword("who are you" + i);
			cache.setPhySn("54-4b-40"+i+"-94-d4-50");
			cache.setLogicSn("hehe"+i);
			cache.setLogicSnPassword("hhe cep");

			cache.setTimeRange("2017-08-26");

			cache.setPortRate(1000.0 + i);

			cache.setBwBusyness(100.0 + i);
			cache.setBwBusynessMax(200.0 + i);
			cache.setBwBusynessMin(0.0 + i);
			cache.setBwuBusyAvg(0.0 + i);
			cache.setBwuBusyMax(10.0 + i);
			cache.setBwuMax((i % 100) / 100.0);
			cache.setDestPortReceiveFlowAvg(0.0 + i);
			cache.setDestPortSendFlowAvg(1.0 + i);
			cache.setSrcPortReceiveFlowAvg(i % 10000.0);
			cache.setSrcPortSendFlowAvg(i % 9999.0);
			cache.setDownBandwidthUtilizationAvg((i % 100) / 100.0);
			cache.setDownBandwidthUtilizationMax((i % 100) / 100.0);
			cache.setDownBandwidthUtilizationMin((i % 100) / 100.0);
			cache.setUpBandwidthUtilizationAvg((i % 100) / 100.0);
			cache.setUpBandwidthUtilizationMax((i % 100) / 100.0);
			cache.setUpBandwidthUtilizationMin((i % 100) / 100.0);
			cache.setDownOpticalAttenuationMax(100.0 + i);
			cache.setDownOpticalAttenuationMin(90.0 + i);
			cache.setDownBusySpeedAvg(250.0 + i);
			cache.setDownSpeedAvg(125.0 + i);
			cache.setDownSpeedMax(150.0 + i);
			cache.setDownSpeedMin(100.0 + i);
			cache.setUpSpeedAvg(i % 10000.0);
			cache.setUpSpeedMax(i % 12000.0);
			cache.setUpSpeedMin(i % 9000.0);
			cache.setElectricityMax(10.0 + i % 100);
			cache.setElectricityMin(i % 100.0);
			cache.setGuaranteedBW(1250.0);
			cache.setGuaranteedBWUBusyAvg(1000.0);
			cache.setMaxDownErrorRate(i % 1000.0);
			cache.setMaxDownPacketLossRate(i % 101.0);
			cache.setMaxUpErrorRate(i % 900.0);
			cache.setMaxUpPacketLossRate(i % 120.0);
			cache.setOpticalPowerMax(-20.0 + i % 60);
			cache.setOpticalPowerMin(-40.0 + i % 60);
			cache.setPacketLossCount(i % 150.0);
			cache.setReceiveTrafficOccupancyRate(i % 100.0);
			cache.setSendTrafficOccupancyRate(i % 90.0);
			cache.setTemperatureMax(i % 100.0);
			cache.setTemperatureMin(i % 80.0);
			cache.setVoltageMax(10.0 + i);
			cache.setVoltageMin(0.0 + i);
			cache.setUpBusySpeedAvg(20.0 + i);
			cache.setReceiveOpticalPowerMin(i % 500.0);
			cache.setReceiveOpticalPowerMax(100.0 + i % 500.0);
			cache.setSendOpticalPowerMax(200.0 + i % 500.0);
			cache.setSendOpticalPowerMin(15 + i % 500.0);
			cache.setUpOpticalAttenuationMin(i % 400.0);
			cache.setUpOpticalAttenuationMax(i % 600.0);

			list.add(cache);
		}

		return list;
	}

	@Test
	public void query0() {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.ASC, "bwBusyness")).skip(10_0000).limit(10);
		List<CacheONUPONPortReport> reports = template.find(query, CacheONUPONPortReport.class);
		// 33554432
		System.out.println(reports.size());
	}

	@Test
	public void query1() {
		DBObject db = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		fields.put("bwBusyness", true);
		fields.put("id", true);
		Query query = new BasicQuery(db, fields);
		query.with(new Sort(Sort.Direction.ASC, "bwBusyness")).limit(10).skip(80000);
		List<CacheONUPONPortReport> reports = template.find(query, CacheONUPONPortReport.class);
		// 33554432
		System.out.println(reports.size());

	}

	@Test
	public void query2() {
		SortOperation sort = Aggregation.sort(Sort.Direction.ASC, "bwHeatPct");
		LimitOperation limit = Aggregation.limit(5);
		MatchOperation match = Aggregation.match(Criteria.where("neNm").regex("\\Q" + "江夏区" + "\\E"));
		SkipOperation skip = Aggregation.skip(100_0000);
		Aggregation aggregation = Aggregation.newAggregation(match, sort, skip, limit)
				.withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());
		long begin = System.currentTimeMillis();
		AggregationResults<CacheONUPONPortReport> reports = template.aggregate(aggregation, "test_sort",
				CacheONUPONPortReport.class);
        
		long end = System.currentTimeMillis();
		for (CacheONUPONPortReport r : reports) {
			System.out.println(r.getBwBusyness());
		}
		System.out.println(">> " + (end - begin));
	}

	@Test
	public void query3() {
		Query query = new Query();
		query.getQueryObject();
	}



}
