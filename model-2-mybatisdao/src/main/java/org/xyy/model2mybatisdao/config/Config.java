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

    private String querycommonProject;
    private String querycommonPackage;

    private String sourcePackage;
    private String[] sourceFiles;

    //db
    private String dbUrl;
    private String dbName;
    private String dbPass;

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

    public String getSourcePackage() {
        return sourcePackage;
    }

    public void setSourcePackage(String sourcePackage) {
        this.sourcePackage = sourcePackage;
    }

    public String[] getSourceFiles() {
        return sourceFiles;
    }

    public void setSourceFiles(String[] sourceFiles) {
        this.sourceFiles = sourceFiles;
    }

    public String getQuerycommonProject() {
        return querycommonProject;
    }

    public void setQuerycommonProject(String querycommonProject) {
        this.querycommonProject = querycommonProject;
    }

    public String getQuerycommonPackage() {
        return querycommonPackage;
    }

    public void setQuerycommonPackage(String querycommonPackage) {
        this.querycommonPackage = querycommonPackage;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }
}
