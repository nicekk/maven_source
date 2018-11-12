package com.dsj361.dao;

/**
 * 简单的dao工厂
 *
 * @author wangkai
 * @date 2018/11/12 16:22
 */
public class DAOFactory {

    /**
     * 获取dao
     *
     * @return
     */
    public static DatabaseUrlConfigDAO getDatabaseUrlConfigDAO() {
        return new DatabaseUrlConfigDAO();
    }

}
