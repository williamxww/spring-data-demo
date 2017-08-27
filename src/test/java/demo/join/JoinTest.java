package demo.join;

import com.alibaba.fastjson.JSON;
import com.bow.dao.aggregation.CustomAggregationOperation;
import com.bow.entity.Onu;
import com.bow.entity.OnuPmReport;
import com.mongodb.BasicDBObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * OnuPmReport left join Onu
 *
 * @author vv
 * @since 2017/8/27.
 */
public class JoinTest {

    private ApplicationContext context;

    private MongoTemplate template;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("mongo.xml");
        template = context.getBean(MongoTemplate.class);
    }

    @Test
    public void saveOnu() {
        Onu o1 = new Onu();
        o1.setEmsId(10000);
        o1.setNeId(10);
        o1.setBoardId(100);
        o1.setOltPonPortId(1);
        o1.setOnuId(1000);
        String id = o1.getEmsId() + "-" + o1.getNeId() + "-" + o1.getBoardId() + "-" + o1.getOltPonPortId() + "-"
                + o1.getOnuId();
        o1.setId(id);
        o1.setOnuName("ONU NAME001");
        template.save(o1);

        OnuPmReport report = new OnuPmReport();
        report.setId(1);
        report.setoId(id);
        // 通过引用嵌入文档
        report.setOnu(o1);
        report.setCpuUsage(0.9);
        report.setTemperature(50.0);
        report.setUpSpeed(0.3);
        template.save(report);
    }

    /**
     * 创建实体时，只需要依赖的实体主键
     */
    @Test
    public void save2() {
        OnuPmReport report = new OnuPmReport();
        report.setId(2);
        report.setCpuUsage(0.9);
        report.setTemperature(50.0);
        report.setUpSpeed(0.3);

        // 外键
        Onu o1 = new Onu();
        o1.setId("10000-10-100-1-1000");
        report.setOnu(o1);
        template.save(report);
    }


    /**
     * <code>
     * // onuPmReport join onu
     * db.onuPmReport.findOne({}).onu.fetch();
     * </code>
     */
    @Test
    public void query() {
        Query query = new Query();
        // 只能根据$ref.$id进行过滤，不能根据从表的其他字段过滤
        Criteria c1 = Criteria.where("onu.id").is("10000-10-100-1-1000");
        query.addCriteria(c1);
        List<OnuPmReport> result = template.find(query, OnuPmReport.class);
        for (OnuPmReport report : result) {
            System.out.println(report.getId() + "--" + report.getOnu().getOnuName());
        }
    }

    /**
     * 先找到从表的主键，然后根据此主键对主表进行过滤。<br/>
     * 先根据ONU名称找到数据id,然后根据id即可找到整条数据(性能+名称)
     */
    @Test
    public void query2() {
        Query q1 = new Query();
        Criteria c1 = Criteria.where("onuName").is("ONU NAME001");
        q1.addCriteria(c1);
        List<Onu> r1 = template.find(q1, Onu.class);
        for (Onu o : r1) {
            String oid = o.getId();
            Query q2 = new Query();
            Criteria c2 = Criteria.where("onu.id").is(oid);
            q2.addCriteria(c2);
            List<OnuPmReport> r2 = template.find(q2, OnuPmReport.class);
            System.out.println(JSON.toJSONString(r2));
        }
    }

    /**
     * 为lookup准备数据
     */
    @Test
    public void savePm() {
        OnuPmReport report = new OnuPmReport();
        report.setId(4);
        // 外联的字段
        report.setoId("10001-10-100-1-1000");
        report.setCpuUsage(0.9);
        report.setTemperature(50.0);
        report.setUpSpeed(0.3);
        template.save(report);
    }

    /**
     * <code>
     * db.onuPmReport.aggregate([
     *     {$match : {_id : 4}},
     *     {
     *     $lookup:
     *     {
     *     from: "onu",
     *     localField: "oId",
     *     foreignField: "_id",
     *     as: "right"
     *     }
     *     }
     * ]);
     * </code>
     *
     */
    @Test
    public void lookup() {

        Aggregation aggregation = Aggregation.newAggregation(
                // onuPmReport left join onu on onuPmReport.oId = onu._id where onuPmReport._id=4;
                 Aggregation.match(Criteria.where("_id").is(4)),
                // 构造lookup
                new CustomAggregationOperation(new BasicDBObject("$lookup",
                new BasicDBObject("from", "onu")
                        .append("localField", "oId")
                        .append("foreignField", "_id")
                        .append("as", "right")))
                        );
        AggregationResults<OnuPmReport> reports = template.aggregate(aggregation, "onuPmReport", OnuPmReport.class);
        for (OnuPmReport r : reports) {
            // 获取右连的表
            List<Onu> right = r.getRight();
            for(Onu o: right){
                System.out.println(o.getOnuName());
            }
        }
    }
}
