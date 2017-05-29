package org.xyy.model2mybatisdao.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.xyy.model2mybatisdao.config.Config;
import org.xyy.model2mybatisdao.model.JavaModel;
import org.xyy.model2mybatisdao.model.TableModel;

import java.io.StringWriter;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class VelocityUtil {


    public static String mergeEntity(String template, JavaModel javaModel, Config config){
        VelocityEngine ve = new VelocityEngine();
        // 设置模板加载路径，这里设置的是class下
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");
        ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        try {
            // 进行初始化操作
            ve.init();
            // 加载模板，设定模板编码
            Template t = ve.getTemplate(template, "UTF-8");
            // 设置初始化数据
            VelocityContext context = new VelocityContext();
            context.put("class", javaModel);

            if(null != config){
                context.put("config", config);
            }

            StringWriter sw = new StringWriter();
            t.merge(context, sw);
            String result = sw.getBuffer().toString();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("模版转化错误!");
        }
    }


    public static String mergeTable(String template, TableModel table){
        // 创建引擎
        VelocityEngine ve = new VelocityEngine();
        // 设置模板加载路径，这里设置的是class下
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");
        ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        try {
            // 进行初始化操作
            ve.init();
            // 加载模板，设定模板编码
            Template t = ve.getTemplate(template, "UTF-8");
            // 设置初始化数据
            VelocityContext context = new VelocityContext();
            context.put("table", table);

            StringWriter sw = new StringWriter();
            t.merge(context, sw);
            String result = sw.getBuffer().toString();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("模版转化错误!");
        }
    }
}
