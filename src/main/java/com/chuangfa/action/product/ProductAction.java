package com.chuangfa.action.product;

import java.io.File;
import java.net.MalformedURLException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.entity.ProductEntity;
import com.chuangfa.service.product.ProductService;

@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/productManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/product/product.jsp"),
        @Result(name = "jump", type = "dispatcher", location = "/jump.jsp"),
        @Result(name = "init", type = "dispatcher", location = "/product/addOrUpdateProduct.jsp"),
        @Result(name = "detail", type = "dispatcher", location = "/product/productDetail.jsp") })
public class ProductAction extends BaseAction<ProductEntity> {

    /**
     * 
     */
    private static final long serialVersionUID = -8865644342782173765L;

    @Resource
    private ProductService productService;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/product")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    public String query() {
        productService.query(cloudContext);
        return SUCCESS;
    }

    public String insert() {
        cloudContext.addParam("webRootPath", getSession().getServletContext().getRealPath("/"));
        productService.insert(cloudContext);
        return JUMP;
    }

    public String delete() {
        cloudContext.addParam("webRootPath", getSession().getServletContext().getRealPath("/"));
        productService.delete(cloudContext);
        return JUMP;
    }

    public String update() {
        cloudContext.addParam("webRootPath", getSession().getServletContext().getRealPath("/"));
        productService.update(cloudContext);
        return JUMP;
    }

    public String init() {
        productService.init(cloudContext);
        return INIT;
    }

    public String productDetail() {
        productService.productDetail(cloudContext);
        return "detail";
    }
}
