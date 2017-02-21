package com.bow.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;

/**
 * @author vv
 * @since 2017/2/10.
 */
public class MyMongoConverterFactoryBean implements FactoryBean<MappingMongoConverter> {

    private MappingMongoConverter converter;

    public MyMongoConverterFactoryBean(MappingMongoConverter converter) {
        this.converter = converter;
    }

    @Override
    public MappingMongoConverter getObject() throws Exception {
        // 参数是Type在MongoDB中名字.
        // 设置为null的话就不会在保存时自动添加_class属性.
        // Spring默认为 DEFAULT_TYPE_KEY = "_class";
        MongoTypeMapper typeMapper = new DefaultMongoTypeMapper(null);
        converter.setTypeMapper(typeMapper);
        return converter;
    }

    @Override
    public Class<?> getObjectType() {
        return MappingMongoConverter.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
