package org.xyy.model2mybatisdao.annotations;

import java.lang.annotation.*;

/**
 * 主键自增
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoIncrement {
}
