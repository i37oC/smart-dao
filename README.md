# smart-dao

![CSDN图标](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496232211631&di=6a258acd4398e75a911cf4167a1b9c78&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201501%2F20%2F20150120130324_zi5LM.thumb.700_0.png "这是CSDN的图标")

只需要定义 model 类，就可以逆向生成 表结构，  
生成 DAO 所需的类 （以User为例） 
1. User.java entity 实体类
2. UserQuery.java 查询对象
3. UserMapper.java 查询接口
4. UserMapper.xml  mybatis sql文件


### FEATURE
1、强大的 @Anatation 标记，可以自定义所有数据库字段属性  
1、支持以实体对象查询列表，强大的query  
2、支持分页  



### 使用方法 （具体参考 example 代码）
1. 下载源码
2. 在类路径下新建一个 smart-dao.properties 文件
3. 新建 source 文件 需要生成的实体文件，如下

`

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
        private Integer isGirl;
    
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
        
`
    

4. 使用以下代码

`

    new TableGenerator().gen();
    new MybatisDaoGenerator().gen();
    
`
 
 

### 下版展望
1、支持 多主键  
2、支持 动态修改表结构，在不清除原有表数据的情况下增加，修改，或者删除表字段


#感谢友情支持
![CSDN图标](http://note.youdao.com/yws/public/resource/99bf375f97ca313a4626d250d10d930b/xmlnote/F0C603FBB02949E1B4116A5530A12176/12409 "感谢支持")

