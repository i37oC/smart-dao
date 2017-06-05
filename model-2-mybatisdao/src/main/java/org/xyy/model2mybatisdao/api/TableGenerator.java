package org.xyy.model2mybatisdao.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.xyy.model2mybatisdao.api.genarticles.TableSQLGenerator;
import org.xyy.model2mybatisdao.config.Config;
import org.xyy.model2mybatisdao.config.JDBCConnectionConfiguration;
import org.xyy.model2mybatisdao.util.JDBCConnectionFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class TableGenerator {


    public void gen() throws SQLException {
        Config config = initConfig();
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(config.getDbUrl());
        jdbcConnectionConfiguration.setUserId(config.getDbName());
        jdbcConnectionConfiguration.setPassword(config.getDbPass());
        jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");

        ConnectionFactory connectionFactory = new JDBCConnectionFactory(jdbcConnectionConfiguration);

        Connection conn = connectionFactory.getConnection();


        String sourcePackage = config.getSourcePackage();
        if(!StringUtils.isEmpty(sourcePackage)){
            //
            File file = new File(sourcePackage);
            if(file.isFile() || !file.exists()){
                throw new IllegalArgumentException("sourcePackage is not exist or not a direcot");
            }
            File[] files = file.listFiles();
            if(files == null || files.length==0){
                throw new RuntimeException("sourcePackage " + sourcePackage + " contains no file");
            }

            for(File sourceFile : files){
                String sql = TableSQLGenerator.gen(sourceFile.getAbsolutePath());
                System.out.println(sql);
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.execute();
            }


        }else{
            String[] sourceFiles = config.getSourceFiles();
            for(String sourceFile : sourceFiles){
                String sql = TableSQLGenerator.gen(sourceFile);
                System.out.println(sql);
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.execute();
            }
        }

    }




    private Config initConfig(){
        //先去 类路径下 加载 smart-dao.properties 文件；如果没有则报错
        Resource resource = new ClassPathResource("smart-dao.properties");
        if(!resource.exists()){
            throw new IllegalArgumentException("配置文件不存在，请在类路径下建立 smart-dao.properties 并设置相关属性");
        }

        //检查 必要字段
        Properties pps = new Properties();
        try {
            pps.load(resource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("读取配置文件出错");
        }

        String sourcePackage = pps.getProperty("source.package");
        String sourceFiles = pps.getProperty("source.files");
        if(StringUtils.isEmpty(sourcePackage) && StringUtils.isEmpty(sourceFiles)){
            throw new IllegalArgumentException("smart-dao.properties 中 source.package 和 source.files 必须指定一个");
        }

        /*Resource sourcePackgeResource = new FileSystemResource(sourcePackage);
        if(!sourcePackgeResource.exists()){
            throw new IllegalArgumentException(" source.package 文件不存在");
        }*/

        //


        Config config =  new Config();

        config.setModelPackage(pps.getProperty("model.package"));
        config.setModelProject(pps.getProperty("model.project"));

        config.setQueryProject(pps.getProperty("query.project"));
        config.setQueryPackage(pps.getProperty("query.package"));

        config.setMapperProject(pps.getProperty("mapper.project"));
        config.setMapperPackage(pps.getProperty("mapper.package"));

        config.setSqlProject(pps.getProperty("xml.project"));
        config.setSqlnamespace(pps.getProperty("xml.package"));

        config.setQuerycommonProject(pps.getProperty("commonqurey.project"));
        config.setQuerycommonPackage(pps.getProperty("commonquery.package"));

        // 资源文件
        config.setSourcePackage(sourcePackage);
        config.setSourceFiles(sourceFiles.split(","));


        config.setDbUrl(pps.getProperty("db.url"));
        config.setDbName(pps.getProperty("db.name"));
        config.setDbPass(pps.getProperty("db.pass"));


        return config;
    }
}
