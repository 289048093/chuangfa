package com.chuangfa.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.chuangfa.BaseDAO;
import com.chuangfa.PropertyManager;
import com.chuangfa.entity.JobsEntity;
import com.chuangfa.util.ProjectUtil;

@Repository("jobsDAO")
public class JobsDAO extends BaseDAO {

    public void merge(JobsEntity jobsEntity) throws Exception {
        Map<Integer, JobsEntity> jobs = PropertyManager.getInstance().getJobsMap();
        JobsEntity oldJobs = jobs.get(jobsEntity.getId());
        if (oldJobs != null) {
            jobsEntity.setAddTime(oldJobs.getAddTime());
        }
        jobs.put(jobsEntity.getId(), jobsEntity);
        ProjectUtil.writeObject2File(jobs, JobsEntity.class);
    }

    public void delete(Integer id) throws Exception {
        Map<Integer, JobsEntity> jobs = PropertyManager.getInstance().getJobsMap();
        if (jobs.remove(id) != null) {
            ProjectUtil.writeObject2File(jobs, JobsEntity.class);
        }
    }

    public TreeSet<JobsEntity> query() throws Exception{
        Map<Integer, JobsEntity> jobs = PropertyManager.getInstance().getJobsMap();
        return new TreeSet<JobsEntity>(jobs.values());
    }
}
