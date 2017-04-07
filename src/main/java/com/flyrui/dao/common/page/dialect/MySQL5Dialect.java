package com.flyrui.dao.common.page.dialect;

public class MySQL5Dialect implements Dialect {
	
    public String getPaginationSql(String sql, int offset, int limit) {
    	if( offset >0){
    		offset--;
    	}
    	
		return sql + " limit " + offset + "," + limit;
    }

}
