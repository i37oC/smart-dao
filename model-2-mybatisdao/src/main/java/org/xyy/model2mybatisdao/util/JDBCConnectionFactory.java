/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.xyy.model2mybatisdao.util;



import org.apache.commons.lang.StringUtils;
import org.xyy.model2mybatisdao.api.ConnectionFactory;
import org.xyy.model2mybatisdao.config.JDBCConnectionConfiguration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class assumes that classes are cached elsewhere for performance reasons,
 * but also to make sure that any native libraries are only loaded one time
 * (avoids the dreaded UnsatisfiedLinkError library loaded in another
 * classloader)
 * 
 * @author Jeff Butler
 */
public class JDBCConnectionFactory implements ConnectionFactory {

    private String userId;
    private String password;
    private String connectionURL;
    private String driverClass;

    /**
     * This constructor is called when there is a JDBCConnectionConfiguration
     * specified in the configuration.
     * 
     * @param config
     */
    public JDBCConnectionFactory(JDBCConnectionConfiguration config) {
        super();
        userId = config.getUserId();
        password = config.getPassword();
        connectionURL = config.getConnectionURL();
        driverClass = config.getDriverClass();
    }
    

    public Connection getConnection()
            throws SQLException {
        Driver driver = getDriver();

        Properties props = new Properties();

        if (StringUtils.isNotBlank(userId)) {
            props.setProperty("user", userId); //$NON-NLS-1$
        }

        if (StringUtils.isNotBlank(password)) {
            props.setProperty("password", password); //$NON-NLS-1$
        }


        Connection conn = driver.connect(connectionURL, props);

        if (conn == null) {
            throw new SQLException("链接数据库报错");
        }

        return conn;
    }


    private Driver getDriver() {
        Driver driver = null;


        Class<?> clazz = null;
        try {
            clazz = Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            driver = (Driver) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return driver;
    }
}
