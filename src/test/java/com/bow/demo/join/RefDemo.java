package com.bow.demo.join;

import com.bow.entity.Onu;
import com.bow.entity.OnuPmReport;
import com.bow.entity.OnuPmReportLK;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 测试lookup & dbref 的性能
 * 
 * @author wwxiang
 * @since 2017/8/28.
 */
public class RefDemo {

	private ApplicationContext context;

	private MongoTemplate template;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("mongo.xml");
		template = context.getBean(MongoTemplate.class);
	}

	@Test
	public void saveOnu() {
		int valueId = 1;
		Random r = new Random(2);
		for (int neId = 0; neId < 1; neId++) {

			List<Onu> batchOnu = new ArrayList();
			List<OnuPmReport> batchValue = new ArrayList();
			List<OnuPmReportLK> batchValueLK = new ArrayList();

			for (int boardId = 0; boardId < 10; boardId++) {
				for (int port = 0; port < 10; port++) {
					for (int pon = 0; pon < 10; pon++) {
						Onu o1 = new Onu();
						String key = 10000 + "-" + neId + "-" + boardId + "-" + port + "-" + pon;
						o1.setId(key);
						if (1 == 1) {
							o1.setEmsId(10000);
							o1.setNeId(neId);
							o1.setBoardId(boardId);
							o1.setOltPonPortId(port);
							o1.setOnuId(pon);
							o1.setOnuName("ONU-" + pon);
							batchOnu.add(o1);
						}

						if (1 == 1) {
							OnuPmReport v = new OnuPmReport();
							v.setId(++valueId);
							v.setOnu(o1);
							Double usage = r.nextDouble();
							v.setCpuUsage(usage);
							v.setTemperature(usage * 10);
							v.setUpSpeed(usage * 100);
							batchValue.add(v);
						}

						if (1 == 1) {
							OnuPmReportLK v = new OnuPmReportLK();
							v.setId(++valueId);
							v.setoId(o1.getId());
							Double usage = r.nextDouble();
							v.setCpuUsage(usage);
							v.setTemperature(usage * 10);
							v.setUpSpeed(usage * 100);
							batchValueLK.add(v);
						}

					}
				}
			}

			if (batchOnu.size() > 0) {
				template.insert(batchOnu, "onu");
			}
			if (batchValue.size() > 0) {
				template.insert(batchValue, "onuPmReport");
			}
			if (batchValueLK.size() > 0) {
				template.insert(batchValueLK, "onuPmReportLK");
			}

			System.out.println("Insert ne " + neId);
		}
	}

	/**
	 * FIXME 从表的排序怎么搞?
	 * 100W 无排序，仅有过滤 7881;
	 */
	@Test
	public void refJoin() {
		long begin = System.currentTimeMillis();
		Query query = new Query();
		query.addCriteria(Criteria.where("onuName").is("ONU-0"));
		List<Onu> onus = template.find(query, Onu.class);
		List<String> onuIds = new ArrayList();
		for (Onu o : onus) {
			onuIds.add(o.getId());
		}

		Query q2 = new Query();
		Criteria c2 = Criteria.where("onu.id").in(onuIds);
		q2.addCriteria(c2);
		q2.skip(0).limit(10);
		List<OnuPmReport> result = template.find(q2, OnuPmReport.class);
		System.out.println(result.size());
		long end = System.currentTimeMillis();
		System.out.println("Elapse time " + (end - begin));
	}

}
