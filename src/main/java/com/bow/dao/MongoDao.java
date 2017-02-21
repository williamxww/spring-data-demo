package com.bow.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author vv
 * @since 2017/2/10.
 */
public interface MongoDao<T> {

    List<T> find(Query query);

    T findOne(Query query);

    void update(Query query, Update update);

    T save(T entity);

    T findById(String id);

    T findById(String id, String collectionName);

    long count(Query query);
}
