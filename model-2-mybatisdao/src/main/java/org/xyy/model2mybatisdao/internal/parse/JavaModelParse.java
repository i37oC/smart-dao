package org.xyy.model2mybatisdao.internal.parse;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import org.xyy.model2mybatisdao.annotations.Pk;
import org.xyy.model2mybatisdao.internal.types.JdbcTypeResolverImpl;
import org.xyy.model2mybatisdao.model.JavaModel;
import org.xyy.model2mybatisdao.util.SmartStringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author xyy
 * @version 1.0 2017/5/29.
 * @since 1.0
 */
public class JavaModelParse {
    public static JavaModel parse(CompilationUnit compilationUnit){
        JavaModel javaModel = new JavaModel();

        //class-name
        List<Node> nodes = compilationUnit.getChildNodes();
        ClassOrInterfaceDeclaration classbody = null;
        for(Node node : nodes){
            if(node instanceof ClassOrInterfaceDeclaration){
                classbody = (ClassOrInterfaceDeclaration)node;
            }
        }
        String className = classbody.getNameAsString();
        javaModel.setClassName(className);
        javaModel.setObjectName(className.substring(0,1).toLowerCase()+className.substring(1,className.length()));

        //class-comment
        Optional<JavadocComment> commentOptional = classbody.getJavadocComment();
        if(commentOptional.isPresent()){
            String comment = SmartStringUtil.removeLasthauanhang(commentOptional.get().toString());
            javaModel.setComment(comment);
        }


        //设置字段
        List<JavaModel.Field> fields = new ArrayList<>();
        List<Node> classNodes = classbody.getChildNodes();
        List<FieldDeclaration> filedsDeclaration = new ArrayList<>();
        for(Node node : classNodes){
            if(node instanceof FieldDeclaration){
                filedsDeclaration.add((FieldDeclaration)node);
            }
        }

        for(FieldDeclaration fieldDeclaration : filedsDeclaration){
            JavaModel.Field field = new JavaModel.Field();


            String filedName = "";
            String filedType = "";

            Optional<JavadocComment> filedcommentOptional = fieldDeclaration.getJavadocComment();
            if(filedcommentOptional.isPresent()){
                String comment = SmartStringUtil.removeLasthauanhang(filedcommentOptional.get().toString());
                field.setComment(comment);
            }


            List<Node> filedsnodes = fieldDeclaration.getChildNodes();
            for(Node varible : filedsnodes){
                if(varible instanceof VariableDeclarator){
                    filedName = ((VariableDeclarator) varible).getName().toString();
                    filedType = ((VariableDeclarator) varible).getType().toString();
                }
            }



            field.setName(filedName);
            field.setType(filedType);

            String ss = filedName.substring(0,1).toUpperCase() + filedName.substring(1,filedName.length());
            field.setFieldNameFirstCharUpcase(ss);

            //设置主键
            Optional<AnnotationExpr> annotationExpr = fieldDeclaration.getAnnotationByClass(Pk.class);
            if(annotationExpr.isPresent()){
                field.setIsPk(1);
                //设置主键字段
                javaModel.setPkField(field);
            }


            fields.add(field);
        }
        javaModel.setFields(fields);
        processTableinfo(javaModel);

        //设置 nonPkfields
        processNonPkfields(javaModel);
        return javaModel;
    }

    // 将 类属性，转化为 表字段
    private static void processTableinfo(JavaModel javaModel){
        //处理表名
        javaModel.setTableName(javaModel.getName());
        javaModel.setTableAlias(javaModel.getTableName().substring(0,1));


        List<JavaModel.Field> fields = javaModel.getFields();
        for(JavaModel.Field field : fields){
            field.setColumnName(SmartStringUtil.undlienNaming(field.getName()));
            field.setJdbcType(new JdbcTypeResolverImpl().calculateJdbcTypeName(field.getType()));
        }
    }

    private static void processNonPkfields(JavaModel javaModel){
        List<JavaModel.Field> fields = javaModel.getFields();
        List<JavaModel.Field> nonPkfields = new ArrayList<>();
        for(JavaModel.Field field : fields){
            if(field.getIsPk()==1){
                continue;
            }
            nonPkfields.add(field);
        }
        javaModel.setNonPkfields(nonPkfields);
    }
}
