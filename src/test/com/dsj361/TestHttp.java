package com.dsj361;

import com.dsj361.common.http.HttpClientUtil;
import com.dsj361.common.http.builder.HCB;
import com.dsj361.common.http.common.HttpConfig;
import com.dsj361.common.http.common.SSLs;
import com.dsj361.common.http.exception.HttpProcessException;

/**
 * @author wangkai
 * @date 2018/11/27 12:08
 */
public class TestHttp {

    public static void main(String[] args) throws HttpProcessException {
        String url = "https://github.com/Arronlong/httpclientutil";

        //最简单的使用：
        String html = HttpClientUtil.get(HttpConfig.custom().url(url).client(HCB.custom().sslpv(SSLs.SSLProtocolVersion.TLSv1_2).ssl().build()));
        System.out.println(html);

    }
}
