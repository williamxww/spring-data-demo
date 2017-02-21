package com.bow.dao;

import com.bow.entity.Employee;

import java.util.List;

/**
 * 接口扩展
 * @author vv
 * @since 2017/2/10.
 */
public interface EmployeeExt {
    List<Employee> search(int page, int size);
}
