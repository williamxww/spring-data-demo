package com.bow.demo;

import com.alibaba.fastjson.JSON;
import com.bow.dao.aggregation.CustomAggregationOperation;
import com.mongodb.BasicDBObject;
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
 * @since 2017/8/30.
 */
public class AggregationTest {

    private ApplicationContext context;

    private MongoTemplate template;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("mongo.xml");
        template = context.getBean(MongoTemplate.class);
    }

    @Test
    public void aggregate() {

        long begin = System.currentTimeMillis();
        Aggregation aggregation = Aggregation
                .newAggregation(
                        Aggregation.match(Criteria.where("rcvOpMax").gt(100)),
                        Aggregation.sort(Sort.Direction.ASC, "portNo"),
                        Aggregation.skip(0),
                        Aggregation.limit(10)

                );
        AggregationResults<BasicDBObject> reports = template.aggregate(aggregation, "CacheOnuPonPortCollection10", BasicDBObject.class);
        //System.out.println(JSON.toJSONString(reports));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}
