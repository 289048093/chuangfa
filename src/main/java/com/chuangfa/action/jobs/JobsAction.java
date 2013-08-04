package com.chuangfa.action.jobs;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.entity.JobsEntity;
import com.chuangfa.service.jobs.JobsService;

@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/jobsManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/forjob/forjob.jsp"),
        @Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
        @Result(name = "init", type = "dispatcher", location = "/forjob/initUpdate.jsp") })
public class JobsAction extends BaseAction<JobsEntity> {

    @Resource
    private JobsService jobsService;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/jobs")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    public String query() {
        jobsService.query(cloudContext);
        return SUCCESS;
    }

    public String insert() {
        jobsService.insert(cloudContext);
        return JUMP;
    }

    public String update() {
        jobsService.update(cloudContext);
        return JUMP;
    }

    public String initUpdate() {
        jobsService.initUpdate(cloudContext);
        return INIT;
    }

    public String delete() {
        jobsService.delete(cloudContext);
        return JUMP;
    }
}
