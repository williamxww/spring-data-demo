package com.bow.dao;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author wwxiang
 * @since 2017/8/11.
 */
public class AggregationHelper {

	public static <T> List<T> findByPage(Query query, Class<T> clazz, String collectionName) {

		return null;
	}

	public static void main(String[] args) {
		Criteria c1 = Criteria.where("f1").regex("v1");
		Criteria c2 = Criteria.where("f2").lt("v2");
		Query query = new Query(c1.andOperator(c2));

		Sort s1 = new Sort(Sort.Direction.ASC, "f1");
		Sort s2 = new Sort(Sort.Direction.ASC, "f2");
		query.with(s1).with(s2);
		query.skip(20);
		query.limit(5);
		DBObject queryObj = query.getQueryObject();
		DBObject sortObj = query.getSortObject();

		System.out.println(queryObj);
		System.out.println(sortObj);

        parse(queryObj.toString());

		// for (String key : queryObj.keySet()) {
		// Object obj = queryObj.get(key);
		// System.out.println(obj);
		// }

	}

	public static Criteria parse(String queryStr) {
//		DBObject dbObject = (DBObject) JSON.parse(queryStr);
        JSON.parse(queryStr);
//        dbObject.keySet();
		return null;
	}

}
