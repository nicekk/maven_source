package com.dsj361.common.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkai
 * Create on 2018/3/16 18:25
 */
public class StringUtils {

    /** 空字符串。 */
    public static final String EMPTY_STRING = "";

    public static final String COMMA_SIGN = ",";

    public static final String COLON_SIGN = ":";

    /**
     * 将字符串转换成大写。
     *
     * <p>
     * 如果字符串是<code>null</code>则返回<code>null</code>。
     *
     * <pre>
     * StringUtil.toUpperCase(null)  = null
     * StringUtil.toUpperCase(&quot;&quot;)    = &quot;&quot;
     * StringUtil.toUpperCase(&quot;aBc&quot;) = &quot;ABC&quot;
     * </pre>
     *
     * </p>
     *
     * @param str
     *            要转换的字符串
     *
     * @return 大写字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String toUpperCase(String str) {
        return toUpperCase(str, -1);
    }

    /**
     * 前index个字母变成大写
     *
     * @param str
     * @param index
     * @return
     */
    public static String toUpperCase(String str, int index) {
        if (str == null) {
            return null;
        }
        if (index < 0 || str.length() <= index) {
            return str.toUpperCase();
        }

        return str.substring(0, index + 1).toUpperCase() + str.substring(index + 1);

    }

    /**
     * 前index个字母变成小写
     *
     * @param str
     * @param index
     * @return
     */
    public static String toLowerCase(String str, int index) {
        if (str == null) {
            return null;
        }
        if (index < 0 || str.length() <= index) {
            return str.toLowerCase();
        }

        return str.substring(0, index + 1).toLowerCase() + str.substring(index + 1);

    }

    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toLowerCase();
    }

    /**
     * 首字母大写
     * @param string
     * @return
     */
    public static String firstLetterUpperCase(String string) {
        char[] ch = string.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /*
     * =========================================================================
     * = ==
     */
    /* 去空白（或指定字符）的函数。 */
    /*                                                                              */
    /* 以下方法用来除去一个字串中的空白或指定字符。 */
    /*
     * =========================================================================
     * = ==
     */

    /**
     * 除去字符串头尾部的空白，如果字符串是<code>null</code>，依然返回<code>null</code>。
     *
     * <p>
     * 注意，和<code>String.trim</code>不同，此方法使用<code>Character.isWhitespace</code>
     * 来判定空白， 因而可以除去英文字符集之外的其它空白，如中文空格。
     *
     * <pre>
     * StringUtil.trim(null)          = null
     * StringUtil.trim(&quot;&quot;)            = &quot;&quot;
     * StringUtil.trim(&quot;     &quot;)       = &quot;&quot;
     * StringUtil.trim(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtil.trim(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
     *
     * </p>
     *
     * @param str
     *            要处理的字符串
     *
     * @return 除去空白的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
     */
    public static String trim(String str) {
        return trim(str, null, 0);
    }

    /**
     * 除去字符串头尾部的指定字符，如果字符串是<code>null</code>，依然返回<code>null</code>。
     *
     * <pre>
     * StringUtil.trim(null, *)          = null
     * StringUtil.trim(&quot;&quot;, *)            = &quot;&quot;
     * StringUtil.trim(&quot;abc&quot;, null)      = &quot;abc&quot;
     * StringUtil.trim(&quot;  abc&quot;, null)    = &quot;abc&quot;
     * StringUtil.trim(&quot;abc  &quot;, null)    = &quot;abc&quot;
     * StringUtil.trim(&quot; abc &quot;, null)    = &quot;abc&quot;
     * StringUtil.trim(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
     * </pre>
     *
     * @param str
     *            要处理的字符串
     * @param stripChars
     *            要除去的字符，如果为<code>null</code>表示除去空白字符
     * @param mode
     *            <code>-1</code>表示trimStart，<code>0</code>表示trim全部，
     *            <code>1</code>表示trimEnd
     *
     * @return 除去指定字符后的的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
     */
    private static String trim(String str, String stripChars, int mode) {
        if (str == null) {
            return null;
        }

        int length = str.length();
        int start = 0;
        int end = length;

        // 扫描字符串头部
        if (mode <= 0) {
            if (stripChars == null) {
                while ((start < end) && (str.charAt(start) == (char) 160 || Character.isWhitespace(str.charAt(start)))) {
                    start++;
                }
            } else if (stripChars.length() == 0) {
                return str;
            } else {
                while ((start < end) && (stripChars.indexOf(str.charAt(start)) != -1)) {
                    start++;
                }
            }
        }

        // 扫描字符串尾部
        if (mode >= 0) {
            if (stripChars == null) {
                while ((start < end) && (Character.isWhitespace(str.charAt(end - 1)))) {
                    end--;
                }
            } else if (stripChars.length() == 0) {
                return str;
            } else {
                while ((start < end) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
                    end--;
                }
            }
        }

        if ((start > 0) || (end < length)) {
            return str.substring(start, end);
        }

        return str;
    }

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 解析出下列语法所构成的<code>SENTENCE</code>。
     *
     * <pre>
     *  SENTENCE = WORD (DELIMITER* WORD)*
     *
     *  WORD = UPPER_CASE_WORD | LOWER_CASE_WORD | TITLE_CASE_WORD | DIGIT_WORD
     *
     *  UPPER_CASE_WORD = UPPER_CASE_LETTER+
     *  LOWER_CASE_WORD = LOWER_CASE_LETTER+
     *  TITLE_CASE_WORD = UPPER_CASE_LETTER LOWER_CASE_LETTER+
     *  DIGIT_WORD      = DIGIT+
     *
     *  UPPER_CASE_LETTER = Character.isUpperCase()
     *  LOWER_CASE_LETTER = Character.isLowerCase()
     *  DIGIT             = Character.isDigit()
     *  NON_LETTER_DIGIT  = !Character.isUpperCase() &amp;&amp; !Character.isLowerCase() &amp;&amp; !Character.isDigit()
     *
     *  DELIMITER = WHITESPACE | NON_LETTER_DIGIT
     * </pre>
     */
    private abstract static class WordTokenizer {
        protected static final char UNDERSCORE = '_';

        /**
         * Parse sentence。
         */
        public String parse(String str) {
            if (isEmpty(str)) {
                return str;
            }

            int length = str.length();
            StringBuffer buffer = new StringBuffer(length);

            for (int index = 0; index < length; index++) {
                char ch = str.charAt(index);

                // 忽略空白。
                if (Character.isWhitespace(ch)) {
                    continue;
                }

                // 大写字母开始：UpperCaseWord或是TitleCaseWord。
                if (Character.isUpperCase(ch)) {
                    int wordIndex = index + 1;

                    while (wordIndex < length) {
                        char wordChar = str.charAt(wordIndex);

                        if (Character.isUpperCase(wordChar)) {
                            wordIndex++;
                        } else if (Character.isLowerCase(wordChar)) {
                            wordIndex--;
                            break;
                        } else {
                            break;
                        }
                    }

                    // 1. wordIndex == length，说明最后一个字母为大写，以upperCaseWord处理之。
                    // 2. wordIndex == index，说明index处为一个titleCaseWord。
                    // 3. wordIndex > index，说明index到wordIndex -
                    // 1处全部是大写，以upperCaseWord处理。
                    if ((wordIndex == length) || (wordIndex > index)) {
                        index = parseUpperCaseWord(buffer, str, index, wordIndex);
                    } else {
                        index = parseTitleCaseWord(buffer, str, index);
                    }

                    continue;
                }

                // 小写字母开始：LowerCaseWord。
                if (Character.isLowerCase(ch)) {
                    index = parseLowerCaseWord(buffer, str, index);
                    continue;
                }

                // 数字开始：DigitWord。
                if (Character.isDigit(ch)) {
                    index = parseDigitWord(buffer, str, index);
                    continue;
                }

                // 非字母数字开始：Delimiter。
                inDelimiter(buffer, ch);
            }

            return buffer.toString();
        }

        private int parseUpperCaseWord(StringBuffer buffer, String str, int index, int length) {
            char ch = str.charAt(index++);

            // 首字母，必然存在且为大写。
            if (buffer.length() == 0) {
                startSentence(buffer, ch);
            } else {
                startWord(buffer, ch);
            }

            // 后续字母，必为小写。
            for (; index < length; index++) {
                ch = str.charAt(index);
                inWord(buffer, ch);
            }

            return index - 1;
        }

        private int parseLowerCaseWord(StringBuffer buffer, String str, int index) {
            char ch = str.charAt(index++);

            // 首字母，必然存在且为小写。
            if (buffer.length() == 0) {
                startSentence(buffer, ch);
            } else {
                startWord(buffer, ch);
            }

            // 后续字母，必为小写。
            int length = str.length();

            for (; index < length; index++) {
                ch = str.charAt(index);

                if (Character.isLowerCase(ch)) {
                    inWord(buffer, ch);
                } else {
                    break;
                }
            }

            return index - 1;
        }

        private int parseTitleCaseWord(StringBuffer buffer, String str, int index) {
            char ch = str.charAt(index++);

            // 首字母，必然存在且为大写。
            if (buffer.length() == 0) {
                startSentence(buffer, ch);
            } else {
                startWord(buffer, ch);
            }

            // 后续字母，必为小写。
            int length = str.length();

            for (; index < length; index++) {
                ch = str.charAt(index);

                if (Character.isLowerCase(ch)) {
                    inWord(buffer, ch);
                } else {
                    break;
                }
            }

            return index - 1;
        }

        private int parseDigitWord(StringBuffer buffer, String str, int index) {
            char ch = str.charAt(index++);

            // 首字符，必然存在且为数字。
            if (buffer.length() == 0) {
                startDigitSentence(buffer, ch);
            } else {
                startDigitWord(buffer, ch);
            }

            // 后续字符，必为数字。
            int length = str.length();

            for (; index < length; index++) {
                ch = str.charAt(index);

                if (Character.isDigit(ch)) {
                    inDigitWord(buffer, ch);
                } else {
                    break;
                }
            }

            return index - 1;
        }

        protected boolean isDelimiter(char ch) {
            return !Character.isUpperCase(ch) && !Character.isLowerCase(ch) && !Character.isDigit(ch);
        }

        protected abstract void startSentence(StringBuffer buffer, char ch);

        protected abstract void startWord(StringBuffer buffer, char ch);

        protected abstract void inWord(StringBuffer buffer, char ch);

        protected abstract void startDigitSentence(StringBuffer buffer, char ch);

        protected abstract void startDigitWord(StringBuffer buffer, char ch);

        protected abstract void inDigitWord(StringBuffer buffer, char ch);

        protected abstract void inDelimiter(StringBuffer buffer, char ch);
    }

    private static final WordTokenizer UPPER_CASE_WITH_UNDERSCORES_TOKENIZER = new WordTokenizer() {
        protected void startSentence(StringBuffer buffer, char ch) {
            buffer.append(Character.toUpperCase(ch));
        }

        protected void startWord(StringBuffer buffer, char ch) {
            if (!isDelimiter(buffer.charAt(buffer.length() - 1))) {
                buffer.append(UNDERSCORE);
            }

            buffer.append(Character.toUpperCase(ch));
        }

        protected void inWord(StringBuffer buffer, char ch) {
            buffer.append(Character.toUpperCase(ch));
        }

        protected void startDigitSentence(StringBuffer buffer, char ch) {
            buffer.append(ch);
        }

        protected void startDigitWord(StringBuffer buffer, char ch) {
            if (!isDelimiter(buffer.charAt(buffer.length() - 1))) {
                buffer.append(UNDERSCORE);
            }

            buffer.append(ch);
        }

        protected void inDigitWord(StringBuffer buffer, char ch) {
            buffer.append(ch);
        }

        protected void inDelimiter(StringBuffer buffer, char ch) {
            buffer.append(ch);
        }
    };

    /**
     * 将字符串转换成下划线分隔的大写字符串。
     *
     * <p>
     * 如果字符串是<code>null</code>则返回<code>null</code>。
     *
     * <pre>
     * StringUtil.toUpperCaseWithUnderscores(null)  = null
     * StringUtil.toUpperCaseWithUnderscores(&quot;&quot;)    = &quot;&quot;
     * StringUtil.toUpperCaseWithUnderscores(&quot;aBc&quot;) = &quot;A_BC&quot;
     * StringUtil.toUpperCaseWithUnderscores(&quot;aBc def&quot;) = &quot;A_BC_DEF&quot;
     * StringUtil.toUpperCaseWithUnderscores(&quot;aBc def_ghi&quot;) = &quot;A_BC_DEF_GHI&quot;
     * StringUtil.toUpperCaseWithUnderscores(&quot;aBc def_ghi 123&quot;) = &quot;A_BC_DEF_GHI_123&quot;
     * StringUtil.toUpperCaseWithUnderscores(&quot;__a__Bc__&quot;) = &quot;__A__BC__&quot;
     * </pre>
     *
     * </p>
     *
     * <p>
     * 此方法会保留除了空白以外的所有分隔符。
     * </p>
     *
     * @param str
     *            要转换的字符串
     *
     * @return 下划线分隔的大写字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String toUpperCaseWithUnderscores(String str) {
        return UPPER_CASE_WITH_UNDERSCORES_TOKENIZER.parse(str);
    }

    private static final WordTokenizer PASCAL_CASE_TOKENIZER = new WordTokenizer() {
        protected void startSentence(StringBuffer buffer, char ch) {
            buffer.append(Character.toUpperCase(ch));
        }

        protected void startWord(StringBuffer buffer, char ch) {
            buffer.append(Character.toUpperCase(ch));
        }

        protected void inWord(StringBuffer buffer, char ch) {
            buffer.append(Character.toLowerCase(ch));
        }

        protected void startDigitSentence(StringBuffer buffer, char ch) {
            buffer.append(ch);
        }

        protected void startDigitWord(StringBuffer buffer, char ch) {
            buffer.append(ch);
        }

        protected void inDigitWord(StringBuffer buffer, char ch) {
            buffer.append(ch);
        }

        protected void inDelimiter(StringBuffer buffer, char ch) {
            if (ch != UNDERSCORE) {
                buffer.append(ch);
            }
        }
    };

    public static String toPascalCase(String str) {
        return PASCAL_CASE_TOKENIZER.parse(str);
    }

    /**
     * 将字符串按指定字符分割。
     *
     * <p>
     * 分隔符不会出现在目标数组中，连续的分隔符就被看作一个。如果字符串为<code>null</code>，则返回<code>null</code>。
     *
     * <pre>
     * StringUtil.split(null, *)                = null
     * StringUtil.split(&quot;&quot;, *)                  = []
     * StringUtil.split(&quot;abc def&quot;, null)        = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtil.split(&quot;abc def&quot;, &quot; &quot;)         = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtil.split(&quot;abc  def&quot;, &quot; &quot;)        = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtil.split(&quot; ab:  cd::ef  &quot;, &quot;:&quot;)  = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtil.split(&quot;abc.def&quot;, &quot;&quot;)          = [&quot;abc.def&quot;]
     * </pre>
     *
     * </p>
     *
     * @param str
     *            要分割的字符串
     * @param separatorChars
     *            分隔符
     *
     * @return 分割后的字符串数组，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String[] split(String str, String separatorChars) {
        return split(str, separatorChars, -1);
    }

    /**
     * 将字符串按指定字符分割。
     *
     * <p>
     * 分隔符不会出现在目标数组中，连续的分隔符就被看作一个。如果字符串为<code>null</code>，则返回<code>null</code>。
     *
     * <pre>
     * StringUtil.split(null, *, *)                 = null
     * StringUtil.split(&quot;&quot;, *, *)                   = []
     * StringUtil.split(&quot;ab cd ef&quot;, null, 0)        = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtil.split(&quot;  ab   cd ef  &quot;, null, 0)  = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtil.split(&quot;ab:cd::ef&quot;, &quot;:&quot;, 0)        = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtil.split(&quot;ab:cd:ef&quot;, &quot;:&quot;, 2)         = [&quot;ab&quot;, &quot;cdef&quot;]
     * StringUtil.split(&quot;abc.def&quot;, &quot;&quot;, 2)           = [&quot;abc.def&quot;]
     * </pre>
     *
     * </p>
     *
     * @param str
     *            要分割的字符串
     * @param separatorChars
     *            分隔符
     * @param max
     *            返回的数组的最大个数，如果小于等于0，则表示无限制
     *
     * @return 分割后的字符串数组，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String[] split(String str, String separatorChars, int max) {
        if (str == null) {
            return null;
        }

        int length = str.length();

        if (length == 0) {
            return new String[0];
        }

        List<String> list = new ArrayList<String>();
        int sizePlus1 = 1;
        int i = 0;
        int start = 0;
        boolean match = false;

        if (separatorChars == null) {
            // null表示使用空白作为分隔符
            while (i < length) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = length;
                        }

                        list.add(str.substring(start, i));
                        match = false;
                    }

                    start = ++i;
                    continue;
                }

                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // 优化分隔符长度为1的情形
            char sep = separatorChars.charAt(0);

            while (i < length) {
                if (str.charAt(i) == sep) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = length;
                        }

                        list.add(str.substring(start, i));
                        match = false;
                    }

                    start = ++i;
                    continue;
                }

                match = true;
                i++;
            }
        } else {
            // 一般情形
            while (i < length) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = length;
                        }

                        list.add(str.substring(start, i));
                        match = false;
                    }

                    start = ++i;
                    continue;
                }

                match = true;
                i++;
            }
        }

        if (match) {
            list.add(str.substring(start, i));
        }

        return (String[]) list.toArray(new String[list.size()]);
    }

    public static String trimToNull(String str) {
        return trimToNull(str, null);
    }


    public static String trimToNull(String str, String stripChars) {
        String result = trim(str, stripChars);

        if ((result == null) || (result.length() == 0)) {
            return null;
        }

        return result;
    }


    public static String trim(String str, String stripChars) {
        return trim(str, stripChars, 0);
    }

    public static String filterHtml(String str) {
        return StringUtils.defaultIfEmpty(str).replaceAll("<[.[^<]]*>", "");
    }

    public static String defaultIfEmpty(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    public static boolean notEquals(String str1, String str2) {
        return !equals(str1, str2);
    }

    /**
     * 比较两个字符串（大小写敏感）。
     *
     * <pre>
     * StringUtil.equals(null, null)   = true
     * StringUtil.equals(null, &quot;abc&quot;)  = false
     * StringUtil.equals(&quot;abc&quot;, null)  = false
     * StringUtil.equals(&quot;abc&quot;, &quot;abc&quot;) = true
     * StringUtil.equals(&quot;abc&quot;, &quot;ABC&quot;) = false
     * </pre>
     *
     * @param str1
     *            要比较的字符串1
     * @param str2
     *            要比较的字符串2
     *
     * @return 如果两个字符串相同，或者都是<code>null</code>，则返回<code>true</code>
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equals(str2);
    }

    /**
     * 检查字符串中是否包含指定的字符串。如果字符串为<code>null</code>，将返回<code>false</code>。
     *
     * <pre>
     * StringUtil.contains(null, *)     = false
     * StringUtil.contains(*, null)     = false
     * StringUtil.contains(&quot;&quot;, &quot;&quot;)      = true
     * StringUtil.contains(&quot;abc&quot;, &quot;&quot;)   = true
     * StringUtil.contains(&quot;abc&quot;, &quot;a&quot;)  = true
     * StringUtil.contains(&quot;abc&quot;, &quot;z&quot;)  = false
     * </pre>
     *
     * @param str
     *            要扫描的字符串
     * @param searchStr
     *            要查找的字符串
     *
     * @return 如果找到，则返回<code>true</code>
     */
    public static boolean contains(String str, String searchStr) {
        if ((str == null) || (searchStr == null)) {
            return false;
        }

        return str.indexOf(searchStr) >= 0;
    }

    /**
     * 比较两个字符串（大小写不敏感）。
     *
     * <pre>
     * StringUtil.equalsIgnoreCase(null, null)   = true
     * StringUtil.equalsIgnoreCase(null, &quot;abc&quot;)  = false
     * StringUtil.equalsIgnoreCase(&quot;abc&quot;, null)  = false
     * StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;abc&quot;) = true
     * StringUtil.equalsIgnoreCase(&quot;abc&quot;, &quot;ABC&quot;) = true
     * </pre>
     *
     * @param str1
     *            要比较的字符串1
     * @param str2
     *            要比较的字符串2
     *
     * @return 如果两个字符串相同，或者都是<code>null</code>，则返回<code>true</code>
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equalsIgnoreCase(str2);
    }

    public static boolean notEqualsIgnoreCase(String str1, String str2) {
        return !equalsIgnoreCase(str1, str2);
    }

    /**
     * 移除字符串中的数字
     *
     * @param str
     * @return
     */
    public static String removeNumbers(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.replaceAll("\\d+", "");
    }


    public static final String FILL_TYPE_PREFIX = "prefix";

    public static final String FILL_TYPE_SUFFIX = "suffix";


    private static String fill(String value, String filler, String fillType, int length) {
        StringBuffer buf = new StringBuffer(StringUtils.defaultIfEmpty(value));
        while (buf.length() < length) {
            if (fillType.equals(FILL_TYPE_PREFIX)) {
                buf.insert(0, filler);
            } else if (fillType.equals(FILL_TYPE_SUFFIX)) {
                buf.append(filler);
            } else {
                throw new RuntimeException("无法识别的fillType：" + fillType);
            }
        }
        return buf.toString();
    }

    /**
     * 判断value长度是否为length，如果不是，则在前面填充filler，直至长度为length
     *
     * @param value
     * @param filler
     * @param length
     * @return
     */
    public static String fillPrefix(String value, String filler, int length) {
        return fill(value, filler, FILL_TYPE_PREFIX, length);
    }

    /**
     * 判断value长度是否为length，如果不是，则在后面填充filler，直至长度为length
     *
     * @param value
     * @param filler
     * @param length
     * @return
     */
    public static String fillSuffix(String value, String filler, int length) {
        return fill(value, filler, FILL_TYPE_SUFFIX, length);
    }

    public static boolean endsWith(String str, String suffix) {
        return endsWith(str, suffix, false);
    }

    private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
        if (str == null || suffix == null) {
            return (str == null && suffix == null);
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        int strOffset = str.length() - suffix.length();
        return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
    }

    /*
     * =========================================================================
     * = ==
     */
    /* 取子串函数。 */
    /*
     * =========================================================================
     * = ==
     */

    /**
     * 取指定字符串的子串。
     *
     * <p>
     * 负的索引代表从尾部开始计算。如果字符串为<code>null</code>，则返回<code>null</code>。
     *
     * <pre>
     * StringUtil.substring(null, *)   = null
     * StringUtil.substring(&quot;&quot;, *)     = &quot;&quot;
     * StringUtil.substring(&quot;abc&quot;, 0)  = &quot;abc&quot;
     * StringUtil.substring(&quot;abc&quot;, 2)  = &quot;c&quot;
     * StringUtil.substring(&quot;abc&quot;, 4)  = &quot;&quot;
     * StringUtil.substring(&quot;abc&quot;, -2) = &quot;bc&quot;
     * StringUtil.substring(&quot;abc&quot;, -4) = &quot;abc&quot;
     * </pre>
     *
     * </p>
     *
     * @param str
     *            字符串
     * @param start
     *            起始索引，如果为负数，表示从尾部查找
     *
     * @return 子串，如果原始串为<code>null</code>，则返回<code>null</code>
     */
    public static String substring(String str, int start) {
        if (str == null) {
            return null;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }

        if (start > str.length()) {
            return EMPTY_STRING;
        }

        return str.substring(start);
    }

    /**
     * 取指定字符串的子串。
     *
     * <p>
     * 负的索引代表从尾部开始计算。如果字符串为<code>null</code>，则返回<code>null</code>。
     *
     * <pre>
     * StringUtil.substring(null, *, *)    = null
     * StringUtil.substring(&quot;&quot;, * ,  *)    = &quot;&quot;;
     * StringUtil.substring(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
     * StringUtil.substring(&quot;abc&quot;, 2, 0)   = &quot;&quot;
     * StringUtil.substring(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
     * StringUtil.substring(&quot;abc&quot;, 4, 6)   = &quot;&quot;
     * StringUtil.substring(&quot;abc&quot;, 2, 2)   = &quot;&quot;
     * StringUtil.substring(&quot;abc&quot;, -2, -1) = &quot;b&quot;
     * StringUtil.substring(&quot;abc&quot;, -4, 2)  = &quot;ab&quot;
     * </pre>
     *
     * </p>
     *
     * @param str
     *            字符串
     * @param start
     *            起始索引，如果为负数，表示从尾部计算
     * @param end
     *            结束索引（不含），如果为负数，表示从尾部计算
     *
     * @return 子串，如果原始串为<code>null</code>，则返回<code>null</code>
     */
    public static String substring(String str, int start, int end) {
        return substring(str, start, end, StringUtils.EMPTY_STRING);
    }

    public static String substring(String str, int start, int end, String moreFiller) {
        if (str == null) {
            return null;
        }

        if (end < 0) {
            end = str.length() + end;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return EMPTY_STRING;
        }

        if (start < 0) {
            start = 0;
        }

        if (end < 0) {
            end = 0;
        }

        String returnString = str.substring(start, end);
        if (!StringUtils.isEmpty(moreFiller)) {
            if (returnString.length() < str.length()) {
                if (start >= 0) {
                    returnString += moreFiller;
                } else {
                    returnString = moreFiller + returnString;
                }
            }
        }
        return returnString;
    }

    /**
     * 取得长度为指定字符数的最左边的子串。
     *
     * <pre>
     * StringUtil.left(null, *)    = null
     * StringUtil.left(*, -ve)     = &quot;&quot;
     * StringUtil.left(&quot;&quot;, *)      = &quot;&quot;
     * StringUtil.left(&quot;abc&quot;, 0)   = &quot;&quot;
     * StringUtil.left(&quot;abc&quot;, 2)   = &quot;ab&quot;
     * StringUtil.left(&quot;abc&quot;, 4)   = &quot;abc&quot;
     * </pre>
     *
     * @param str
     *            字符串
     * @param len
     *            最左子串的长度
     *
     * @return 子串，如果原始字串为<code>null</code>，则返回<code>null</code>
     */
    public static String left(String str, int len) {
        if (str == null) {
            return null;
        }

        if (len < 0) {
            return EMPTY_STRING;
        }

        if (str.length() <= len) {
            return str;
        } else {
            return str.substring(0, len);
        }
    }

    /**
     * 取得长度为指定字符数的最右边的子串。
     *
     * <pre>
     * StringUtil.right(null, *)    = null
     * StringUtil.right(*, -ve)     = &quot;&quot;
     * StringUtil.right(&quot;&quot;, *)      = &quot;&quot;
     * StringUtil.right(&quot;abc&quot;, 0)   = &quot;&quot;
     * StringUtil.right(&quot;abc&quot;, 2)   = &quot;bc&quot;
     * StringUtil.right(&quot;abc&quot;, 4)   = &quot;abc&quot;
     * </pre>
     *
     * @param str
     *            字符串
     * @param len
     *            最右子串的长度
     *
     * @return 子串，如果原始字串为<code>null</code>，则返回<code>null</code>
     */
    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }

        if (len < 0) {
            return EMPTY_STRING;
        }

        if (str.length() <= len) {
            return str;
        } else {
            return str.substring(str.length() - len);
        }
    }

    /**
     * 取得从指定索引开始计算的、长度为指定字符数的子串。
     *
     * <pre>
     * StringUtil.mid(null, *, *)    = null
     * StringUtil.mid(*, *, -ve)     = &quot;&quot;
     * StringUtil.mid(&quot;&quot;, 0, *)      = &quot;&quot;
     * StringUtil.mid(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
     * StringUtil.mid(&quot;abc&quot;, 0, 4)   = &quot;abc&quot;
     * StringUtil.mid(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
     * StringUtil.mid(&quot;abc&quot;, 4, 2)   = &quot;&quot;
     * StringUtil.mid(&quot;abc&quot;, -2, 2)  = &quot;ab&quot;
     * </pre>
     *
     * @param str
     *            字符串
     * @param pos
     *            起始索引，如果为负数，则看作<code>0</code>
     * @param len
     *            子串的长度，如果为负数，则看作长度为<code>0</code>
     *
     * @return 子串，如果原始字串为<code>null</code>，则返回<code>null</code>
     */
    public static String mid(String str, int pos, int len) {
        if (str == null) {
            return null;
        }

        if ((len < 0) || (pos > str.length())) {
            return EMPTY_STRING;
        }

        if (pos < 0) {
            pos = 0;
        }

        if (str.length() <= (pos + len)) {
            return str.substring(pos);
        } else {
            return str.substring(pos, pos + len);
        }
    }

    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /*
     * =========================================================================
     * = ==
     */
    /* 字符串查找函数 —— 字符或字符串。 */
    /*                                                                              */
    /* 在字符串中查找指定字符或字符串。 */
    /*
     * =========================================================================
     * = ==
     */

    /**
     * 在字符串中查找指定字符，并返回第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>。
     *
     * <pre>
     * StringUtil.indexOf(null, *)         = -1
     * StringUtil.indexOf(&quot;&quot;, *)           = -1
     * StringUtil.indexOf(&quot;aabaabaa&quot;, 'a') = 0
     * StringUtil.indexOf(&quot;aabaabaa&quot;, 'b') = 2
     * </pre>
     *
     * @param str
     *            要扫描的字符串
     * @param searchChar
     *            要查找的字符
     *
     * @return 第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>
     */
    public static int indexOf(String str, char searchChar) {
        if ((str == null) || (str.length() == 0)) {
            return -1;
        }

        return str.indexOf(searchChar);
    }

    /**
     * 在字符串中查找指定字符，并返回第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>。
     *
     * <pre>
     * StringUtil.indexOf(null, *, *)          = -1
     * StringUtil.indexOf(&quot;&quot;, *, *)            = -1
     * StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 0)  = 2
     * StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 3)  = 5
     * StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', 9)  = -1
     * StringUtil.indexOf(&quot;aabaabaa&quot;, 'b', -1) = 2
     * </pre>
     *
     * @param str
     *            要扫描的字符串
     * @param searchChar
     *            要查找的字符
     * @param startPos
     *            开始搜索的索引值，如果小于0，则看作0
     *
     * @return 第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>
     */
    public static int indexOf(String str, char searchChar, int startPos) {
        if ((str == null) || (str.length() == 0)) {
            return -1;
        }

        return str.indexOf(searchChar, startPos);
    }

    /**
     * 在字符串中查找指定字符串，并返回第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>。
     *
     * <pre>
     * StringUtil.indexOf(null, *)          = -1
     * StringUtil.indexOf(*, null)          = -1
     * StringUtil.indexOf(&quot;&quot;, &quot;&quot;)           = 0
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;)  = 0
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;)  = 2
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;) = 1
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;&quot;)   = 0
     * </pre>
     *
     * @param str
     *            要扫描的字符串
     * @param searchStr
     *            要查找的字符串
     *
     * @return 第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>
     */
    public static int indexOf(String str, String searchStr) {
        if ((str == null) || (searchStr == null)) {
            return -1;
        }

        return str.indexOf(searchStr);
    }

    /**
     * 在字符串中查找指定字符串，并返回第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>。
     *
     * <pre>
     * StringUtil.indexOf(null, *, *)          = -1
     * StringUtil.indexOf(*, null, *)          = -1
     * StringUtil.indexOf(&quot;&quot;, &quot;&quot;, 0)           = 0
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 0)  = 0
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 0)  = 2
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;, 0) = 1
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 3)  = 5
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 9)  = -1
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, -1) = 2
     * StringUtil.indexOf(&quot;aabaabaa&quot;, &quot;&quot;, 2)   = 2
     * StringUtil.indexOf(&quot;abc&quot;, &quot;&quot;, 9)        = 3
     * </pre>
     *
     * @param str
     *            要扫描的字符串
     * @param searchStr
     *            要查找的字符串
     * @param startPos
     *            开始搜索的索引值，如果小于0，则看作0
     *
     * @return 第一个匹配的索引值。如果字符串为<code>null</code>或未找到，则返回<code>-1</code>
     */
    public static int indexOf(String str, String searchStr, int startPos) {
        if ((str == null) || (searchStr == null)) {
            return -1;
        }

        // JDK1.3及以下版本的bug：不能正确处理下面的情况
        if ((searchStr.length() == 0) && (startPos >= str.length())) {
            return str.length();
        }

        return str.indexOf(searchStr, startPos);
    }




}
