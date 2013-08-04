/**
 * Copyright(c) 2012 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 14, 2012  3:14:34 PM
 */
package com.chuangfa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.chuangfa.entity.ComdescEntity;
import com.chuangfa.entity.ContactOurEntity;
import com.chuangfa.entity.JobsEntity;
import com.chuangfa.entity.MenuEntity;
import com.chuangfa.entity.NewsEntity;
import com.chuangfa.entity.ProductEntity;
import com.chuangfa.entity.SubshopInfoEntity;
import com.chuangfa.entity.TypeEntity;
import com.chuangfa.entity.UserEntity;
import com.chuangfa.entity.WebPageEntity;
import com.chuangfa.util.LogUtil;
import com.chuangfa.util.ProjectUtil;
import com.chuangfa.util.StringUtil;

/**
 * Property管理对象
 * 
 * @author ChuangFa
 * 
 */
public final class PropertyManager {
    /**
     * xml配置：不包括的url
     */
    public static final String XML_CHUANGFA_AUTHURLS = "chuangfa/authUrls";
    /**
     * xml配置：项目的home目录
     */
    public static final String XML_CHUANGFA_CHUANGFAHOME = "chuangfa/chuangfaHome";
    /**
     * 主菜单xml
     */
    public static final String XML_CHUANGFA_MENU = "chuangfa/menu";
    /**
     * dbHome
     */
    public static final String XML_CHUANGFA_DBHOME = "chuangfa/dbHome";

    public static final String XML_CHUANGFA_USERDATAHOME = "chuangfa/userDataHome";

    public static final String XML_CHUANGFA_TOPPRODUCTSIZE = "chuangfa/topProductSize";

    public static final String XML_CHUANGFA_TOPNEWSSIZE = "chuangfa/topNewsSize";

    public static final String XML_CHUANFA_PROHEADWIDTH = "chuangfa/proHeadPicWidth";

    public static final String XML_CHUANFA_PROHEADHEIGHT = "chuangfa/proHeadPicHeight";

    public static final String XML_CHUANFA_PROREALWIDTH = "chuangfa/proRealPicWidth";

    public static final String XML_CHUANFA_PROREALHEIGHT = "chuangfa/proRealPicHeight";
    /**
     * 菜单
     */
    public static List<MenuEntity> menus;
    /**
     * news
     */
    public Map<Integer, NewsEntity> newses;
    /**
     * pro type
     */
    public Map<Integer, TypeEntity> types;
    /**
     * 热门产品（热门序号，产品id)
     */
    private TreeMap<Integer, Integer> topProducts;
    /**
     * 产品
     */
    public Map<Integer, ProductEntity> products;

    public Map<Integer, JobsEntity> jobs;
    /**
     * 公司简介
     */
    public ComdescEntity comdesc;
    /**
     * 联系我们
     */
    public ContactOurEntity contactOurInfo;
    /**
     * 页面上的一些配置
     */
    private WebPageEntity webPage;
    /**
     * 当前id
     */
    private Integer id;
    /**
     * xmlProperty
     */
    private static Map<String, String> xmlProperty = new ConcurrentHashMap<String, String>();
    /**
     * 配置文件路径
     */
    private static final File PROJECT_CONFIG_FILE = new File(Thread.currentThread().getContextClassLoader()
            .getResource("project-config.xml").getFile());

    /**
     * 实例化对象
     */
    private static PropertyManager instance = new PropertyManager();
    /**
     * project-config.xml文件的Document对象
     */
    private Document document;

    /**
     * 私有化构造器
     */
    private PropertyManager(){

    }

    public Integer generateId() {
        try {
            if (id == null) {
                id = (Integer) ProjectUtil.getObjectFromFile(Integer.class);
                if (id == null) {
                    id = 0;
                }
            }
            id++;
            ProjectUtil.writeObject2File(id, Integer.class);
        } catch (Exception e) {
            LogUtil.error(e);
        }
        return id;
    }

