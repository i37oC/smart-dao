package org.xyy.model2mybatisdao.typresolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class MysqlColumnTypeResolver {
    private static Map<String, String> maps = new HashMap<>();

    static {

        maps.put("Integer", "bigint(11)");
        maps.put("Long", "bigint(11)");
        maps.put("String", "varchar(20)");
        maps.put("Date", "timestamp");
        maps.put("boolean", "BOOLEAN");
        maps.put("Boolean", "BOOLEAN");

    }


    /**
     * 根据 java 数据类型，转化为 mysql 的数据类型
     * @param javaType
     * @return
     */
    public static String resolveType(String javaType){
        String type = maps.get(javaType);
        return type;
    }

}
