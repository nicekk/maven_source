package com.dsj361.config;

import com.dsj361.dao.DAOFactory;
import com.dsj361.model.DatabaseUrl;

import java.util.List;

/**
 * 数据连接配置
 *
 * @author wangkai
 * @date 2018/11/12 15:55
 */
public class DatabaseUrlConfiguration {

    /**
     * 根据一个alias查询数据库配置
     *
     * @param mode
     * @param alias
     * @return
     */
    public static DatabaseUrl getDataBaseUrlByAlias(String mode, String alias) {
        return DAOFactory.getDatabaseUrlConfigDAO().getDatabaseUrlByAlias(mode, alias);
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @param alias
     * @return
     */
    public static List<DatabaseUrl> getDatabaseUrlsByAlias(String mode, List<String> alias) {
        return DAOFactory.getDatabaseUrlConfigDAO().getDatabaseUrlsByAlias(mode, alias);
    }

}
