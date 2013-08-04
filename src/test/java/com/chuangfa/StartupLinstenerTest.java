package com.chuangfa;

import org.junit.Before;
import org.junit.Test;

public class StartupLinstenerTest extends BaseTest {
    private StartupListener sl;
    @Before
    public void before(){
        sl = new StartupListener();
    }
    
    @Test
    public void createDirTest(){
        sl.createDirs();
    }
}
