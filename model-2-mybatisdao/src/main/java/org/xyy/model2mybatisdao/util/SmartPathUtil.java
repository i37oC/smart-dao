package org.xyy.model2mybatisdao.util;


/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class SmartPathUtil {
    public static String combineModel(String project, String packagepath, String classname){
        packagepath = packagepath.replaceAll("\\.", "/");
        return project + "/" + packagepath + "/" + classname + ".java";
    }

    public static String combineQuery(String project, String packagepath, String classname){
        packagepath = packagepath.replaceAll("\\.", "/");
        return project + "/" + packagepath+ "/" + classname + "Query.java";
    }

    public static String combineMapper(String project, String packagepath, String classname){
        packagepath = packagepath.replaceAll("\\.", "/");
        return project + "/" + packagepath + "/" + classname + "Mapper.java";
    }

    public static String combineSql(String project, String packagepath, String classname){
        packagepath = packagepath.replaceAll("\\.", "/");
        return project + "/" + packagepath + "/" + classname + "Mapper.xml";
    }

}
