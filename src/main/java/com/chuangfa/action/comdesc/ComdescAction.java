package com.chuangfa.action.comdesc;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.entity.ComdescEntity;
import com.chuangfa.service.comdesc.ComdescService;

@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/comdescManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/comdesc/comdesc.jsp"),
        @Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
        @Result(name = "init", type = "dispatcher", location = "/comdesc/initUpdate.jsp") })
public class ComdescAction extends BaseAction<ComdescEntity> {

    /**
     * 
     */
    private static final long serialVersionUID = 4275046394689877029L;

    @Resource
    private ComdescService comdescService;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/comdesc")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    public String update() {
        comdescService.update(cloudContext);
        return JUMP;
    }

    public String initUpdate() {
        comdescService.initUpdate(cloudContext);
        return INIT;
    }

    public String query() {
        comdescService.query(cloudContext);
        return SUCCESS;
    }
}
