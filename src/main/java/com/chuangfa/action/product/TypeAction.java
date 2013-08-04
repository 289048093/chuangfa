package com.chuangfa.action.product;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.entity.TypeEntity;
import com.chuangfa.service.product.TypeService;

@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/typeManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/product/type.jsp"),
        @Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
        @Result(name = "init", type = "dispatcher", location = "/product/initUpdateType.jsp"),
        @Result(name = "detail", type = "dispatcher", location = "/product/TypeDetail.jsp") })
public class TypeAction extends BaseAction<TypeEntity> {

    /**
     * 
     */
    private static final long serialVersionUID = -3329373857245339505L;

    @Resource
    private TypeService typeService;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/type")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    public String query() {
        typeService.query(cloudContext);
        return SUCCESS;
    }

    public String insert() {
        typeService.insert(cloudContext);
        return JUMP;
    }

    public String update() {
        typeService.update(cloudContext);
        return JUMP;
    }

    public String delete() {
        typeService.delete(cloudContext);
        return JUMP;
    }
}
