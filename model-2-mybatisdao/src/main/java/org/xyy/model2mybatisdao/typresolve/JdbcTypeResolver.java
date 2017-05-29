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
package org.xyy.model2mybatisdao.typresolve;


/**
 *
 */
public interface JdbcTypeResolver {

    /**
     * 返回 column 对应的 JDBCtype 类型
     * @param javatype java 类型
     * @return
     */
    String calculateJdbcTypeName(String javatype);
}
