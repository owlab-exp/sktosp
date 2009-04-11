package com.owlab.sample.ibatis;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * To provide fully facilitated SqlMapClient object
 * @author Ernest Lee
 *
 */
public class SqlMapConfig {
	private static final SqlMapClient sqlMap;
	static {
		try {
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader (resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			// If you get an error at this point, it doesn’t matter what it was. It is going to be
			// unrecoverable and we will want the app to blow up hard so we are aware of the
			// problem. You should always log such errors and re-throw them in such a way that
			// you can be made immediately aware of the problem.
			e.printStackTrace();
			throw new RuntimeException ("Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}
	public static SqlMapClient getSqlMapInstance () {
		return sqlMap;
	}

}
