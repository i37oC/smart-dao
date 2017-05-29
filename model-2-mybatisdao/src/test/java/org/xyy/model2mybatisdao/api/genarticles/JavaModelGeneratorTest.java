package org.xyy.model2mybatisdao.api.genarticles;

import org.junit.Test;


/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class JavaModelGeneratorTest {
    private String sourceFile = "/Users/xyy/IdeaProjects/smart-dao/entity-2-mybatisdao/src/test/java/org/xyy/model2mybatisdao/source/User.java";

    @Test
    public void gen() throws Exception {
        String result = JavaModelGenerator.genEntity(sourceFile, null);
        System.out.println(result);
    }


    @Test
    public void genQuery() throws Exception {
        String result = JavaModelGenerator.genQuery(sourceFile,null);
        System.out.println(result);
    }

    @Test
    public void genMapper() throws Exception {
        String result = JavaModelGenerator.genMapper(sourceFile,null);
        System.out.println(result);
    }

    @Test
    public void genXml() throws Exception {
        String result = JavaModelGenerator.genXml(sourceFile, null);
        System.out.println(result);
    }

}