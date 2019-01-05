package com.dsj361;

import com.dsj361.common.enums.DatabaseTypeEnum;
import com.dsj361.common.enums.ModeEnum;
import com.dsj361.config.DatabaseUrlConfiguration;
import com.dsj361.model.DatabaseUrl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangkai
 * @date 2018/11/12 17:57
 */
public class TestDataBaseUrlConnection {


    @Test
    public void destGetAll() {
        List<DatabaseUrl> urls = DatabaseUrlConfiguration.getAllDatabaseUrls(ModeEnum.DEV);
        System.out.println(urls);
    }

    @Test
    public void destGetByAlias() {
        String alias = "recommend";
        System.out.println(DatabaseUrlConfiguration.getDataBaseUrlByAlias(ModeEnum.DEV, alias));
    }

    @Test
    public void destGetUrlsByAlias() {
        List<String> alias = Arrays.asList("recommend", "warehouse");
        System.out.println(DatabaseUrlConfiguration.getDatabaseUrlsByAlias(ModeEnum.DEV, alias));
    }

    @Test
    public void testGetByType() {
        System.out.println(DatabaseUrlConfiguration.getDatabaseUrlsByType(ModeEnum.DEV, DatabaseTypeEnum.ORACLE));
    }
}
