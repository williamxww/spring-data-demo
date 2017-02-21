package com.bow.demo;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;

import com.bow.entity.Employee;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @author vv
 * @since 2017/1/22.
 */
public class MongoAppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoAppTest.class);

    @Test
    public void test(){
        List<MongoCredential> credentialsList = new ArrayList<>();
        MongoCredential credential = MongoCredential.createScramSha1Credential("admin", "admin", "admin".toCharArray());
        credentialsList.add(credential);
        MongoClient client = new MongoClient(new ServerAddress("127.0.0.1", 27017), credentialsList);
        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(client, "test"));
        mongoOps.insert(new Employee("Joe", 34));
        Employee person = mongoOps.findOne(new Query(where("name").is("Joe")), Employee.class);
        LOGGER.info(String.valueOf(person.getAge()));
        // mongoOps.dropCollection("person");
    }
}
