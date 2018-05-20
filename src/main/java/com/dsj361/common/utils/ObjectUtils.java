package com.dsj361.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangkai
 * Create on 2018/3/16 17:25
 */
public class ObjectUtils {

    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    public static Map<String, Object> convertObjectToMap(Object obj) {
        Map<String, Object> result = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            // 对象里的属性，变成下划线分割的大写
            String varName = StringUtils.toUpperCaseWithUnderscores(fields[i].getName());
            boolean accessFlag = fields[i].isAccessible();
            fields[i].setAccessible(true);
            Object o = null;
            try {
                o = fields[i].get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (o != null) {
                if (o instanceof Integer && (Integer) o != 0) {
                    result.put(varName, o.toString());
                }
                if (o instanceof Long && (Long) o != 0) {
                    result.put(varName, o.toString());
                }
                if (o instanceof String) {
                    result.put(varName, o.toString());
                }
            }
            fields[i].setAccessible(accessFlag);
        }
        return result;
    }
}
