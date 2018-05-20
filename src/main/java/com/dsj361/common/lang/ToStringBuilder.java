package com.dsj361.common.lang;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ToStringBuilder {

    /**
     *
     * @param object
     * @return
     */
    public static String reflectionToString(Object object) {
        return reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE, null, null, false);
    }

    /**
     *
     * @param object
     * @param excludeFieldNames
     * @return
     */
    public static String reflectionToString(Object object, String[] excludeFieldNames) {
        return reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE, excludeFieldNames, null, false);
    }

    /**
     *
     * @param object
     * @param excludeFieldNames
     * @return
     */
    public static String reflectionToString(Object object, String[] excludeFieldNames, String[] maskFieldNames) {
        return reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE, excludeFieldNames, maskFieldNames, false);
    }

    /**
     *
     *
     * @param object
     * @param style
     * @return
     */
    public static String reflectionToString(Object object, ToStringStyle style) {
        return reflectionToString(object, style, null, null, false);
    }

    /**
     *
     * @param object
     * @param style
     * @param excludeFieldNames
     * @return
     */
    public static String reflectionToString(Object object, ToStringStyle style, String[] excludeFieldNames) {
        return reflectionToString(object, style, excludeFieldNames, null, false);
    }

    /**
     *
     * @param object
     * @param style
     * @param excludeFieldNames
     * @return
     */
    public static String reflectionToString(Object object, ToStringStyle style, String[] excludeFieldNames, String[] maskFieldNames) {
        return reflectionToString(object, style, excludeFieldNames, maskFieldNames, false);
    }

    /**
     *
     * @param object
     * @param style
     * @param outputTransients
     * @return
     */
    public static String reflectionToString(Object object, ToStringStyle style, boolean outputTransients) {
        return reflectionToString(object, style, null, null, outputTransients);
    }

    /**
     *
     * @param object
     * @param style
     * @param excludeFieldNames
     * @param outputTransients
     * @return
     */
    public static String reflectionToString(Object object, ToStringStyle style, String[] excludeFieldNames, String[] maskFieldNames, boolean outputTransients) {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object, style);
        builder.setExcludeFieldNames(excludeFieldNames);
        builder.setAppendTransients(outputTransients);
        return builder.toString();
    }
}
