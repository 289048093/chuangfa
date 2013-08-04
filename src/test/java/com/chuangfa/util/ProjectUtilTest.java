package com.chuangfa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chuangfa.BaseTest;
import com.chuangfa.entity.NewsEntity;

public class ProjectUtilTest extends BaseTest {

    @Test
    public void getFileRootTest() {
        System.out.println(ProjectUtil.getFileRoot());
    }

    @Test
    public void getDbHomeTest() {
        System.out.println(ProjectUtil.getDbHome());
        File f = ProjectUtil.getDbHome();
        for (File e : f.listFiles()) {
            System.out.println(e.getName());
        }
    }

    @Test
    public void getUserDataHomeTest() {
        System.out.println(ProjectUtil.getUserDataHome());
    }

    @Test
    public void writeObject2FileTest() throws FileNotFoundException, IOException {
        NewsEntity news = new NewsEntity();
        news.setAddTime(new Date());
        news.setTitle("aaa");
        Map<String, NewsEntity> map = new HashMap<String, NewsEntity>();
        map.put(news.getTitle(), news);
        ProjectUtil.writeObject2File(news, NewsEntity.class);
    }

    @Test
    public void getObjectFromFileTest() throws Exception {
        Map<String, NewsEntity> news = (Map<String, NewsEntity>) ProjectUtil.getObjectFromFile(NewsEntity.class);
        System.out.println(news == null ? 0 : news.size());
    }
}
