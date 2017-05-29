package org.xyy.model2dbtable.model;

import java.util.List;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class Table {
    private String tableName;
    private String tableComment;

    private List<Column> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
