package com.bow.dao;

import com.bow.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 此类用于扩展Repository接口，注意类名为{@link EmployeeRepository}+"Impl"
 * 
 * @author vv
 * @since 2017/2/10.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeExt {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Employee> search(int page, int size) {
        Query query = new Query();
        // Criteria c = new Criteria();
        // query.addCriteria(Criteria.where("name").is(keyword));
        // query.with(new Sort(Sort.Direction.valueOf(direction), sort));
        query.with(new PageRequest(page - 1, size));
        return mongoTemplate.find(query, Employee.class);
    }
}
