package com.dsj361.config;

import com.dsj361.common.enums.DatabaseTypeEnum;
import com.dsj361.common.enums.ModeEnum;
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
    public static DatabaseUrl getDataBaseUrlByAlias(ModeEnum mode, String alias) {
        return DAOFactory.getDatabaseUrlConfigDAO().getDatabaseUrlByAlias(mode, alias);
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @param alias
     * @return
     */
    public static List<DatabaseUrl> getDatabaseUrlsByAlias(ModeEnum mode, List<String> alias) {
        return DAOFactory.getDatabaseUrlConfigDAO().getDatabaseUrlsByAlias(mode, alias);
    }

    /**
     * 获得所有的数据库连接串
     *
     * @param mode
     * @return
     */
    public static List<DatabaseUrl> getAllDatabaseUrls(ModeEnum mode) {
        return DAOFactory.getDatabaseUrlConfigDAO().getAllDatabaseUrls(mode);
    }

    /**
     * 根据数据库类型获取数据库连接
     *
     * @param type
     * @return
     */
    public static List<DatabaseUrl> getDatabaseUrlsByType(ModeEnum mode, DatabaseTypeEnum type) {
        return DAOFactory.getDatabaseUrlConfigDAO().getDatabaseUrlByType(mode, type);
    }

    /**
     * 根据数据库类型和用处获取数据库连接
     * @param mode
     * @param type
     * @param usage
     * @return
     */
    public static List<DatabaseUrl> getDatabaseUrlsByTypeAndUsage(ModeEnum mode, DatabaseTypeEnum type, String usage) {
        return DAOFactory.getDatabaseUrlConfigDAO().getDatabaseUrlByTypeAndUsage(mode, type, usage);
    }
}
