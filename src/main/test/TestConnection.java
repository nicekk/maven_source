import com.dsj361.common.enums.DatabaseTypeEnum;
import com.dsj361.common.enums.ModeEnum;
import com.dsj361.config.DatabaseUrlConfiguration;
import com.dsj361.model.DatabaseUrl;

import java.util.List;

/**
 * @author wangkai
 * @date 2018/11/12 17:57
 */
public class TestConnection {

    public static void main(String[] args) {
//        DatabaseUrl databaseUrl = DatabaseUrlConfiguration.getDataBaseUrlByAlias(ModeEnum.DEV, "recommend");
//        System.out.println(databaseUrl);
//        System.out.println(DatabaseUrlConfiguration.getAllDatabaseUrls(ModeEnum.DEV));
        List<DatabaseUrl> urls = DatabaseUrlConfiguration.getDatabaseUrlsByType(ModeEnum.DEV, DatabaseTypeEnum.MYSQL);
        System.out.println(urls);
    }

}
