package org.xyy.model2mybatisdao.typresolve;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public interface MybatisParamTypeResolve {

    /**
     * 返回 column 对应的 JDBCtype 类型
     * @param javatype java 类型
     * @return
     */
    String calculateMybatisParamTypeName(String javatype);
}
