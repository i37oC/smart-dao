package org.xyy.model2mybatisdao.api;

import org.junit.Test;
import org.xyy.model2mybatisdao.config.Config;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class MybatisDaoGeneratorTest {
    private String javamodelpath = "/Users/xyy/IdeaProjects/smart-dao/smart-dao-example/src/main/java";
    private String sqlpath = "/Users/xyy/IdeaProjects/smart-dao/smart-dao-example/src/main/resources";

    private String modelPackage = "org.xyy.smart.dao.example.entity";
    private String queryPackage = "org.xyy.smart.dao.example.query";
    private String mapperPackage = "org.xyy.smart.dao.example.mapper";
    private String sqlPackage = "mapper";

    private String modelPath = "/Users/xyy/IdeaProjects/smart-dao/model-2-mybatisdao/src/test/java/org/xyy/model2mybatisdao/source/User.java";

    @Test
    public void generate() throws Exception {

    }

    @Test
    public void generateSingle() throws Exception {
        /*Config config = new Config();
        config.setModelProject(javamodelpath);
        config.setQueryProject(javamodelpath);
        config.setMapperProject(javamodelpath);
        config.setSqlProject(sqlpath);


        config.setModelPackage(modelPackage);
        config.setQueryPackage(queryPackage);
        config.setMapperPackage(mapperPackage);
        config.setSqlnamespace(sqlPackage);

        MybatisDaoGenerator generator = new MybatisDaoGenerator(config);
        generator.generateSingle(modelPath);*/

    }

    @Test
    public void gen() throws Exception {
        new MybatisDaoGenerator().gen();
    }

}