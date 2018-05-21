package com.dsj361.common.lang;

import java.util.List;

/**
 * List工具类
 * @author wangkai
 */
public class ListUtils {

    /**
     * 返回list长度
     *
     * @param list
     * @return
     */
    public static int size(List<?> list) {
        return list == null ? 0 : list.size();
    }

    /**
     * 为空
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(List<?> list) {
        return size(list) == 0;
    }

    /**
     * 非空
     *
     * @param list
     * @return
     */
    public static boolean isNotEmpty(List<?> list) {
        return size(list) > 0;
    }


}
