package org.xyy.model2mybatisdao.annotations;

import java.lang.annotation.*;

/**
 * 自定义字段类型 不能喝 @Length 共用
 *
 * @author xyy
 * @version 1.0 2017/5/25.
 * @since 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Datatype {
    String value();
}
