package com.flyrui.dao.common.page;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.flyrui.dao.pojo.sys.TbRole;

public class PaginationHelper {

	public static int getRowCount(SqlSession sqlSession, String statementName,
			Object values) {

		Map parameterMap = toParameterMap(values);
		int count = 0;
		try {

			MappedStatement mst = sqlSession.getConfiguration()
					.getMappedStatement(statementName);
			BoundSql boundSql = mst.getBoundSql(parameterMap);
			String sql = " select count(1) row_count from ("
					+ boundSql.getSql() + ") a ";
			PreparedStatement pstmt = sqlSession.getConnection()
					.prepareStatement(sql);
			setParameters(pstmt, mst, boundSql, parameterMap);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("row_count");
			}
			rs.close();
			pstmt.close();			
		} catch (Exception e) {
			count = 0;
			throw new RuntimeException(e);
		}finally{
			sqlSession.close();
		}
		return count;

	}

	private static void setParameters(PreparedStatement ps,
			MappedStatement mappedStatement,

			BoundSql boundSql, Object parameterObject) throws SQLException {

		ErrorContext.instance().activity("setting parameters")

		.object(mappedStatement.getParameterMap().getId());

		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();

		if (parameterMappings != null) {

			Configuration configuration = mappedStatement.getConfiguration();

			TypeHandlerRegistry typeHandlerRegistry = configuration
					.getTypeHandlerRegistry();

			MetaObject metaObject = parameterObject == null ? null
					: configuration

					.newMetaObject(parameterObject);

			for (int i = 0; i < parameterMappings.size(); i++) {

				ParameterMapping parameterMapping = parameterMappings.get(i);

				if (parameterMapping.getMode() != ParameterMode.OUT) {

					Object value;

					String propertyName = parameterMapping.getProperty();

					PropertyTokenizer prop = new PropertyTokenizer(propertyName);

					if (parameterObject == null) {

						value = null;

					} else if (typeHandlerRegistry
							.hasTypeHandler(parameterObject.getClass())) {

						value = parameterObject;

					} else if (boundSql.hasAdditionalParameter(propertyName)) {

						value = boundSql.getAdditionalParameter(propertyName);

					} else if (propertyName
							.startsWith(ForEachSqlNode.ITEM_PREFIX)

							&& boundSql.hasAdditionalParameter(prop.getName())) {

						value = boundSql.getAdditionalParameter(prop.getName());

						if (value != null) {

							value = configuration.newMetaObject(value)

							.getValue(
									propertyName.substring(prop.getName()
											.length()));

						}

					} else {

						value = metaObject == null ? null : metaObject
								.getValue(propertyName);

					}

					TypeHandler typeHandler = parameterMapping.getTypeHandler();

					if (typeHandler == null) {

						throw new ExecutorException(
								"There was no TypeHandler found for parameter "

								+ propertyName + " of statement "
										+ mappedStatement.getId());

					}

					typeHandler.setParameter(ps, i + 1, value, parameterMapping
							.getJdbcType());

				}

			}

		}

	}

	protected static Map toParameterMap(Object parameter) {

		if (parameter == null) {

			return new HashMap();

		}
		if (parameter instanceof Map) {
			return (Map<?, ?>) parameter;
		}  else {
			try {
				return PropertyUtils.describe(parameter);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static void main(String[] args){
		String a = "33";
		Map m = new HashMap();
		m.put("a", "33");
		TbRole tbRole = new TbRole();
		Map<String, Object> mapFf;
		try {
			mapFf = PropertyUtils.describe(tbRole);
			System.out.println(mapFf); 
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
