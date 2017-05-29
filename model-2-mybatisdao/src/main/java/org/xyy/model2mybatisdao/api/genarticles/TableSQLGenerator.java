package org.xyy.model2mybatisdao.api.genarticles;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.xyy.model2mybatisdao.internal.parse.TableModelParse;
import org.xyy.model2mybatisdao.model.TableModel;
import org.xyy.model2mybatisdao.util.VelocityUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author xyy
 * @version 1.0 2017/5/25.
 * @since 1.0
 */
public class TableSQLGenerator {
    private static String vm = "sql/create-table.vm";

    /*public static String gen(String sourceFile){
        Table table = Sourcemodel2Table.convertModel(sourceFile);
        return VelocityUtil.mergeTable(vm, table);
    }*/

    public static String gen(String sourceFile){
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
        TableModel table = TableModelParse.parse(compilationUnit);
        return VelocityUtil.mergeTable(vm, table);
    }

}
