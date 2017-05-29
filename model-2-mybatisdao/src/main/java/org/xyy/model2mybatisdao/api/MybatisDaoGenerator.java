package org.xyy.model2mybatisdao.api;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.xyy.model2mybatisdao.api.genarticles.JavaModelGenerator;
import org.xyy.model2mybatisdao.config.Config;
import org.xyy.model2mybatisdao.util.SmartPathUtil;

import java.io.IOException;
import java.nio.charset.Charset;

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
    private Config config;

    public MybatisDaoGenerator(Config config) {
        this.config = config;
    }

    public void generate(String modelspackage){
        //找出所有包中的 source
    }

    public void generateSingle(String modelfilepath) throws IOException {
        // 解析

        String javamodel = JavaModelGenerator.genEntity(modelfilepath,config);
        String javaquery = JavaModelGenerator.genQuery(modelfilepath,config);
        String javamapper = JavaModelGenerator.genMapper(modelfilepath,config);
        String mapperxml = JavaModelGenerator.genXml(modelfilepath,config);

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



}
