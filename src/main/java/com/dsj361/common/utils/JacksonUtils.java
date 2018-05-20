package com.dsj361.common.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * jackson工具类<br>
 *
 * @author chenbug
 *
 * @version $Id: JackSonUtils.java, v 0.1 2016年2月29日 下午5:41:19 chenbug Exp $
 */
public class JacksonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();



    /**
     * 转换成json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        StringWriter sw = new StringWriter();
        try {
            objectMapper.writeValue(sw, object);
        } catch (Exception e) {
            throw new RuntimeException("解析字符串异常");
        } finally {
            try {
                sw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sw.toString();
    }

    /**
     * @param node
     * @param fieldName
     * @return
     */
    public static String getFieldValueAsStringSafe(JsonNode node, String fieldName) {
        JsonNode fieldNode = node.get(fieldName);
        return fieldNode == null ? null : fieldNode.asText();

    }

    /**
     * 将json转成clasz实例
     *
     * @param content
     * @param clasz
     * @return
     */
    public static <T> T parseJson(String content, Class<T> clasz) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return objectMapper.readValue(content, clasz);
        } catch (Exception e) {
            throw new RuntimeException("解析json字符串异常,content=" + content, e);
        }
    }

    public static JsonNode parseJson(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return objectMapper.readTree(content);
        } catch (Exception e) {
            throw new RuntimeException( "解析json字符串异常,content=" + content, e);
        }
    }

    /**
     * 将json字符串转换为kvmap
     *
     * @param content
     * @return
     */
    public static Map<String, String> toStringMap(String content) {
        Map<String, String> returnMap = new HashMap<String, String>();
        JsonNode jsonNode = JacksonUtils.parseJson(content);
        Iterator<Map.Entry<String, JsonNode>> ite = jsonNode.fields();
        while (ite.hasNext()) {
            Map.Entry<String, JsonNode> child = ite.next();
            returnMap.put(child.getKey(), child.getValue().asText());
        }
        return returnMap;
    }

    /**
     * 返回objectMapper
     *
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * 创建对象节点
     *
     * @return
     */
    public static ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    /**
     * 创建数组节点
     *
     * @return
     */
    public static ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    /**
     * 返回jsonFactory
     *
     * @return
     */
    public static JsonFactory getFactory() {
        return objectMapper.getFactory();
    }

}
