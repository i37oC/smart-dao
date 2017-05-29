package org.xyy.model2mybatisdao.internal.types;

import org.xyy.model2mybatisdao.typresolve.MybatisParamTypeResolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class MybatisParamTypeResolveImpl implements MybatisParamTypeResolve{

    private static Map<String, String> maps = new HashMap<>();

    static {




        maps.put("Integer", "interger");
        maps.put("Long", "long");
        maps.put("String","string");

    }


    @Override
    public String calculateMybatisParamTypeName(String javatype) {
        return maps.get(javatype);
    }
}
