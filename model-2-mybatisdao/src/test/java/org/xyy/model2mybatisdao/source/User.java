package org.xyy.model2mybatisdao.source;
import org.xyy.model2mybatisdao.annotations.*;

import java.util.Date;

/**
 * @author xyy
 * @version 1.0 2017/5/25.
 * @since 1.0
 */
public class User {
    /**
     * 主键ID
     */
    @Pk
    @AutoIncrement
    private Long id;

    private Date createtime;

    @Datatype("tinyint(1)")
    private int isGirl;

    /**
     * 名字
     */
    @Length(200)
    @NotNull
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 住址
     */
    private String address;
}
