package org.xyy.smart.dao.example;

import org.xyy.model2mybatisdao.api.MybatisDaoGenerator;
import org.xyy.model2mybatisdao.api.TableGenerator;
import org.xyy.model2mybatisdao.model.TableModel;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author xyy
 * @version 1.0 2017/5/31.
 * @since 1.0
 */
public class Gen {
    public static void main(String[] args) throws IOException, SQLException {
        new TableGenerator().gen();
        new MybatisDaoGenerator().gen();
    }
}
