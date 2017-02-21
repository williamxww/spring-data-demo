package com.bow.dao.customize;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 使所有repository都有{@link #support(String)}方法
 *
 * @author vv
 * @since 2017/2/16.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends MongoRepository<T,ID> {
    boolean support(String modelType);
}
