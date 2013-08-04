/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:53:10 PM
 */
package com.chuangfa.util;

/**
 * 常量
 * 
 * @author xgj
 * 
 */
public interface Constant {
    /**
     * 登陆用户的信息
     */
    String LOGINED_USER = "userLogin";
    /**
     * 验证码
     */
    String VERIFY_CODE = "verifyCode";
    /**
     * 用户正常状态
     */
    String USER_NORMAL_STATE = "1";
    /**
     * 用户删除状态
     */
    String USER_DELETE_STATE = "0";
    /**
     * 用户男性
     */
    String USER_SEX_MAN = "1";
    /**
     * 用户女性
     */
    String USER_SEX_WOMAN = "0";

    /**
     * 角色持久化 是
     */
    String ROLE_PERSISTENCE_YES = "1";
    /**
     * 角色持久化 否
     */
    String ROLE_PERSISTENCE_NO = "0";

    String PRODUCT_PIC_DIC = "productImage/";

    String PRODUCT_HEAD_PIC_DIC = "productHeadImage/";

}
