/**
 * Copyright(c) 2012 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 14, 2012  3:14:34 PM
 */
package com.chuangfa;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * url管理器，包括地址拦截
 * 
 * @author ChuangFa
 * 
 */
@SuppressWarnings("unchecked")
public class UrlInterceptorManager {
    /**
     * 解析xml属性
     */
    private static Map<String, Object> parsedXMLProperty = new ConcurrentHashMap<String, Object>();
    /**
     * 实例对象
     */
    private static UrlInterceptorManager instance = new UrlInterceptorManager();

    /**
     * 获取实例对象
     * 
     * @return
     */
    public static UrlInterceptorManager getInstance() {
        return instance;
    }

    /**
     * 获取没有的权限url
     * 
     * @return
     */
    public Set<String> getAuthUrls() {
        return (Set<String>) parsedXMLProperty.get("parsedAuthUrls");
    }

    /**
     * 判断是否存在
     * 
     * @param url
     * @param exclude
     * @return
     */
    public boolean testURLPassesClude(String url) {
        url = url.toLowerCase();
        for (String path : getAuthUrls()) {
            if (url.matches(path)) {
                return true;
            }
        }
        return false;

    }

    /**
     * 初始化没有的地址
     * 
     * @param excludeAuthUrls
     */
    public void initAuthUrls() {
        String authUrls = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_CHUANGFA_AUTHURLS);
        Set<String> parsedExclude = new HashSet<String>();
        if (authUrls.length() != 0) {
            String[] tmps = null;
            if (authUrls.equals("")) {
                tmps = new String[0];
            } else {
                tmps = authUrls.split(",");
            }
            for (String tmp : tmps) {
                tmp = tmp.trim();
                parsedExclude.add(tmp.replaceAll("\\.", "\\\\.").replaceAll("\\*", ".*").replaceAll("\\$", "\\\\$")
                        .replaceAll("\\?", "\\\\?").toLowerCase());
            }
        }
        parsedXMLProperty.put("parsedAuthUrls", parsedExclude);
    }
}
