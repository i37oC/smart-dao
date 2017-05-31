package org.xyy.model2mybatisdao.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.xyy.model2mybatisdao.api.genarticles.JavaModelGenerator;
import org.xyy.model2mybatisdao.config.Config;
import org.xyy.model2mybatisdao.util.SmartPathUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * This class is the main interface to MyBatis DAO generator. A typical execution of the tool involves these steps:
 *
 * <ol>
 * <li>Create a Configuration object. The Configuration can be the result of a parsing the XML configuration file, or it
 * can be created solely in Java.</li>
 * <li>Create a MyBatisGenerator object</li>
 * <li>Call one of the generate() methods</li>
 * </ol>
 *
 * @author xyy
 * @version 1.0 2017/5/25.
 * @since 1.0
 */
public class MybatisDaoGenerator {


    public void gen() throws IOException {
        Config config = initConfig();



        String sourcePackage = config.getSourcePackage();
        if(!StringUtils.isEmpty(sourcePackage)){
            //
        }else{
            String[] sourceFiles = config.getSourceFiles();
            for(String sourceFile : sourceFiles){
                gen(sourceFile, config);
            }
        }

        //拷贝 commonquery.java 到 目标位置
        Resource commonqueryfile_me = new ClassPathResource("CommonQuery.java");
        WritableResource commonqueryfile = new FileSystemResource(SmartPathUtil.combineModel(config.getQuerycommonProject(),config.getQuerycommonPackage(),"CommonQuery"));
        StreamUtils.copy(commonqueryfile_me.getInputStream(), commonqueryfile.getOutputStream());

    }

    private void gen(String sourceFile, Config config) throws IOException {
        // 解析

        String javamodel = JavaModelGenerator.genEntity(sourceFile, config);
        String javaquery = JavaModelGenerator.genQuery(sourceFile, config);
        String javamapper = JavaModelGenerator.genMapper(sourceFile, config);
        String mapperxml = JavaModelGenerator.genXml(sourceFile, config);

        String classname = "User";

        // 写数据
        WritableResource javamodelresource = new FileSystemResource(SmartPathUtil.combineModel(config.getModelProject(),config.getModelPackage(),classname));
        StreamUtils.copy(javamodel, Charset.forName("utf-8"), javamodelresource.getOutputStream());

        WritableResource javamapperresource = new FileSystemResource(SmartPathUtil.combineMapper(config.getMapperProject(),config.getMapperPackage(),classname));
        StreamUtils.copy(javamapper, Charset.forName("utf-8"), javamapperresource.getOutputStream());

        WritableResource javaqueryresource = new FileSystemResource(SmartPathUtil.combineQuery(config.getQueryProject(),config.getQueryPackage(),classname));
        StreamUtils.copy(javaquery, Charset.forName("utf-8"), javaqueryresource.getOutputStream());

        WritableResource sqlmapperresource = new FileSystemResource(SmartPathUtil.combineSql(config.getSqlProject(),config.getSqlnamespace(),classname));
        StreamUtils.copy(mapperxml, Charset.forName("utf-8"), sqlmapperresource.getOutputStream());

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

        return config;
    }




}
