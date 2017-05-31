package org.xyy.model2mybatisdao.model;

/**
 * @author xyy
 * @version 1.0 2017/5/30.
 * @since 1.0
 */
public interface QueryParam {
    String getSort();

    int getPageNo();

    int getPageSize();

    /**
     * 开始记录 从1开始
     */
    int getStartRow();

    /**
     * 开始记录 从0开始
     */
    int getStartRowBegin0();

    /**
     * 结束记录
     */
    int getEndRow();

    /**
     * select列
     */
    String[] getColumns();

    void setPageSize(int pageSize);

    /**
     * 是否按默认排序<br>
     * <br>
     * true -- 当排序表单式为空时，按默认排序 <br>
     * false -- 当排序表单式为空时，不排序 <br>
     * 默认 true
     */
    boolean isSortByDefault();

    /**
     * 是否包含已逻辑删除的数据<br>
     * <br>
     * 默认 false
     */
    boolean isIncludeDeleted();

}
