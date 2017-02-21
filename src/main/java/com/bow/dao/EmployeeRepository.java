package com.bow.dao;

import com.bow.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * 一些扩展方法放在{@link EmployeeExt}里
 * 
 * @author vv
 * @since 2017/2/8.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String>, EmployeeExt {

    Employee findByName(String name);

    /**
     * find
     * 
     * @param age
     *            第0个参数
     * @return List<Employee>
     */
    @Query("{ age: ?0 }")
    List<Employee> find(int age);

    List<Employee> findByAgeGreaterThan(int age);
}
