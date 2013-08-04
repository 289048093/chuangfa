package com.chuangfa.action.contactour;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.CloudContext;
import com.chuangfa.action.IndexAction;
import com.chuangfa.entity.ContactOurEntity;
import com.chuangfa.entity.MenuEntity;
import com.chuangfa.service.IndexService;
import com.chuangfa.service.contactour.ContactOurService;

@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/contactOurManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/contactour/contactour.jsp"),
                @Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
                @Result(name = "initSubshop", type = "dispatcher", location = "/contactour/updateSubshop.jsp"),
                @Result(name = "init", type = "dispatcher", location = "/contactour/updateContactour.jsp") })
public class ContactOurAction extends BaseAction<ContactOurEntity> {

    /**
     * 
     */
    private static final long serialVersionUID = 2196502086531069525L;

    @Resource
    private ContactOurService contactOurService;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/contactOur")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    public String query() {
        contactOurService.query(cloudContext);
        return SUCCESS;
    }

    public String update() {
        contactOurService.update(cloudContext);
        return JUMP;
    }
    public String initUpdate(){
        contactOurService.query(cloudContext);
        return INIT;
    }
    
    public String insertSubshop(){
        contactOurService.insertSubshop(cloudContext);
        return JUMP;
    }
    
    public String initUpdateSubshop(){
        contactOurService.initUpdateSubshop(cloudContext);
        return "initSubshop";
    }
    
    public String updateSubshop(){
        contactOurService.updateSubshop(cloudContext);
        return JUMP;
    }
    
    public String deleteSubshop(){
        contactOurService.deleteSubshop(cloudContext);
        return JUMP;
    }
}
