package org.xyy.model2mybatisdao.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.xyy.model2mybatisdao.api.genarticles.JavaModelGenerator;
import org.xyy.model2mybatisdao.config.Config;
import org.xyy.model2mybatisdao.util.SmartPathUtil;

import java.io.File;
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
            File file = new File(sourcePackage);
            if(file.isFile() || !file.exists()){
                throw new IllegalArgumentException("sourcePackage is not exist or not a direcot");
            }
            File[] files = file.listFiles();
            if(files == null || files.length==0){
                throw new RuntimeException("sourcePackage " + sourcePackage + " contains no file");
            }

            for(File sourceFile : files){
                gen(sourceFile.getAbsolutePath(), config);
            }


        }else{
            String[] sourceFiles = config.getSourceFiles();
            for(String sourceFile : sourceFiles){
                gen(sourceFile, config);
            }
        }

        //拷贝 commonquery.java 到 目标位置
        Resource commonqueryfile_me = new ClassPathResource("CommonQuery.java");
        WritableResource commonqueryfile = new FileSystemResource(SmartPathUtil.combineModel(config.getQuerycommonProject(),config.getQuerycommonPackage(),"CommonQuery"));
        String commonQueryStr = StreamUtils.copyToString(commonqueryfile_me.getInputStream(), Charset.forName("utf-8"));
        commonQueryStr = commonQueryStr.replaceAll("xxxyyy", config.getQuerycommonPackage());
        StreamUtils.copy(commonQueryStr, Charset.forName("utf-8"), commonqueryfile.getOutputStream());
    }

    private void gen(String sourceFile, Config config) throws IOException {
        // 解析

        String javamodel = JavaModelGenerator.genEntity(sourceFile, config);
        String javaquery = JavaModelGenerator.genQuery(sourceFile, config);
        String javamapper = JavaModelGenerator.genMapper(sourceFile, config);
        String mapperxml = JavaModelGenerator.genXml(sourceFile, config);


        String classname = getSourcefilename(sourceFile);


        // 写数据
        String javaModelTargetPath = SmartPathUtil.combineModel(config.getModelProject(),config.getModelPackage(),classname);
        writeFile(javamodel, javaModelTargetPath);

        String javamapperrTargetPath = SmartPathUtil.combineMapper(config.getMapperProject(),config.getMapperPackage(),classname);
        writeFile(javamapper, javamapperrTargetPath);

        String javaqueryTargetPath = SmartPathUtil.combineQuery(config.getQueryProject(),config.getQueryPackage(),classname);
        writeFile(javaquery, javaqueryTargetPath);

        String mapperXmlTargetPath = SmartPathUtil.combineSql(config.getSqlProject(),config.getSqlnamespace(),classname);
        writeFile(mapperxml, mapperXmlTargetPath);

    }


    private static void writeFile(String source, String targetFilePath) throws IOException {
        File file = new File(targetFilePath);
        File mulu = file.getParentFile();
        //目录
        if(!mulu.exists()){
            mulu.mkdirs();
        }
        if(!file.exists()){
            file.createNewFile();
        }
        WritableResource fileSystemResource = new FileSystemResource(file);
        StreamUtils.copy(source, Charset.forName("utf-8"), fileSystemResource.getOutputStream());
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
        config.setSourceFiles(!StringUtils.isEmpty(sourceFiles)?sourceFiles.split(","):null);

        return config;
    }


    private static String getSourcefilename(String sourcefilePath){
        String[] ss = sourcefilePath.split("/");
        String classname = ss[ss.length-1].replaceAll("\\.java", "");
        return classname;
    }

   public static void main(String[] args) {
        String name = "/Users/xyy/IdeaProjects/smart-dao/model-2-mybatisdao/src/main/resources/sql";
        File file = new File(name);
        File[] files = file.listFiles();
       System.out.println(file);
       for(File s : files){
           System.out.println(s.getAbsolutePath());
       }
    }

}
