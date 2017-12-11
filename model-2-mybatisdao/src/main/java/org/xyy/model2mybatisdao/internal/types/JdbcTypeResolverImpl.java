package org.xyy.model2mybatisdao.internal.types;

import org.xyy.model2mybatisdao.typresolve.JdbcTypeResolver;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class JdbcTypeResolverImpl implements JdbcTypeResolver {
    private static Map<String, String> maps = new HashMap<>();
    private static Map<Integer, String> jdbcTypeNames = new HashMap<>();

    static {
        jdbcTypeNames.put(Types.BIGINT, "BIGINT");
        jdbcTypeNames.put(Types.VARCHAR, "VARCHAR");
        jdbcTypeNames.put(Types.TIMESTAMP, "TIMESTAMP");
        jdbcTypeNames.put(Types.INTEGER, "INTEGER");
        jdbcTypeNames.put(Types.BIT, "BIT");



        maps.put("Integer", jdbcTypeNames.get(Types.BIGINT));
        maps.put("int", jdbcTypeNames.get(Types.INTEGER));
        maps.put("Long", jdbcTypeNames.get(Types.BIGINT));
        maps.put("long", jdbcTypeNames.get(Types.BIGINT));
        maps.put("Date",jdbcTypeNames.get(Types.TIMESTAMP));
        maps.put("Boolean",jdbcTypeNames.get(Types.BIT));
        maps.put("String",jdbcTypeNames.get(Types.VARCHAR));

    }

    @Override
    public String calculateJdbcTypeName(String javatype) {
        return maps.get(javatype);
    }



}
