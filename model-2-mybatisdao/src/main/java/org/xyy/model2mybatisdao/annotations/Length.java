package org.xyy.model2mybatisdao.annotations;

import java.lang.annotation.*;

/**
 * 设置字段长度
 *
 * @author xyy
 * @version 1.0 2017/5/25.
 * @since 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Length {
    int value();
}
