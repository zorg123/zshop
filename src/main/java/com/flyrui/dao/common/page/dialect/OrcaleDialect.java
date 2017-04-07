package com.flyrui.dao.common.page.dialect;

public class OrcaleDialect implements Dialect {

	
    public String getPaginationSql(String sql, int pageNo, int pageSize) {

       return "select * from (select rownum rn, t.* from (" + sql
              + ") t where rownum <= " + (pageNo* pageSize)
              + ") t1 where t1.rn > " + ((pageNo-1) * pageSize);

    }

}
