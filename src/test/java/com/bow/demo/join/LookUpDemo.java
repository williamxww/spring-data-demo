package com.bow.demo.join;

import com.alibaba.fastjson.JSON;
import com.bow.dao.aggregation.CustomAggregationOperation;
import com.bow.entity.OnuPmReportLK;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;

/**
 * @author wwxiang
 * @since 2017/8/29.
 */
public class LookUpDemo {

	private ApplicationContext context;

	private MongoTemplate template;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("mongo.xml");
		template = context.getBean(MongoTemplate.class);
	}

	/**
	 * FIXME 求总数怎么搞？<br/>
	 * 10W 无排序，仅有过滤98ms; 10W 根据cpuUsage排序，耗时7158
	 *
	 * 100W 无排序，仅有过滤 前10条1454ms skip(9_0000) limit(10) 55365;
	 * 根据cpuUsage排序，耗时85087
	 *
	 * 执行 from onuPmReport left join onu on onuPmReport.oId = onu._id where
	 * onuPmReport._id=4;
	 * 
	 * <pre>
	 db.getCollection('onuPmReportLK').aggregate([
	     {
	        $lookup:
	         {
	             from:"onu",
	             localField:"oId",
	             foreignField:"_id",
	             as:"right"
	         }
	     },
	     {$match:{"right.onuName":"ONU-1"}},
	     {$sort:{"cpuUsage":1}},
	     {$skip:0},
	     {$limit:10}
	
	 ],{allowDiskUse:true});
	 * </pre>
	 */
	@Test
	public void lookup() {

		long begin = System.currentTimeMillis();
		Aggregation aggregation = Aggregation.newAggregation(
                new CustomAggregationOperation(new BasicDBObject("$lookup",
                        new BasicDBObject("from", "onu")
                                .append("localField", "oId")
                                .append("foreignField", "_id")
                                .append("as", "right"))),

//				Aggregation.match(Criteria.where("right.onuName").is("ONU-1")),
//				 Aggregation.project("cpuUsage", "right.onuName"),
				 Aggregation.sort(Sort.Direction.ASC, "cpuUsage"),
				Aggregation.skip(90000),
				Aggregation.limit(10)
                // 构造lookup


		);
		AggregationResults<OnuPmReportLK> reports = template.aggregate(aggregation, "onuPmReportLK", OnuPmReportLK.class);
		long end = System.currentTimeMillis();
		System.out.println("Elapse time " + (end - begin));
		for (OnuPmReportLK r : reports) {
			System.out.println(JSON.toJSONString(r));
		}

	}



	/**
	 * <pre>
	 // 创建角色
	 use admin
	 db.createRole({
	     role:'sysadmin',
	     roles:[],
	     privileges:[{resource:{anyResource:true},actions:['anyAction']}]
	 })
	
	 // 创建用户
	 use admin
	 db.createUser({
	         user: "xww",
	         pwd: "123456",
	         roles: [
	             { role: "userAdminAnyDatabase", db: "admin" },
	             { role: "sysadmin", db: "admin" },
	             { role: "root", db: "admin" }
	         ]
	     })
	
	
	 // 查询或删除用户
	 db.system.users.find();
	 db.system.users.remove({user:'xww'});
	
	
	 // 创建存储过程
	 db.system.js.save({
	     _id: "echoFunction" ,
	     value : function(x1) { return x1; }
	 });
	 * 
	 * </pre>
	 *
	 */
	@Test
	public void eval() {
		DBObject command = new BasicDBObject("$eval", "echoFunction(1)");
		CommandResult result = template.executeCommand(command);
		System.out.println(JSON.toJSONString(result));
	}
}
