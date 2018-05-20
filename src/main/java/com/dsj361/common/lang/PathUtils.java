package com.dsj361.common.lang;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * 路径工具类
 */
public class PathUtils {

    public static String getRootPath() {
        String rootClassPath = "";
        try {
            String path = getClassLoader().getResource("").toURI().getPath();
            rootClassPath = new File(path).getAbsolutePath();
        } catch (Exception e) {
            try {
                String path = PathUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
                if (path.endsWith(File.separator)) {
                    path = path.substring(0, path.length() - 1);
                }
                rootClassPath = path;
            } catch (UnsupportedEncodingException e1) {
                throw new RuntimeException(e1);
            }
        }
        return rootClassPath;
    }

    private static ClassLoader getClassLoader() {
        ClassLoader ret = Thread.currentThread().getContextClassLoader();
        return ret != null ? ret : PathUtils.class.getClassLoader();
    }
}