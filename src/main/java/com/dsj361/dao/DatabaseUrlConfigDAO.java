package com.dsj361.dao;

import com.dsj361.common.enums.DatabaseTypeEnum;
import com.dsj361.common.enums.ModeEnum;
import com.dsj361.common.lang.ObjectUtils;
import com.dsj361.config.Constants;
import com.dsj361.model.DatabaseUrl;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkai
 * @date 2018/11/12 16:22
 */
public class DatabaseUrlConfigDAO {

    /**
     * 根据别名获取配置
     *
     * @param dbAlias
     * @return
     */
    public DatabaseUrl getDatabaseUrlByAlias(ModeEnum mode, String dbAlias) {
        DbManager.init(mode);
        Record record = Db.use(Constants.DB_ALIAS_CONFIG).findFirst("select * from database_url_config where alias = '" + dbAlias + "' and enabled=1");
        return convert(record);
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @param alias
     * @return
     */
    public List<DatabaseUrl> getDatabaseUrlsByAlias(ModeEnum mode, List<String> alias) {
        DbManager.init(mode);
        StringBuilder sb = new StringBuilder();
        sb.append("'");
        for (int i = 0; i < alias.size(); i++) {
            sb.append(alias.get(i));
            if (i < alias.size() - 1) {
                sb.append("','");
            }
        }
        sb.append("'");
        String aliasJoin = sb.toString();

        String sql = "select * from database_url_config where alias in (" + aliasJoin + ") and enabled=1";
        return converts(Db.use(Constants.DB_ALIAS_CONFIG).find(sql));
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @return
     */
    public List<DatabaseUrl> getAllDatabaseUrls(ModeEnum mode) {
        DbManager.init(mode);
        String sql = "select * from database_url_config where enabled=1";
        return converts(Db.use(Constants.DB_ALIAS_CONFIG).find(sql));
    }

    /**
     * 根据一组别名查找
     *
     * @param mode
     * @return
     */
    public List<DatabaseUrl> getDatabaseUrlByType(ModeEnum mode, DatabaseTypeEnum type) {
        DbManager.init(mode);
        String sql = "select * from database_url_config where type = '" + type.name().toLowerCase() + "' and enabled=1";
        return converts(Db.use(Constants.DB_ALIAS_CONFIG).find(sql));
    }

    private static DatabaseUrl convert(Record record) {
        DatabaseUrl databaseUrl = new DatabaseUrl();
        databaseUrl.setAlias(ObjectUtils.toString(record.get("ALIAS")));
        DatabaseTypeEnum type = DatabaseTypeEnum.valueOf(ObjectUtils.toString(record.get("TYPE")).toUpperCase());
        databaseUrl.setType(type);
        databaseUrl.setHost(ObjectUtils.toString(record.get("HOST")));
        databaseUrl.setPort(ObjectUtils.toString(record.get("PORT")));
        databaseUrl.setDsnName(ObjectUtils.toString(record.get("DSN_NAME")));
        databaseUrl.setDbName(ObjectUtils.toString(record.get("DB_NAME")));
        databaseUrl.setUserName(ObjectUtils.toString(record.get("USERNAME")));
        databaseUrl.setPassword(ObjectUtils.toString(record.get("PASSWORD")));
        databaseUrl.setDriverClass(ObjectUtils.toString(record.get("DRIVER_CLASS")));
        if (type == DatabaseTypeEnum.ORACLE) {
            databaseUrl.setJdbcUrl("jdbc:oracle:thin:@" + databaseUrl.getHost() + ":" + databaseUrl.getPort() + "/" + databaseUrl.getDbName());
        } else if (type == DatabaseTypeEnum.MYSQL) {
            databaseUrl.setJdbcUrl("jdbc:mysql://" + databaseUrl.getHost() + ":" + databaseUrl.getPort() + "/" + databaseUrl.getDbName() + "?useUnicode=true&characterEncoding=UTF-8");
        }
        return databaseUrl;
    }

    private static List<DatabaseUrl> converts(List<Record> records) {
        List<DatabaseUrl> urls = new ArrayList<>();
        for (Record record : records) {
            urls.add(convert(record));
        }
        return urls;
    }
}
