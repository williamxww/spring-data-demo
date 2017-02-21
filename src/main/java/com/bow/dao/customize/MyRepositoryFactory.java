package com.bow.dao.customize;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import java.io.Serializable;

/**
 * @author vv
 * @since 2017/2/19.
 */
public class MyRepositoryFactory<T, I extends Serializable> extends MongoRepositoryFactory {

    private MongoOperations mongoOperations;

    public MyRepositoryFactory(MongoOperations mongoOperations) {
        super(mongoOperations);
        this.mongoOperations = mongoOperations;
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return BaseRepositoryImpl.class;
    }

    @Override
    protected Object getTargetRepository(RepositoryInformation information) {
        MongoEntityInformation<?, Serializable> entityInformation = getEntityInformation(information.getDomainType());
        return new BaseRepositoryImpl(entityInformation, mongoOperations);
    }
}
