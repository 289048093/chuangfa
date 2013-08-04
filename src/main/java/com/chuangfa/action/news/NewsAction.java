package com.chuangfa.action.news;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.entity.NewsEntity;
import com.chuangfa.service.news.NewsService;

@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/newsManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/news/news.jsp"),
        @Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
        @Result(name = "successInit", type = "dispatcher", location = "/news/initUpdate.jsp"),
        @Result(name = "detail", type = "dispatcher", location = "/news/newsDetail.jsp")})
public class NewsAction extends BaseAction<NewsEntity> {

    /**
     * 
     */
    private static final long serialVersionUID = -4288143036872352463L;

    private String SUCCESSINIT = "successInit";
    
    private String DETAIL = "detail";

    @Resource
    private NewsService newsService;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/news")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    public String insert() {
        newsService.insert(cloudContext);
        return JUMP;
    }

    public String query() {
        newsService.query(cloudContext);
        return SUCCESS;
    }

    public String delete() {
        newsService.delete(cloudContext);
        return JUMP;
    }

    public String initUpdate() {
        newsService.initUpdate(cloudContext);
        return SUCCESSINIT;
    }

    public String update() {
        newsService.update(cloudContext);
        return JUMP;
    }
    
    public String newsDetail(){
        newsService.newsDetail(cloudContext);
        return DETAIL;
    }
}
