package com.chuangfa;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class) // 用于配置spring中测试的环境 
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class})//监听
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})//用于指定配置文件所在的位置 
public class BaseTest {
    
}
