package com.skt.opensocial.wrapper.persistence.util;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * To provide fully facilitated SqlMapClient object
 * @author Duri Kim
 *
 */
public class IBATISSqlMapper {
	private static final SqlMapClient sqlMap;
	static {
		try {
			String resource = "com/skt/opensocial/wrapper/persistence/config/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader (resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException ("Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}
	public static SqlMapClient getSqlMapInstance () {
		return sqlMap;
	}

}
