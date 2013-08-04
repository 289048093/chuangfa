/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.chuangfa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;

import com.chuangfa.LoginedUser;
import com.chuangfa.UrlInterceptorManager;
import com.chuangfa.util.Constant;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用户验证拦截器
 * 
 * @author xgj
 * 
 */
public class AuthorityInterceptor extends AbstractInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = -6206584295411567633L;

    /**
     * 拦截器
     * 
     * @throws Exception
     *             exc
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        if (!validateCludUrl(invocation)) {
            return invocation.invoke();
        }

        if (validateLogined(invocation)) {
            if (validateRights(invocation)) {
                return invocation.invoke();
            } else {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpServletResponse response = ServletActionContext.getResponse();
                String header = request.getHeader("x-requested-with");
                if (header != null && header.equalsIgnoreCase("XMLHttpRequest")) {
                    Map<String, String> maps = new HashMap<String, String>();
                    maps.put("rightsError", "rightsError");
                    response.setContentType("application/x-json");
                    response.getWriter().write(JSONUtil.serialize(maps));
                    response.getWriter().close();
                    return "rightsAjaxError";
                } else {
                    return "rightsError";
                }
            }
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            String header = request.getHeader("x-requested-with");
            if (header != null && header.equalsIgnoreCase("XMLHttpRequest")) {
                Map<String, String> maps = new HashMap<String, String>();
                maps.put("sessionError", "sessionError");
                response.setContentType("application/x-json");
                response.getWriter().write(JSONUtil.serialize(maps));
                response.getWriter().close();
                return "sessionAjaxError";
            } else {
                return "rightsError";
            }
        }

    }

    /**
     * 验证不包含的URL
     * 
     * @param invocation
     */
    private Boolean validateCludUrl(ActionInvocation invocation) {
        HttpServletRequest request = ServletActionContext.getRequest();
        String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
        return UrlInterceptorManager.getInstance().testURLPassesClude(url);

    }
    public static void main(String[] args) {
        System.out.println("/newsmanager/news!insert.action".matches(".*insert.*"));
    }
    /**
     * 验证session是否存在
     * 
     * @param invocation
     */
    private Boolean validateLogined(ActionInvocation invocation) {
        HttpServletRequest request = ServletActionContext.getRequest();
        LoginedUser loginedUser = (LoginedUser) request.getSession().getAttribute(Constant.LOGINED_USER);
        return loginedUser != null;
    }

    /**
     * 验证权限
     * 
     * @param invocation
     */
    private Boolean validateRights(ActionInvocation invocation) {
        HttpServletRequest request = ServletActionContext.getRequest();
        String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
        LoginedUser loginedUser = (LoginedUser) request.getSession().getAttribute(Constant.LOGINED_USER);
        return loginedUser.containRights(url);
    }

}
