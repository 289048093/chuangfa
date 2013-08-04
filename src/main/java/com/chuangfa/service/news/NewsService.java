package com.chuangfa.service.news;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.PropertyManager;
import com.chuangfa.dao.NewsDAO;
import com.chuangfa.entity.NewsEntity;
import com.chuangfa.util.LogUtil;
import com.chuangfa.util.ProjectUtil;

@Service("newsService")
public class NewsService extends BaseService<NewsEntity> {

    @Resource
    private NewsDAO newsDAO;

    public void insert(CloudContext<NewsEntity> cloudContext) {
        cloudContext.getVo().setAddTime(new Date());
        cloudContext.getVo().setId(PropertyManager.getInstance().generateId());
        cloudContext.getVo().setContent(ProjectUtil.processContent(cloudContext.getVo().getContent()));
        try {
            newsDAO.merge(cloudContext.getVo());
            cloudContext.addSuccessMsg("添加成功");
        } catch (Exception e) {
            cloudContext.addErrorMsg("插入数据错误：" + e.getMessage());
        }
    }

    public void update(CloudContext<NewsEntity> cloudContext) {
        try {
            NewsEntity news = newsDAO.get(cloudContext.getVo().getId());
            news.setTitle(cloudContext.getVo().getTitle());
            news.setContent(ProjectUtil.processContent(cloudContext.getVo().getContent()));
            newsDAO.merge(news);
            cloudContext.addSuccessMsg("修改成功");
        } catch (Exception e) {
            cloudContext.addErrorMsg("插入数据错误：" + e.getMessage());
        }
    }

    public void query(CloudContext<NewsEntity> cloudContext) {
        try {
            List<NewsEntity> news = newsDAO.query();
            if (news != null) {
                Collections.sort(news, new Comparator<NewsEntity>() {
                    @Override
                    public int compare(NewsEntity o1, NewsEntity o2) {
                        if (o1.getAddTime().before(o2.getAddTime())) {
                            return 1;
                        }
                        if (o1.getAddTime().equals(o2.getAddTime())) {
                            return 0;
                        }
                        return -1;
                    }
                });
            }
            cloudContext.addParam("news", news);
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取数据错误：" + e.getMessage());
        }
    }

    public void delete(CloudContext<NewsEntity> cloudContext) {
        try {
            newsDAO.delete(cloudContext.getVo().getId());
            cloudContext.addSuccessMsg("删除成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("插入数据错误：" + e.getMessage());
        }
    }

    public void initUpdate(CloudContext<NewsEntity> cloudContext) {
        try {
            NewsEntity news = newsDAO.get(cloudContext.getVo().getId());
            news.setContent(ProjectUtil.reProcessContent(news.getContent()));
            cloudContext.setVo(news);
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取数据错误：" + e.getMessage());
        }
    }

    public void newsDetail(CloudContext<NewsEntity> cloudContext) {
        try {
            List<NewsEntity> newses = newsDAO.query();
            cloudContext.addParam("news", newses);
            cloudContext.setVo(newsDAO.get(cloudContext.getVo().getId()));
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取数据错误：" + e.getMessage());
        }
    }
}
