package org.xyy.model2dbtable.model;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class Column {
    private String name;
    private String dataType;
    private String isPk;
    private String length;
    private String comment;
    private String canbeNull;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getIsPk() {
        return isPk;
    }

    public void setIsPk(String isPk) {
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
}
