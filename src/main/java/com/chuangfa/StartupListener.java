/**
 * Copyright(c) 2012 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 14, 2012  3:14:34 PM
 */
package com.chuangfa;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.chuangfa.util.LogUtil;
import com.chuangfa.util.ProjectUtil;

/**
 * 启动之后的监听器
 * 
 * @author xgj
 * 
 */
public class StartupListener implements ServletContextListener {
    /**
     * 销毁
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    /**
     * 初始化
     */
    public void contextInitialized(ServletContextEvent event) {
        try {
            ProjectUtil.initSpringContext(event.getServletContext());
            PropertyManager.getInstance().initProperty();
            UrlInterceptorManager.getInstance().initAuthUrls();
        } catch (Exception e) {
            LogUtil.error(e);
        }
        createDirs();
    }

    /**
     * 创建目录
     */
    public void createDirs() {
        File homeDir = ProjectUtil.getFileRoot();
        if (!homeDir.exists()) {
            ProjectUtil.forceCreateDir(homeDir);
        }
        File dbHome = ProjectUtil.getDbHome();
        if (!dbHome.exists()) {
            ProjectUtil.forceCreateDir(dbHome);
        }
        File userDataHome = ProjectUtil.getUserDataHome();
        if (!userDataHome.exists()) {
            ProjectUtil.forceCreateDir(userDataHome);
        }
    }
}
