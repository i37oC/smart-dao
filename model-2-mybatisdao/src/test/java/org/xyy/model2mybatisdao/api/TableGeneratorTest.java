package org.xyy.model2mybatisdao.api;

import org.junit.Test;
import org.xyy.model2mybatisdao.config.JDBCConnectionConfiguration;

import static org.junit.Assert.*;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class TableGeneratorTest {


    @Test
    public void genSingle() throws Exception {
       /* JDBCConnectionConfiguration config = new JDBCConnectionConfiguration();
        config.setConnectionURL("jdbc:mysql://120.24.94.205:3306/cn-b2c?useUnicode=true&characterEncoding=utf8&useSSL=false");
        config.setUserId("root");
        config.setPassword("xyy123");
        config.setDriverClass("com.mysql.jdbc.Driver");*/

        TableGenerator tableGenerator = new TableGenerator();
        tableGenerator.gen();
    }

}