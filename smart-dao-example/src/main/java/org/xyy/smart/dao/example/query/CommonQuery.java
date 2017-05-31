package org.xyy.smart.dao.example.query;

/**
 * @author xyy
 * @version 1.0 2017/5/30.
 * @since 1.0
 */
public class CommonQuery {
    private String sort;
    private int pageNo = 1;
    private int pageSize = 10;
    private int startRowBegin;
    private String[] columns;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        this.startRowBegin = (pageNo - 1) * this.pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.startRowBegin = (pageNo - 1) * this.pageSize;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public int getStartRowBegin() {
        return startRowBegin;
    }

}
