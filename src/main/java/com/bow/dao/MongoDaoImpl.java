package com.bow.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vv
 * @since 2017/2/10.
 */
@Repository
public class MongoDaoImpl<T> implements MongoDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<T> find(Query query) {
        return null;
    }

    @Override
    public T findOne(Query query) {
        return null;
    }

    @Override
    public void update(Query query, Update update) {

    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public T findById(String id) {
        return null;
    }

    @Override
    public T findById(String id, String collectionName) {
        return null;
    }

    @Override
    public long count(Query query) {
        return 0;
    }
}
