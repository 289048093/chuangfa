package com.chuangfa.entity.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.chuangfa.BaseTest;
import com.chuangfa.entity.ContactOurEntity;
import com.chuangfa.util.ProjectUtil;

public class ContactOurEntityTest extends BaseTest {
    
    @Test
    public void write2FileEntityTest() throws Exception {
        ContactOurEntity coe = new ContactOurEntity();
        List<String> tels = new ArrayList<String>();
        tels.add("111111");
        tels.add("22222222");
        tels.add("3333333");
        ProjectUtil.writeObject2File(coe, ContactOurEntity.class);
    }
    
    @Test
    public void readFileEntityTest() throws Exception {
        ContactOurEntity coe = (ContactOurEntity) ProjectUtil.getObjectFromFile(ContactOurEntity.class);
        
    }
}
