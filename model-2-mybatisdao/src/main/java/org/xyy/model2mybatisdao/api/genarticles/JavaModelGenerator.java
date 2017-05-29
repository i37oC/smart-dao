package org.xyy.model2mybatisdao.api.genarticles;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.xyy.model2mybatisdao.config.Config;
import org.xyy.model2mybatisdao.internal.parse.JavaModelParse;
import org.xyy.model2mybatisdao.model.JavaModel;
import org.xyy.model2mybatisdao.util.VelocityUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author xyy
 * @version 1.0 2017/5/25.
 * @since 1.0
 */
public class JavaModelGenerator {

    private static String entity_vm = "my-template/common-entity.vm";
    private static String mapper_vm = "my-template/mybatis-mapper-class.vm";
    private static String query_vm = "my-template/common-query.vm";
    private static String xml_vm = "my-template/mybatis-mapper-xml.vm";


    public static String genEntity(String sourceFile,  Config config){
        JavaModel javaModel = getJavamodel(sourceFile);
        return VelocityUtil.mergeEntity(entity_vm, javaModel, config);
    }

    public static String genQuery(String sourceFile,  Config config){
        JavaModel javaModel = getJavamodel(sourceFile);
        return VelocityUtil.mergeEntity(query_vm, javaModel, config);
    }

    public static String genMapper(String sourceFile,  Config config){
        JavaModel javaModel = getJavamodel(sourceFile);
        return VelocityUtil.mergeEntity(mapper_vm, javaModel, config);
    }

    public static String genXml(String sourceFile,  Config config){
        JavaModel javaModel = getJavamodel(sourceFile);
        return VelocityUtil.mergeEntity(xml_vm, javaModel, config);
    }

    private static CompilationUnit getCompilationUnit(String sourceFile){
        File resource = new File(sourceFile);
        if(!resource.exists()){
            throw new IllegalArgumentException("java 原文件不存在：sourceFile = " + resource.getPath());
        }
        if(!resource.isFile()){
            throw new IllegalArgumentException("参数地址不能是文件夹：sourceFile = " + resource.getPath());
        }
        CompilationUnit compilationUnit = null;
        try {
            compilationUnit = JavaParser.parse(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compilationUnit;
    }

    public static JavaModel getJavamodel(CompilationUnit compilationUnit){
        return JavaModelParse.parse(compilationUnit);
    }

    public static JavaModel getJavamodel(String sourceFile){
        CompilationUnit compilationUnit = getCompilationUnit(sourceFile);
        JavaModel javaModel = JavaModelParse.parse(compilationUnit);
        return javaModel;
    }

}
