package com.dsj361.dao;

import com.dsj361.common.enums.ModeEnum;
import com.dsj361.config.Constants;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.source.ClassPathSourceFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangkai
 * @date 2018/11/12 16:03
 */
public class DbManager {

    private static final Logger log = Logger.getLogger(DbManager.class);

    private static ModeEnum mode;

    private static boolean init = false; // 是否初始化过

    static void init(ModeEnum mode) {
        if (init) {
            return;
        }
        DbManager.mode = mode;
        Properties prop = new Properties();
        String configFileName = "db_" + mode.name().toLowerCase() + ".config";
        InputStream is = DbManager.class.getClassLoader().getResourceAsStream(configFileName);
        try {
            prop.load(is);
        } catch (IOException e) {
            log.error("加载配置异常！", e);
            throw new RuntimeException("加载配置异常！");
        }
        String userName = prop.getProperty("username");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driverName = prop.getProperty("driverName");

        DruidPlugin plugin = new DruidPlugin(url, userName, password, driverName);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(Constants.DB_ALIAS_CONFIG, plugin);
        activeRecordPlugin.getEngine().setSourceFactory(new ClassPathSourceFactory());
        activeRecordPlugin.setDialect(new OracleDialect());
        plugin.start();
        activeRecordPlugin.start();

        init = true;
    }
}
