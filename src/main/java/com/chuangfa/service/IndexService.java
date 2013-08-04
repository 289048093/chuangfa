package com.chuangfa.service;

import java.beans.Encoder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.LoginedUser;
import com.chuangfa.PropertyManager;
import com.chuangfa.dao.ProductDAO;
import com.chuangfa.dao.UserDAO;
import com.chuangfa.entity.MenuEntity;
import com.chuangfa.entity.NewsEntity;
import com.chuangfa.entity.ProductEntity;
import com.chuangfa.entity.UserEntity;
import com.chuangfa.entity.WebPageEntity;
import com.chuangfa.util.Constant;
import com.chuangfa.util.LogUtil;
import com.chuangfa.util.ProjectUtil;
import com.chuangfa.util.StringUtil;

@Service("indexService")
public class IndexService extends BaseService {

    @Resource
    private ProductDAO productDAO;

    @Resource
    private UserDAO userDAO;

    /**
     * 获取菜单
     * 
     * @param cloudContext
     */
    public void initIndex(CloudContext<?> cloudContext) {
        try {
            Collection<Integer> proIds = PropertyManager.getInstance().getTopProMap().values();
            List<ProductEntity> pros = new ArrayList<ProductEntity>();
            for (int id : proIds) {
                pros.add(productDAO.get(id));
            }
            cloudContext.addParam("topProducts", pros);
            int xmlTopNewsLenth = Integer.parseInt(PropertyManager.getInstance().getXMLProperty(
                    PropertyManager.XML_CHUANGFA_TOPNEWSSIZE));
            List<NewsEntity> originalNews = PropertyManager.getInstance().queryNews();
            cloudContext.addParam("topNews", originalNews.subList(0,
                    xmlTopNewsLenth > originalNews.size() ? originalNews.size() : xmlTopNewsLenth));
        } catch (Exception e) {
            cloudContext.addErrorMsg("数据获取错误");
        }
    }

    public void updateLogo(CloudContext<MenuEntity> cloudContext) {
        String logoPic = cloudContext.getStringParam("logoPic");
        try {
            WebPageEntity webPage = PropertyManager.getInstance().getWebPage();
            webPage.setLogoPic(logoPic);
            ProjectUtil.writeObject2File(webPage, WebPageEntity.class);
            cloudContext.addSuccessMsg("修改成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据更新错误:" + e.getMessage());
        }
    }

    public void updateIndexPic(CloudContext<MenuEntity> cloudContext) {
        String indexPic = cloudContext.getStringParam("indexPic");
        try {
            WebPageEntity webPage = PropertyManager.getInstance().getWebPage();
            webPage.setIndexPic(indexPic);
            ProjectUtil.writeObject2File(webPage, WebPageEntity.class);
            cloudContext.addSuccessMsg("修改成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据更新错误:" + e.getMessage());
        }
    }

    public void login(CloudContext<MenuEntity> cloudContext) {
        String username = cloudContext.getStringParam("username");
        String password = cloudContext.getStringParam("password");
        String userCode = cloudContext.getStringParam("userCode");
        String verifyCode = cloudContext.getStringParam(Constant.VERIFY_CODE);
        if (!userCode.equals(verifyCode)) {
            cloudContext.addErrorMsg("验证码错误");
            return;
        }
        try {
            UserEntity user = userDAO.testingUsernameAndPassword(username, password);
            if (user == null) {
                cloudContext.addErrorMsg("用户名或者密码错误");
            } else {
                user.setLastLoginTime(new Date());
                userDAO.update(user);
                cloudContext.setLoginedUser(new LoginedUser());
                cloudContext.getLoginedUser().setLastLoginTime(user.getLastLoginTime());
                cloudContext.getLoginedUser().setUsername(username);
                cloudContext.getLoginedUser().setId(user.getId());
                cloudContext.addSuccessMsg("登录成功");
            }
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误:" + e.getMessage());
        }
    }

    public void updatePwd(CloudContext<MenuEntity> cloudContext) {
        LoginedUser lu = cloudContext.getLoginedUser();
        if (lu == null) {
            cloudContext.addErrorMsg("你没有登录");
            return;
        }
        String username = lu.getUsername();
        String password = cloudContext.getStringParam("password");
        String newPwd = cloudContext.getStringParam("newPwd");
        try {
            UserEntity user = userDAO.testingUsernameAndPassword(username, password);
            if (user == null) {
                cloudContext.addErrorMsg("原密码错误");
                return;
            }
            user.setUsername(username);
            user.setPassword(StringUtil.encrypt(username, newPwd));
            userDAO.update(user);
            cloudContext.addSuccessMsg("修改密码成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误:" + e.getMessage());
        }
    }
}
