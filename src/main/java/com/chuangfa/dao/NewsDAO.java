package com.chuangfa.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chuangfa.BaseDAO;
import com.chuangfa.PropertyManager;
import com.chuangfa.entity.NewsEntity;
import com.chuangfa.util.ProjectUtil;

@Repository("newsDAO")
public class NewsDAO extends BaseDAO {

    /**
     * 插入一条新闻
     * 
     * @param news
     * @throws Exception
     */
    public void merge(NewsEntity news) throws Exception {
        Map<Integer, NewsEntity> map = getFileObj();
        if (news.getId() == null) {
            news.setId(PropertyManager.getInstance().generateId());
        }
        map.put(news.getId(), news);
        ProjectUtil.writeObject2File(map, NewsEntity.class);
    }

    public void delete(Integer id) throws Exception {
        Map<Integer, NewsEntity> map = getFileObj();
        map.remove(id);
        ProjectUtil.writeObject2File(map, NewsEntity.class);
    }

    public List<NewsEntity> query() throws Exception {
        return PropertyManager.getInstance().queryNews();
    }

    @SuppressWarnings("unchecked")
    private Map<Integer, NewsEntity> getFileObj() throws Exception {
        PropertyManager.getInstance().queryNews();
        return PropertyManager.getInstance().getNewsMap();
    }

    public NewsEntity get(Integer id) throws Exception {
        Map<Integer, NewsEntity> map = getFileObj();
        return map.get(id);
    }
}
