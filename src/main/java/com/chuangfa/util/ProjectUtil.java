/**
 * 
 */
package com.chuangfa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.chuangfa.PropertyManager;

/**
 * @author ChuangFa 和当前项目有关的工具类
 */
public final class ProjectUtil {
    /**
     * spring上下文
     */
    private static WebApplicationContext applicationContext;

    /**
     * 私有化构造器
     */
    private ProjectUtil(){

    }

    /**
     * 初始化spring
     * 
     * @param servletContext
     */
    public static void initSpringContext(ServletContext servletContext) {
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        applicationContext = wac;
    }

    /**
     * 获取bean
     * 
     * @param key
     * @return
     */
    public static Object getSpringBean(String key) {
        return applicationContext.getBean(key);
    }

    /**
     * 获取文件对象
     * 
     * @param path
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object getObjectFromFile(Class<?> clasz) throws Exception {
        if (clasz == null) {
            return null;
        }
        return getObjectFromFile(clasz.getSimpleName());
    }

//    public static <T> T getObjectFromFile(Class<T> clazz) throws Exception{
//        if (clazz == null) {
//            return null;
//        }
//        return (T)getObjectFromFile(clazz.getSimpleName());
//    }

    public static Object getObjectFromFile(String name) throws Exception {
        if (name == null) {
            return null;
        }
        Object obj = null;
        File file = new File(getDbHome(), String.format("%1$s.db", name));
        if (!file.exists()) {
            return null;
        }
        ObjectInputStream ois;
        ois = new ObjectInputStream(new FileInputStream(file));
        obj = ois.readObject();
        ois.close();
        return obj;
    }

    /**
     * 对象写入文件
     * 
     * @param obj
     * @param fileName
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void writeObject2File(Object obj, Class<?> clasz) throws FileNotFoundException, IOException {
        if (obj == null) {
            return;
        }
        File file = new File(ProjectUtil.getDbHome(), String.format("%1$s.db", clasz.getSimpleName()));
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(obj);
        oos.close();
        PropertyManager.reload();
    }

    /**
     * fileDirHome
     * 
     * @return
     */
    public static File getFileRoot() {
        String path = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_CHUANGFA_CHUANGFAHOME);
        if (path == null || path.equals("")) {
            path = new File(ProjectUtil.class.getClassLoader().getResource("/").getPath()).getParentFile().getParent()
                    + File.separator + "chuangfa_home";
        }
        return new File(path);
    }

    /**
     * dbHome
     * 
     * @return
     */
    public static File getDbHome() {
        return new File(getFileRoot(), PropertyManager.getInstance()
                .getXMLProperty(PropertyManager.XML_CHUANGFA_DBHOME));
    }

    /**
     * 强制创建文件夹，如果父目录不存在则递归创建
     * 
     * @param file
     */
    public static void forceCreateDir(File file) {
        String parentDirStr = file.getParent();
        if (parentDirStr != null) {
            File parent = new File(parentDirStr);
            if (!parent.exists()) {
                forceCreateDir(parent);
            }
        }
        file.mkdir();
    }

    /**
     * userdir
     * 
     * @return
     */
    public static File getUserDataHome() {
        return new File(getFileRoot(), PropertyManager.getInstance().getXMLProperty(
                PropertyManager.XML_CHUANGFA_USERDATAHOME));
    }

    public static String processContent(String str) {
        return str.replace(" ", "&nbsp;").replace("\r\n", "<br/>").replace("{img:", "<image src='descPic/").replace(
                ":img}", "'/>");
    }

    public static String reProcessContent(String str) {
        return str == null ? "" : str.replace("&nbsp;", " ").replace("<br/>", "\r\n").replace("<image src='descPic/",
                "{img:").replace("'/>", ":img}");
    }
}
