package org.xyy.model2mybatisdao.api;

import org.junit.Test;
import org.xyy.model2mybatisdao.config.Config;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class MybatisDaoGeneratorTest {
    private String modelpath = "/Users/xyy/IdeaProjects/smart-dao/model-2-mybatisdao/src/test/java";
    private String querypath = "/Users/xyy/IdeaProjects/smart-dao/model-2-mybatisdao/src/test/java";
    private String mapperpath = "/Users/xyy/IdeaProjects/smart-dao/model-2-mybatisdao/src/test/java";
    private String sqlpath = "/Users/xyy/IdeaProjects/smart-dao/model-2-mybatisdao/src/test/java";

    private String modelPackage = "org.xyy.model2mybatisdao.target.entity";
    private String queryPackage = "org.xyy.model2mybatisdao.target.query";
    private String mapperPackage = "org.xyy.model2mybatisdao.target.mapper";
    private String sqlPackage = "org.xyy.model2mybatisdao.target.sql";

    private String modelPath = "/Users/xyy/IdeaProjects/smart-dao/model-2-mybatisdao/src/test/java/org/xyy/model2mybatisdao/source/User.java";

    @Test
    public void generate() throws Exception {

    }

    @Test
    public void generateSingle() throws Exception {
        Config config = new Config();
        config.setModelProject(modelpath);
        config.setQueryProject(querypath);
        config.setMapperProject(mapperpath);
        config.setSqlProject(sqlpath);


        config.setModelPackage(modelPackage);
        config.setQueryPackage(queryPackage);
        config.setMapperPackage(mapperPackage);
        config.setSqlnamespace(sqlPackage);

        MybatisDaoGenerator generator = new MybatisDaoGenerator(config);
        generator.generateSingle(modelPath);

    }

    @Test
    public void generateSingle1() throws Exception {

    }

}