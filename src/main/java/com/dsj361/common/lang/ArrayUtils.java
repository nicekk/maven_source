package com.dsj361.common.lang;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkai
 * @date 2018/7/5 21:08
 */
public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {

    /*
     * =========================================================================
     * = ==
     */
    /* Clone函数。 */
    /*                                                                              */
    /* 以下方法调用Object.clone方法，进行“浅复制”（shallow copy）。 */
    /*
     * =========================================================================
     * = ==
     */

    /**
     * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
     *
     * <p>
     * 此方法只进行“浅复制”，也就是说，数组中的对象本身不会被复制。 另外，此方法也不处理多维数组。
     * </p>
     *
     * @param array
     *            要复制的数组
     *
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static Object[] clone(Object[] array) {
        if (array == null) {
            return null;
        }

        return (Object[]) array.clone();
    }

    /**
     * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
     *
     * <p>
     * 此方法也不处理多维数组。
     * </p>
     *
     * @param array
     *            要复制的数组
     *
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static long[] clone(long[] array) {
        if (array == null) {
            return null;
        }

        return (long[]) array.clone();
    }

    /**
     * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
     *
     * <p>
     * 此方法也不处理多维数组。
     * </p>
     *
     * @param array
     *            要复制的数组
     *
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static short[] clone(short[] array) {
        if (array == null) {
            return null;
        }

        return (short[]) array.clone();
    }

    /**
     * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
     *
     * <p>
     * 此方法也不处理多维数组。
     * </p>
     *
     * @param array
     *            要复制的数组
     *
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static double[] clone(double[] array) {
        if (array == null) {
            return null;
        }

        return (double[]) array.clone();
    }

    /**
     * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
     *
     * <p>
     * 此方法也不处理多维数组。
     * </p>
     *
     * @param array
     *            要复制的数组
     *
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static float[] clone(float[] array) {
        if (array == null) {
            return null;
        }

        return (float[]) array.clone();
    }

    /**
     * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
     *
     * <p>
     * 此方法也不处理多维数组。
     * </p>
     *
     * @param array
     *            要复制的数组
     *
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static boolean[] clone(boolean[] array) {
        if (array == null) {
            return null;
        }

        return (boolean[]) array.clone();
    }

    /**
     * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
     *
     * <p>
     * 此方法也不处理多维数组。
     * </p>
     *
     * @param array
     *            要复制的数组
     *
     * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
     */
    public static char[] clone(char[] array) {
        if (array == null) {
            return null;
        }

        return (char[]) array.clone();
    }

    /**
     * 将数组转换成<code>List</code>。
     *
     * <p>
     * 如果输入数组为<code>null</code>，则返回<code>null</code>。
     * </p>
     *
     * <p>
     * 该方法返回的列表为指定数组的复本，而<code>java.util.Arrays.asList</code>
     * 方法所返回的列表为指定数组的映像（固定长度）。
     * </p>
     *
     * <p>
     * 这个方法常被用于初始化，例如：
     *
     * <pre>
     * List myList = ArrayUtil.toList(new String[] { &quot;aaa&quot;, &quot;bbb&quot;, &quot;ccc&quot; });
     * List singleList = ArrayUtil.toList(&quot;hello&quot;); // 返回单个元素的列表[&quot;hello&quot;]
     * </pre>
     *
     * </p>
     *
     * @param array
     *            要转换的数组
     *
     * @return 被创建的list
     */
    public static List toList(Object array) {
        return toList(array, null);
    }

    /**
     * 将数组转换成<code>List</code>。
     *
     * <p>
     * 如果输入数组为<code>null</code>，则返回<code>null</code>。
     * </p>
     *
     * <p>
     * 该方法返回的列表为指定数组的复本，而<code>java.util.Arrays.asList</code>
     * 方法所返回的列表为指定数组的映像（固定长度）。
     * </p>
     *
     * <p>
     * 这个方法常被用于初始化，例如：
     *
     * <pre>
     * List myList = ArrayUtil.toList(new String[] { &quot;aaa&quot;, &quot;bbb&quot;, &quot;ccc&quot; }, new ArrayList());
     * List singleList = ArrayUtil.toList(&quot;hello&quot;, new ArrayList()); // 返回单个元素的列表[&quot;hello&quot;]
     * </pre>
     *
     * </p>
     *
     * @param array
     *            要转换的数组
     * @param list
     *            要填充的列表，如果是<code>null</code>，则创建之
     *
     * @return 被创建或填充的list
     */
    public static List toList(Object array, List list) {
        if (array == null) {
            return list;
        }

        // 非array，创建一个只有一个元素的列表
        if (!array.getClass().isArray()) {
            if (list == null) {
                list = new ArrayList(1);
            }

            list.add(array);
        } else if (array instanceof long[]) {
            long[] longArray = (long[]) array;

            if (list == null) {
                list = new ArrayList(longArray.length);
            }

            for (int i = 0; i < longArray.length; i++) {
                list.add(new Long(longArray[i]));
            }
        } else if (array instanceof int[]) {
            int[] intArray = (int[]) array;

            if (list == null) {
                list = new ArrayList(intArray.length);
            }

            for (int i = 0; i < intArray.length; i++) {
                list.add(new Integer(intArray[i]));
            }
        } else if (array instanceof short[]) {
            short[] shortArray = (short[]) array;

            if (list == null) {
                list = new ArrayList(shortArray.length);
            }

            for (int i = 0; i < shortArray.length; i++) {
                list.add(new Short(shortArray[i]));
            }
        } else if (array instanceof byte[]) {
            byte[] byteArray = (byte[]) array;

            if (list == null) {
                list = new ArrayList(byteArray.length);
            }

            for (int i = 0; i < byteArray.length; i++) {
                list.add(new Byte(byteArray[i]));
            }
        } else if (array instanceof double[]) {
            double[] doubleArray = (double[]) array;

            if (list == null) {
                list = new ArrayList(doubleArray.length);
            }

            for (int i = 0; i < doubleArray.length; i++) {
                list.add(new Double(doubleArray[i]));
            }
        } else if (array instanceof float[]) {
            float[] floatArray = (float[]) array;

            if (list == null) {
                list = new ArrayList(floatArray.length);
            }

            for (int i = 0; i < floatArray.length; i++) {
                list.add(new Float(floatArray[i]));
            }
        } else if (array instanceof boolean[]) {
            boolean[] booleanArray = (boolean[]) array;

            if (list == null) {
                list = new ArrayList(booleanArray.length);
            }

            for (int i = 0; i < booleanArray.length; i++) {
                list.add(booleanArray[i] ? Boolean.TRUE : Boolean.FALSE);
            }
        } else if (array instanceof char[]) {
            char[] charArray = (char[]) array;

            if (list == null) {
                list = new ArrayList(charArray.length);
            }

            for (int i = 0; i < charArray.length; i++) {
                list.add(new Character(charArray[i]));
            }
        } else {
            Object[] objectArray = (Object[]) array;

            if (list == null) {
                list = new ArrayList(objectArray.length);
            }

            for (int i = 0; i < objectArray.length; i++) {
                list.add(objectArray[i]);
            }
        }

        return list;
    }

    /*
     * =========================================================================
     * = ==
     */
    /* 将数组转换成易于阅读的字符串表示。 */
    /*                                                                              */
    /* 支持多维数组。 */
    /*
     * =========================================================================
     * = ==
     */

    /**
     * 将数组转换成易于阅读的字符串表示。
     *
     * <p>
     * 如果数组是<code>null</code>则返回<code>[]</code>，支持多维数组。 如果数组元素为<code>null</code>
     * ，则显示<code>&lt;null&gt;</code>。
     *
     * <pre>
     * ArrayUtil.toString(null)                              = &quot;[]&quot;
     * ArrayUtil.toString(new int[] {1, 2, 3})               = &quot;[1, 2, 3]&quot;
     * ArrayUtil.toString(new boolean[] {true, false, true}) = &quot;[true, false, true]&quot;
     * ArrayUtil.toString(new Object[] {
     *                       {1, 2, 3},  // 嵌套数组
     *                       hello,      // 嵌套非数组
     *                       null,       // 嵌套null
     *                       {},         // 嵌套空数组
     *                       {2, 3, 4}   // 嵌套数组
     *                    })                                 = &quot;[[1, 2, 3], hello, &lt;null&gt;, [], [2, 3, 4]]&quot;
     * </pre>
     *
     * </p>
     *
     * @param array
     *            要转换的数组
     *
     * @return 字符串表示，<code>"[]"</code>表示空数组或<code>null</code>
     */
    public static String toString(Object array) {
        return toString(array, "[]", "<null>");
    }

    /**
     * 将数组转换成易于阅读的字符串表示。
     *
     * <p>
     * 如果数组是<code>null</code>则返回指定字符串，支持多维数组。 如果数组元素为<code>null</code>，则显示
     * <code>&lt;null&gt;</code>。
     *
     * <pre>
     * ArrayUtil.toString(null, &quot;null&quot;)                              = &quot;null&quot;
     * ArrayUtil.toString(new int[] {1, 2, 3}, &quot;null&quot;)               = &quot;[1, 2, 3]&quot;
     * ArrayUtil.toString(new boolean[] {true, false, true}, &quot;null&quot;) = &quot;[true, false, true]&quot;
     * ArrayUtil.toString(new Object[] {
     *                       {1, 2, 3},  // 嵌套数组
     *                       hello,      // 嵌套非数组
     *                       null,       // 嵌套null
     *                       {},         // 嵌套空数组
     *                       {2, 3, 4}   // 嵌套数组
     *                    }, &quot;null&quot;)                                 = &quot;[[1, 2, 3], hello, &lt;null&gt;, [], [2, 3, 4]]&quot;
     * </pre>
     *
     * </p>
     *
     * @param array
     *            要转换的数组
     * @param nullArrayStr
     *            如果数组是<code>null</code>，则返回此字符串
     *
     * @return 字符串表示，或返回指定字符串表示<code>null</code>
     */
    public static String toString(Object array, String nullArrayStr) {
        return toString(array, nullArrayStr, "<null>");
    }

    /**
     * 将数组转换成易于阅读的字符串表示。
     *
     * <p>
     * 如果数组是<code>null</code>则返回指定字符串，支持多维数组。 如果数组元素为<code>null</code>，则显示指定字符串。
     *
     * <pre>
     * ArrayUtil.toString(null, &quot;null&quot;, &quot;NULL&quot;)                              = &quot;null&quot;
     * ArrayUtil.toString(new int[] {1, 2, 3}, &quot;null&quot;, &quot;NULL&quot;)               = &quot;[1, 2, 3]&quot;
     * ArrayUtil.toString(new boolean[] {true, false, true}, &quot;null&quot;, &quot;NULL&quot;) = &quot;[true, false, true]&quot;
     * ArrayUtil.toString(new Object[] {
     *                       {1, 2, 3},  // 嵌套数组
     *                       hello,      // 嵌套非数组
     *                       null,       // 嵌套null
     *                       {},         // 嵌套空数组
     *                       {2, 3, 4}   // 嵌套数组
     *                    }, &quot;null&quot;, &quot;NULL&quot;)                                 = &quot;[[1, 2, 3], hello, NULL, [], [2, 3, 4]]&quot;
     * </pre>
     *
     * </p>
     *
     * @param array
     *            要转换的数组
     * @param nullArrayStr
     *            如果数组是<code>null</code>，则返回此字符串
     * @param nullElementStr
     *            如果数组中的元素为<code>null</code>，则返回此字符串
     *
     * @return 字符串表示，或返回指定字符串表示<code>null</code>
     */
    public static String toString(Object array, String nullArrayStr, String nullElementStr) {
        if (array == null) {
            return nullArrayStr;
        }

        StringBuffer buffer = new StringBuffer();

        toString(buffer, array, nullArrayStr, nullElementStr);

        return buffer.toString();
    }

    /**
     * 将数组转换成易于阅读的字符串表示。<code>null</code>将被看作空数组。 支持多维数组。
     *
     * @param buffer
     *            将转换后的字符串加入到这个<code>StringBuffer</code>中
     * @param array
     *            要转换的数组
     * @param nullArrayStr
     *            如果数组是<code>null</code>，则返回此字符串
     * @param nullElementStr
     *            如果数组中的元素为<code>null</code>，则返回此字符串
     */
    private static void toString(StringBuffer buffer, Object array, String nullArrayStr, String nullElementStr) {
        if (array == null) {
            buffer.append(nullElementStr);
            return;
        }

        if (!array.getClass().isArray()) {
            buffer.append(ObjectUtils.toString(array, nullElementStr));
            return;
        }

        buffer.append('[');

        // array为数组
        if (array instanceof long[]) {
            long[] longArray = (long[]) array;
            int length = longArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                buffer.append(longArray[i]);
            }
        } else if (array instanceof int[]) {
            int[] intArray = (int[]) array;
            int length = intArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                buffer.append(intArray[i]);
            }
        } else if (array instanceof short[]) {
            short[] shortArray = (short[]) array;
            int length = shortArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                buffer.append(shortArray[i]);
            }
        } else if (array instanceof byte[]) {
            byte[] byteArray = (byte[]) array;
            int length = byteArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                } else {
                    buffer.append("0x");
                }

                String hexStr = Integer.toHexString(0xFF & byteArray[i]).toUpperCase();

                if (hexStr.length() == 0) {
                    buffer.append("00");
                } else if (hexStr.length() == 1) {
                    buffer.append("0");
                }

                buffer.append(hexStr);
            }
        } else if (array instanceof double[]) {
            double[] doubleArray = (double[]) array;
            int length = doubleArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                buffer.append(doubleArray[i]);
            }
        } else if (array instanceof float[]) {
            float[] floatArray = (float[]) array;
            int length = floatArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                buffer.append(floatArray[i]);
            }
        } else if (array instanceof boolean[]) {
            boolean[] booleanArray = (boolean[]) array;
            int length = booleanArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                buffer.append(booleanArray[i]);
            }
        } else if (array instanceof char[]) {
            char[] charArray = (char[]) array;
            int length = charArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                buffer.append(charArray[i]);
            }
        } else {
            Object[] objectArray = (Object[]) array;
            int length = objectArray.length;

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }

                toString(buffer, objectArray[i], nullArrayStr, nullElementStr);
            }
        }

        buffer.append(']');
    }

    /**
     * 对int类型数组求和
     *
     * @param source
     * @return
     */
    public static long sum(long[] source) {
        if (source == null || source.length == 0) {
            return 0;
        }
        long sum = 0;
        for (long i : source) {
            sum += i;
        }
        return sum;
    }

    /**
     * 对double类型的数组求和
     *
     * @param source
     * @return
     */
    public static double sum(double[] source) {
        if (source == null || source.length == 0) {
            return 0;
        }
        double sum = 0;
        for (double i : source) {
            sum += i;
        }
        return sum;
    }


    public static void main(String[] args) {
        long[] a = new long[]{};
        System.out.println(ArrayUtils.sum(a));
    }
}
