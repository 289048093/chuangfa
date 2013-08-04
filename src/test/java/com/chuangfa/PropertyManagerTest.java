package com.chuangfa;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.chuangfa.entity.MenuEntity;

public class PropertyManagerTest extends BaseTest {
    private PropertyManager pm;

    @Before
    public void before() {
        pm = PropertyManager.getInstance();
    }

    @Test
    public void getMenuTest() {
        List<MenuEntity> list = pm.getMenus();
        System.out.println(list.toArray());
    }
    
}
