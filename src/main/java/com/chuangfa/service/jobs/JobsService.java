package com.chuangfa.service.jobs;

import java.util.Date;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.PropertyManager;
import com.chuangfa.dao.JobsDAO;
import com.chuangfa.entity.JobsEntity;
import com.chuangfa.util.LogUtil;

@Service("jobService")
public class JobsService extends BaseService<JobsEntity> {

    @Resource
    private JobsDAO jobsDAO;

    public void insert(CloudContext<JobsEntity> cloudContext) {
        JobsEntity jobsEntity = cloudContext.getVo();
        jobsEntity.setId(PropertyManager.getInstance().generateId());
        jobsEntity.setContent(cloudContext.getVo().getContent().replace(" ", "&nbsp;").replace("\r\n", "<br/>"));
        Date now = new Date();
        jobsEntity.setModTime(now);
        jobsEntity.setAddTime(now);
        try {
            jobsDAO.merge(jobsEntity);
            cloudContext.addSuccessMsg("插入数据成功！");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("插入数据错误：" + e.getMessage());
        }
    }

    public void update(CloudContext<JobsEntity> cloudContext) {
        JobsEntity jobsEntity = cloudContext.getVo();
        jobsEntity.setContent(cloudContext.getVo().getContent().replace(" ", "&nbsp;").replace("\r\n", "<br/>"));
        jobsEntity.setModTime(new Date());
        try {
            jobsDAO.merge(jobsEntity);
            cloudContext.addSuccessMsg("插入数据成功！");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("更新数据错误：" + e.getMessage());
        }
    }

    public void delete(CloudContext<JobsEntity> cloudContext) {
        try {
            jobsDAO.delete(cloudContext.getVo().getId());
            cloudContext.addSuccessMsg("删除成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("删除数据错误：" + e.getMessage());
        }
    }

    public void query(CloudContext<JobsEntity> cloudContext) {
        try {
            cloudContext.addParam("jobses", jobsDAO.query());
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取数据错误：" + e.getMessage());
        }
    }

    public void initUpdate(CloudContext<JobsEntity> cloudContext) {
        try {
            JobsEntity jobs = PropertyManager.getInstance().getJobsMap().get(cloudContext.getVo().getId());
            jobs.setContent(jobs.getContent().replace("&nbsp;", " ").replace("<br/>", "\r\n"));
            cloudContext.setVo(jobs);
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误:" + e.getMessage());
        }
    }

}
