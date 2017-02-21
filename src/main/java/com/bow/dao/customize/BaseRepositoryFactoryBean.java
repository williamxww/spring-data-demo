package com.bow.dao.customize;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import java.io.Serializable;

/**
 * @author vv
 * @since 2017/2/19.
 */
public class BaseRepositoryFactoryBean <R extends MongoRepository<T, I>, T, I extends Serializable>
        extends MongoRepositoryFactoryBean<R, T, I> {


    protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
        return new MyRepositoryFactory(operations);
    }
}
