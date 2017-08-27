package com.bow.dao.aggregation;

import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;

/**
 * @author vv
 * @since 2017/8/27.
 */
public class CustomAggregationOperation implements AggregationOperation {
    private DBObject operation;

    public CustomAggregationOperation(DBObject operation) {
        this.operation = operation;
    }

    @Override
    public DBObject toDBObject(AggregationOperationContext context) {
        return context.getMappedObject(operation);
    }
}
