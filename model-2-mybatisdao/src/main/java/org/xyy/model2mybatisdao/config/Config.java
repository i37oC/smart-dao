package org.xyy.model2mybatisdao.config;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class Config {
    private String modelProject;
    private String queryProject;
    private String mapperProject;
    private String sqlProject;

    private String modelPackage;
    private String queryPackage;
    private String mapperPackage;
    private String sqlnamespace;

    public String getModelProject() {
        return modelProject;
    }

    public void setModelProject(String modelProject) {
        this.modelProject = modelProject;
    }

    public String getQueryProject() {
        return queryProject;
    }

    public void setQueryProject(String queryProject) {
        this.queryProject = queryProject;
    }

    public String getMapperProject() {
        return mapperProject;
    }

    public void setMapperProject(String mapperProject) {
        this.mapperProject = mapperProject;
    }

    public String getSqlProject() {
        return sqlProject;
    }

    public void setSqlProject(String sqlProject) {
        this.sqlProject = sqlProject;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getQueryPackage() {
        return queryPackage;
    }

    public void setQueryPackage(String queryPackage) {
        this.queryPackage = queryPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getSqlnamespace() {
        return sqlnamespace;
    }

    public void setSqlnamespace(String sqlnamespace) {
        this.sqlnamespace = sqlnamespace;
    }
}
