package com.bow.dao;

import com.bow.entity.Employee;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author vv
 * @since 2017/2/10.
 */
public class EmployeeRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryTest.class);

    private EmployeeRepository dao;

    @Before
    public void setup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mongo.xml");
        dao = context.getBean(EmployeeRepository.class);
    }

    @Test
    public void save() {
        Employee employee = new Employee();
        employee.setName("vv");
        employee.setAge(27);
        dao.save(employee);
    }

    @Test
    public void findByName() {
        Employee employee = dao.findByName("vv");
        System.out.println(employee.getAge());
    }

    @Test
    public void findByAge() {
        List<Employee> employees = dao.find(27);
        System.out.println(employees.size());
    }

    @Test
    public void findByAgeGreaterThan() {
        List<Employee> employees1 = dao.findByAgeGreaterThan(26);
        List<Employee> employees2 = dao.findByAgeGreaterThan(27);
        List<Employee> employees3 = dao.findByAgeGreaterThan(28);
        System.out.println(employees1.size() + "," + employees2.size() + "," + employees3.size());
    }

    @Test
    public void testExt(){
        List<Employee> employees = dao.search(1,1);
        System.out.println(employees.size());
    }

}