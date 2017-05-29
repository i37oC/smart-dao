package org.xyy.model2mybatisdao.api;

import org.xyy.model2mybatisdao.api.genarticles.TableSQLGenerator;
import org.xyy.model2mybatisdao.config.JDBCConnectionConfiguration;
import org.xyy.model2mybatisdao.util.JDBCConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class TableGenerator {

    private JDBCConnectionConfiguration connectionConfiguration;


    public TableGenerator(JDBCConnectionConfiguration connectionConfiguration) {
        this.connectionConfiguration = connectionConfiguration;
    }

    public void genMulti(Connection connection, String modelPackage){

    }

    public void genSingle(String modelPath) throws SQLException {

        ConnectionFactory connectionFactory = new JDBCConnectionFactory(connectionConfiguration);

        Connection conn = connectionFactory.getConnection();


        String sql = TableSQLGenerator.gen(modelPath);
        System.out.println(sql);

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.execute();
    }
}
