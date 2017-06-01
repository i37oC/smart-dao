package org.xyy.model2mybatisdao.model;

import java.util.List;

/**
 * java 查询对象的生成数据封装类
 *
 * 用于生成 java-entity, java-query, java-mapper, mapper.xml 四个文件
 *
 * @author xyy
 * @version 1.0 2017/5/29.
 * @since 1.0
 */
public class JavaModel {

    private String name;
    private String objectName; // 类名 首字母小写
    private String comment;
    private String fullPackage;

    private List<Field> fields;
    private List<Field> nonPkfields;
    private Field pkField;

    private String tableName;
    private String tableAlias;

    public List<Field> getNonPkfields() {
        return nonPkfields;
    }

    public void setNonPkfields(List<Field> nonPkfields) {
        this.nonPkfields = nonPkfields;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Field getPkField() {
        return pkField;
    }

    public void setPkField(Field pkField) {
        this.pkField = pkField;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullPackage() {
        return fullPackage;
    }

    public void setFullPackage(String fullPackage) {
        this.fullPackage = fullPackage;
    }

    public String getName() {
        return name;
    }

    public void setClassName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public static class Field{
        private String name;
        /**
         * 首字符大写的字段名，用于生成 get set 方法
         */
        private String fieldNameFirstCharUpcase;
        private String comment;
        private String type;
        private int isPk;

        //---- xml 数据
        private String columnName;
        private String jdbcType;
        private String mybatisType;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFieldNameFirstCharUpcase() {
            return fieldNameFirstCharUpcase;
        }

        public void setFieldNameFirstCharUpcase(String fieldNameFirstCharUpcase) {
            this.fieldNameFirstCharUpcase = fieldNameFirstCharUpcase;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getIsPk() {
            return isPk;
        }

        public void setIsPk(int isPk) {
            this.isPk = isPk;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String getJdbcType() {
            return jdbcType;
        }

        public void setJdbcType(String jdbcType) {
            this.jdbcType = jdbcType;
        }

        public String getMybatisType() {
            return mybatisType;
        }

        public void setMybatisType(String mybatisType) {
            this.mybatisType = mybatisType;
        }
    }
}
