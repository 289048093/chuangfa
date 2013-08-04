/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.chuangfa.action.test;

import com.chuangfa.BaseTest;

/**
 * 负责创建Action的基类，所有的action都继承改类。 createAction()返回的action的excute方法 不会执行拦截器。 proxy的excute方法会执行拦截器。
 * 
 * @author xgj
 * 
 */
public abstract class BaseActionTest extends BaseTest{

}