    public WebPageEntity getWebPage() throws Exception {
        if (webPage == null) {
            webPage = (WebPageEntity) ProjectUtil.getObjectFromFile(WebPageEntity.class);
            if (webPage == null) {
                webPage = new WebPageEntity();
                webPage.setLinks(new TreeMap<String, String>());
            }
        }
        return webPage;
    }

    public Map<Integer, JobsEntity> getJobsMap() throws Exception {
        if (jobs == null) {
            jobs = (Map<Integer, JobsEntity>) ProjectUtil.getObjectFromFile(JobsEntity.class);
            if (jobs == null) {
                jobs = new HashMap<Integer, JobsEntity>();
                ProjectUtil.writeObject2File(jobs, JobsEntity.class);
            }
        }
        return jobs;
    }

    @SuppressWarnings("unchecked")
    public TreeMap<Integer, Integer> getTopProMap() throws Exception {
        if (topProducts != null) {
            return topProducts;
        }
        TreeMap<Integer, Integer> m = (TreeMap<Integer, Integer>) ProjectUtil.getObjectFromFile(TreeMap.class);
        topProducts = m;
        if (topProducts == null) {
            topProducts = new TreeMap<Integer, Integer>();
        }
        return topProducts;
    }

    /**
     * 获取菜单
     * 
     * @return
     */
    public static List<MenuEntity> getMenus() {
        if (menus == null) {
            menus = new ArrayList<MenuEntity>();
            String[] menusStr = getInstance().getXMLProperty(XML_CHUANGFA_MENU).replace(" ", "").split(";");
            MenuEntity menu = null;
            String[] menuTmp = null;
            for (String str : menusStr) {
                menu = new MenuEntity();
                menuTmp = str.split(":");
                menu.setName(menuTmp[0]);
                menu.setUrl(menuTmp[1]);
                menus.add(menu);
            }
        }
        return menus;
    }

    public ComdescEntity getComdesc() throws Exception {
        if (comdesc == null) {
            comdesc = (ComdescEntity) ProjectUtil.getObjectFromFile(ComdescEntity.class);
        }
        return comdesc;
    }

    public ContactOurEntity obtainOurInfo() throws Exception {
        ContactOurEntity coe = PropertyManager.getInstance().contactOurInfo;
        if (coe == null) {
            coe = (ContactOurEntity) ProjectUtil.getObjectFromFile(ContactOurEntity.class);
            if (coe == null) {
                coe = new ContactOurEntity();
            }
        }
        if (coe.getSubShops() == null) {
            coe.setSubShops(new HashMap<Integer, SubshopInfoEntity>());
        }
        return coe;
    }

    @SuppressWarnings("unchecked")
    public List<NewsEntity> queryNews() throws Exception {
        if (newses == null) {
            newses = (Map<Integer, NewsEntity>) ProjectUtil.getObjectFromFile(NewsEntity.class);
        }
        return newses == null ? null : new ArrayList<NewsEntity>(newses.values());
    }

    @SuppressWarnings("unchecked")
    public List<TypeEntity> queryTypes() throws Exception {
        if (types == null) {
            types = (Map<Integer, TypeEntity>) ProjectUtil.getObjectFromFile(TypeEntity.class);
        }
        return types == null ? null : new ArrayList<TypeEntity>(types.values());
    }

    @SuppressWarnings("unchecked")
    public List<ProductEntity> queryProducts(Integer typeId) throws Exception {
        if (products == null) {
            products = (Map<Integer, ProductEntity>) ProjectUtil.getObjectFromFile(ProductEntity.class);
            if (products == null) {
                products = new TreeMap<Integer, ProductEntity>();
            }
        }
        if (typeId == null) {
            return new ArrayList<ProductEntity>(products.values());
        }
        PropertyManager.getInstance().queryTypes();//先载入type到内存
        if (types == null) {
            return null;
        }
        TypeEntity type = types.get(typeId);
        Set<Integer> proIds = type.getProducts();
        List<ProductEntity> pros = new ArrayList<ProductEntity>();
        if (proIds != null) {
            for (Integer proId : proIds) {
                if (products.get(proId) != null) {
                    pros.add(products.get(proId));
                }
            }
        }
        return pros;
    }

