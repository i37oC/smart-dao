package org.xyy.model2mybatisdao.util;

/**
 * @author xyy
 * @version 1.0 2017/5/26.
 * @since 1.0
 */
public class SmartStringUtil {

    /**
     * 去掉字符串结尾的换行符
     * @param str
     * @return
     */
    public static String removeLasthauanhang(String str){
        if(str.endsWith("\n")){
            str = str.substring(0,str.length()-1);
        }
        return str;
    }

    /**
     * 将 驼峰装名称改为 带下划线的名称
     * <pre>
     *     productCatagory --> product_catagory
     * </pre>
     * @param str
     * @return
     */
    public static String undlienNaming(String str){
        //写数据库字段名
        String result = str;
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (Character.isUpperCase(c))
            {
                result = result.replace(String.valueOf(c),"_"+String.valueOf(c).toLowerCase());
            }
        }
        return result;
    }
}
