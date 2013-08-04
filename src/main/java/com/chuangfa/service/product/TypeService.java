package com.chuangfa.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.dao.TypeDAO;
import com.chuangfa.entity.TypeEntity;
import com.chuangfa.util.LogUtil;

@Service("typeService")
public class TypeService extends BaseService<TypeEntity> {

    @Resource
    private TypeDAO typeDAO;

    public void query(CloudContext<TypeEntity> cloudContext) {
        try {
            cloudContext.addParam("types", typeDAO.query());
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误：" + e.getMessage());
        }
    }
    
    public void insert(CloudContext<TypeEntity> cloudContext){
        try {
            typeDAO.merge(cloudContext.getVo());
            cloudContext.addSuccessMsg("添加成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据插入错误：" + e.getMessage());
        }
    }
    
    public void update(CloudContext<TypeEntity> cloudContext){
        try {
            typeDAO.merge(cloudContext.getVo());
            cloudContext.addSuccessMsg("修改成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误：" + e.getMessage());
        }
    }
    
    public void delete(CloudContext<TypeEntity> cloudContext){
        try {
            typeDAO.delete(cloudContext.getVo().getId());
            cloudContext.addSuccessMsg("删除成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误：" + e.getMessage());
        }
    }
}
