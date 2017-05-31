package org.xyy.model2mybatisdao.model;

/**
 * @author xyy
 * @version 1.0 2017/5/30.
 * @since 1.0
 */
public class QueryParamBase {
    private String sortCode;
    private int pageNo;
    private int pageSize;
    private int StartRowBegin;
    private String[] columns;

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public int getStartRowBegin() {
        return StartRowBegin;
    }

    public void setStartRowBegin(int startRowBegin) {
        StartRowBegin = startRowBegin;
    }
}
