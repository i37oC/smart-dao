package org.xyy.model2mybatisdao.util;


/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class SmartPathUtil {
    public static String combineModel(String project, String packagepath, String classname){
        //packagepath = packagepath.replaceAll("\\.", "/");
        //return project + "/" + packagepath + "/" + classname + ".java";
        return combine(project,packagepath,classname,".java");
    }

    public static String combineQuery(String project, String packagepath, String classname){
        //packagepath = packagepath.replaceAll("\\.", "/");
        //return project + "/" + packagepath+ "/" + classname + "Query.java";
        return combine(project,packagepath,classname,"Query.java");

    }

    public static String combineMapper(String project, String packagepath, String classname){
        //packagepath = packagepath.replaceAll("\\.", "/");
        //return project + "/" + packagepath + "/" + classname + "Mapper.java";
        return combine(project,packagepath,classname,"Mapper.java");
    }

    public static String combineSql(String project, String packagepath, String classname){
        //packagepath = packagepath.replaceAll("\\.", "/");
        //return project + "/" + packagepath + "/" + classname + "Mapper.xml";
        return combine(project,packagepath,classname,"Mapper.xml");

    }

    private static String combine(String project, String packagepath, String classname, String prefix){
        //如果没有文件先创建
        packagepath = packagepath.replaceAll("\\.", "/");
        return project + "/" + packagepath + "/" + classname + prefix;
    }

}
