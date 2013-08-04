package com.chuangfa.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.util.TokenHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.entity.MenuEntity;
import com.chuangfa.service.IndexService;
import com.chuangfa.util.Constant;
import com.chuangfa.util.LogUtil;

/**
 * 用户
 * 
 * @author ChuangFa
 */
@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/indexManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/indexJump.jsp"),
        @Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
        @Result(name = "updatePwd", type = "dispatcher", location = "/updatePwd.jsp"),
        @Result(name = "login", type = "dispatcher", location = "/login.jsp") })
public class IndexAction extends BaseAction<MenuEntity> {

    /**
     * 
     */
    private static final long serialVersionUID = -3352075675509410011L;
    /**
     * is
     */
    @Resource
    private IndexService indexService;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/index")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    public String initIndex() {
        indexService.initIndex(cloudContext);
        try {
            getRequest().getRequestDispatcher("indexJump.jsp").forward(getRequest(), getResponse());
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("页面跳转错误：" + e.getMessage());
        }
        return SUCCESS;
    }

    public String query() {
        indexService.initIndex(cloudContext);
        return SUCCESS;
    }

    public String updateLogo() {
        indexService.updateLogo(cloudContext);
        return JUMP;
    }

    public String updateIndexPic() {
        indexService.updateIndexPic(cloudContext);
        return JUMP;
    }

    public String login() {
        cloudContext.addParam(Constant.VERIFY_CODE, getSession().getAttribute(Constant.VERIFY_CODE));
        indexService.login(cloudContext);
        getSession().setAttribute(Constant.LOGINED_USER, cloudContext.getLoginedUser());
        return cloudContext.getSuccessIngoreWarn() ? JUMP : LOGIN;
    }

    public String updatePwd() {
        if(!TokenHelper.validToken()){
            return "updatePwd";
        }
        indexService.updatePwd(cloudContext);
        return cloudContext.getSuccessIngoreWarn() ? JUMP : "updatePwd";
    }

    public String logout() {
        getSession().invalidate();
        cloudContext.addSuccessMsg("注销成功");
        return JUMP;
    }
}
