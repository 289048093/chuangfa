/**
 * Copyright(c) 2012 ShenZhen ChuangFa Technology Co., Ltd
 * All rights reserved.
 * Created on Oct 15, 2012  2:17:56 PM
 */
package com.chuangfa;

import com.chuangfa.util.LogUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 异常捕获拦截器
 * 
 * @author ChuangFa
 * 
 */
public class ExceptionInterceptor extends AbstractInterceptor {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 拦截器的拦截方法
     * 
     * @throws Exception
     *             抛出所有异常
     */
    @SuppressWarnings("unchecked")
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            String result = invocation.invoke();
            return result;
        } catch (Exception e) {
            LogUtil.error(e);
            BaseAction action = (BaseAction) invocation.getAction();
            action.getCloudContext().addErrorMsg(e.getMessage());
            return "systemerror";
        }
    }

}
