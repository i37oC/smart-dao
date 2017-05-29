package org.xyy.model2mybatisdao.model;

import java.util.List;

/**
 * @author xyy
 * @version 1.0 2017/5/29.
 * @since 1.0
 */
public class TableModel {
    private String name;

    private String comment;

    private Column primaryColumn;

    private List<Column> columns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Column getPrimaryColumn() {
        return primaryColumn;
    }

    public void setPrimaryColumn(Column primaryColumn) {
        this.primaryColumn = primaryColumn;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public static class Column{
        /**
         * 字段名
         */
        private String name;

        /**
         * 字段类型
         */
        private String type;

        /**
         * 是否主键
         */
        private int isPk;

        /**
         * 字段长度
         */
        private String length;

        /**
         * 评论
         */
        private String comment;

        /**
         * 为空
         */
        private String canbeNull;

        /**
         * 其他信息，比如是否自增 auto_increment; on update current_timestamp
         */
        private String extra;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getIsPk() {
            return isPk;
        }

        public void setIsPk(int isPk) {
            this.isPk = isPk;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCanbeNull() {
            return canbeNull;
        }

        public void setCanbeNull(String canbeNull) {
            this.canbeNull = canbeNull;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }
    }
}
