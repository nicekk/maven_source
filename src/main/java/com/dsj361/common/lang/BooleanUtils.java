package com.dsj361.common.lang;

/**
 * 布尔值工具类
 *
 * @author wangkai
 * @date 2018/10/6 16:57
 */
public class BooleanUtils extends org.apache.commons.lang.BooleanUtils {

    public static final BooleanUtils INSTANCE = new BooleanUtils();

    public BooleanUtils() {
    }

    public static boolean toBoolean(String value) {
        return toBoolean(value, false);
    }

    public static boolean toBoolean(Object value) {
        if (value == null) {
            return false;
        } else if (value instanceof Boolean) {
            return (Boolean) value;
        } else if (value instanceof Number) {
            return ((Number) value).doubleValue() > 0.0D;
        } else {
            return value instanceof String ? toBoolean((String) value, false) : toBoolean(ObjectUtils.toString(value), false);
        }
    }

    public static boolean toBoolean(String value, boolean defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        } else if (StringUtils.equalsIgnoreCase(value, "t")) {
            return true;
        } else {
            return StringUtils.equalsIgnoreCase(value, "1") ? true : org.apache.commons.lang.BooleanUtils.toBoolean(value);
        }
    }
}