    /**
     * 实例
     * 
     * @return
     */
    public static PropertyManager getInstance() {
        return instance;
    }

    /**
     * 初始化property
     * 
     * @throws Exception
     *             exc
     */
    public void initProperty() throws Exception {
        initXMLConfig();
    }

    /**
     * 保存xml属性
     */
    private synchronized void saveXmlProperties() {
        // Write data out to a temporary file first.
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PROJECT_CONFIG_FILE), "UTF-8"));
            OutputFormat prettyPrinter = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(writer, prettyPrinter);
            xmlWriter.write(document);
        } catch (Exception e) {
            LogUtil.fatal(e.getMessage(), e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    LogUtil.fatal(e1.getMessage(), e1);
                }
            }
        }

    }

    /**
     * 初始化xml配置
     * 
     * @throws Exception
     *             exc
     */
    private void initXMLConfig() throws Exception {
        SAXReader reader = new SAXReader(false);
        document = reader.read(PROJECT_CONFIG_FILE);

        //chuangfa/excludeAuthUrls
        Element authUrls = (Element) document.selectSingleNode(XML_CHUANGFA_AUTHURLS);
        xmlProperty.put(XML_CHUANGFA_AUTHURLS, authUrls.getTextTrim());

        //chuangfa/chuangfaHome
        Element homeDir = (Element) document.selectSingleNode(XML_CHUANGFA_CHUANGFAHOME);
        xmlProperty.put(XML_CHUANGFA_CHUANGFAHOME, homeDir.getTextTrim());

    }

    /**
     * ，设置xml文件
     * 
     * @param key
     * @param value
     * @throws Exception
     *             exc
     */
    public synchronized void setXMLProperty(String key, String value) throws Exception {
        xmlProperty.put(key, value);
        Element keyElement = (Element) document.selectSingleNode(key);
        if (keyElement != null) {
            keyElement.setText(value.trim());
            saveXmlProperties();
        }
    }

    /**
     * 获取XML属性
     * 
     * @param key
     * @return
     */
    public String getXMLProperty(String key) {
        if (xmlProperty.get(key) == null) {
            try {
                SAXReader reader = new SAXReader(false);
                document = reader.read(PROJECT_CONFIG_FILE);
                Element elementTmp = (Element) document.selectSingleNode(key);
                xmlProperty.put(key, elementTmp.getTextTrim());
            } catch (DocumentException e) {
                LogUtil.fatal(e);
            }
        }
        return xmlProperty.get(key);
    }

    /**
     * 重新实例化
     */
    public static void reload() {
        instance = new PropertyManager();
    }

    public static UserEntity getUser() throws Exception {
        UserEntity user = (UserEntity) ProjectUtil.getObjectFromFile(UserEntity.class);
        if (user == null) {
            user = new UserEntity();
            user.setId(PropertyManager.getInstance().generateId());
            user.setUsername("admin");
            user.setPassword(StringUtil.encrypt("admin", "liqinghua"));
            ProjectUtil.writeObject2File(user, UserEntity.class);
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public Map<Integer, NewsEntity> getNewsMap() throws Exception {
        if (newses == null) {
            newses = (Map<Integer, NewsEntity>) ProjectUtil.getObjectFromFile(NewsEntity.class);
        }
        return newses == null ? new TreeMap<Integer, NewsEntity>() : newses;
    }

    @SuppressWarnings("unchecked")
    public Map<Integer, TypeEntity> getTypesMap() throws Exception {
        if (types == null) {
            types = (Map<Integer, TypeEntity>) ProjectUtil.getObjectFromFile(TypeEntity.class);
        }
        return types == null ? new TreeMap<Integer, TypeEntity>() : types;
    }
}
