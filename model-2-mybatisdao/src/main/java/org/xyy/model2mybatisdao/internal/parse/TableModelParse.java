package org.xyy.model2mybatisdao.internal.parse;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import org.springframework.util.StringUtils;
import org.xyy.model2mybatisdao.annotations.*;
import org.xyy.model2mybatisdao.model.TableModel;
import org.xyy.model2mybatisdao.typresolve.MysqlColumnTypeResolver;
import org.xyy.model2mybatisdao.util.SmartStringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author xyy
 * @version 1.0 2017/5/29.
 * @since 1.0
 */
public class TableModelParse {
    public static TableModel parse(CompilationUnit compilationUnit){
        TableModel tableModel = new TableModel();

        //class-name
        List<Node> nodes = compilationUnit.getChildNodes();
        ClassOrInterfaceDeclaration classbody = null;
        for(Node node : nodes){
            if(node instanceof ClassOrInterfaceDeclaration){
                classbody = (ClassOrInterfaceDeclaration)node;
            }
        }
        String className = classbody.getNameAsString();
        tableModel.setName(className);

        //处理  自定义表名
        Optional<AnnotationExpr> tablename = classbody.getAnnotationByClass(TableName.class);
        if(tablename.isPresent()){
            String yy = tablename.get().getChildNodes().get(1).toString();
            tableModel.setName(yy);
        }

        //class-comment
        Optional<JavadocComment> commentOptional = classbody.getJavadocComment();
        if(commentOptional.isPresent()){
            String comment = SmartStringUtil.removeLasthauanhang(commentOptional.get().toString());
            tableModel.setComment(processComment(comment));
        }


        //设置字段
        List<TableModel.Column> columns = new ArrayList<>();
        List<Node> classNodes = classbody.getChildNodes();
        List<FieldDeclaration> filedsDeclaration = new ArrayList<>();
        for(Node node : classNodes){
            if(node instanceof FieldDeclaration){
                filedsDeclaration.add((FieldDeclaration)node);
            }
        }

        for(FieldDeclaration fieldDeclaration : filedsDeclaration){
            TableModel.Column column = new TableModel.Column();


            String columnName = "";
            String javaType = "";

            Optional<JavadocComment> filedcommentOptional = fieldDeclaration.getJavadocComment();
            if(filedcommentOptional.isPresent()){
                String comment = SmartStringUtil.removeLasthauanhang(filedcommentOptional.get().toString());
                column.setComment(processComment(comment));
            }


            List<Node> filedsnodes = fieldDeclaration.getChildNodes();
            for(Node varible : filedsnodes){
                if(varible instanceof VariableDeclarator){
                    columnName = ((VariableDeclarator) varible).getName().toString();
                    javaType = ((VariableDeclarator) varible).getType().toString();
                }
            }


            // 处理 column 名，大小写
            columnName = SmartStringUtil.undlienNaming(columnName);
            column.setName(columnName);


            //设置 MYSQL 字段数据类型
            processFieldAnnotation(fieldDeclaration, column);

            //设置主键
            Optional<AnnotationExpr> annotationExpr = fieldDeclaration.getAnnotationByClass(Pk.class);
            if(annotationExpr.isPresent()){
                column.setIsPk(1);
                //设置主键字段
                tableModel.setPrimaryColumn(column);
            }

            //根据 java type 转化成 数据库 字段类型
            String mysqlType = MysqlColumnTypeResolver.resolveType(javaType);
            //如果设置了字段长度则计算
            if(!StringUtils.isEmpty(column.getLength())){
                mysqlType = mysqlType.substring(0,mysqlType.indexOf("(")) + "("+ column.getLength() +")";
            }
            column.setType(mysqlType);

            columns.add(column);
        }
        tableModel.setColumns(columns);
        return tableModel;
    }

    private static String processComment(String comment){
        comment = comment.replaceAll("\\*","").replaceAll("\n","").replaceAll("/", "").trim();
        return "COMMENT '" + comment + "'";
    }

    private static void processFieldAnnotation(FieldDeclaration fieldDeclaration, TableModel.Column column){

        //处理主键
        Optional<AnnotationExpr> pk = fieldDeclaration.getAnnotationByClass(Pk.class);
        if(pk.isPresent()){
            column.setIsPk(1);
        }

        //处理  字段长度, 即处理
        Optional<AnnotationExpr> length = fieldDeclaration.getAnnotationByClass(Length.class);
        if(length.isPresent()){
            String yy = length.get().getChildNodes().get(1).toString();
            column.setLength(yy);
        }



        //处理  是否自增
        Optional<AnnotationExpr> autoincrement = fieldDeclaration.getAnnotationByClass(AutoIncrement.class);
        if(autoincrement.isPresent()){
            column.setExtra("AUTO_INCREMENT");
        }

        //处理  是否可以为空
        Optional<AnnotationExpr> notnull = fieldDeclaration.getAnnotationByClass(NotNull.class);
        if(notnull.isPresent()){
            column.setCanbeNull("NOT NULL");
        }

    }
}
