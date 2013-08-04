package com.chuangfa.service.contactour;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.PropertyManager;
import com.chuangfa.dao.ContactOurDAO;
import com.chuangfa.entity.ContactOurEntity;
import com.chuangfa.entity.SubshopInfoEntity;
import com.chuangfa.util.LogUtil;

@Service("contactOurService")
public class ContactOurService extends BaseService<ContactOurEntity> {
    @Resource
    private ContactOurDAO contactOurDAO;

    public void query(CloudContext<ContactOurEntity> cloudContext) {
        try {
            cloudContext.setVo(contactOurDAO.get());
            cloudContext.addParam("subshops", cloudContext.getVo().getSubShops().values());
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取数据错误：" + e.getMessage());
        }
    }

    public void update(CloudContext<ContactOurEntity> cloudContext) {
        try {
            contactOurDAO.merge(cloudContext.getVo());
            cloudContext.addSuccessMsg("修改成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("更新数据错误：" + e.getMessage());
        }
    }

    public void insertSubshop(CloudContext<ContactOurEntity> cloudContext) {
        SubshopInfoEntity subshop = new SubshopInfoEntity();
        subshop.setId(PropertyManager.getInstance().generateId());
        subshop.setAddr(cloudContext.getStringParam("addr"));
        subshop.setContacter(cloudContext.getStringParam("contacter"));
        subshop.setName(cloudContext.getStringParam("name"));
        subshop.setTelphone(cloudContext.getStringParam("telphone"));
        try {
            contactOurDAO.mergeSubShop(subshop);
            cloudContext.addSuccessMsg("分店添加成功！");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("新增分店数据错误：" + e.getMessage());
        }
    }

    public void initUpdateSubshop(CloudContext<ContactOurEntity> cloudContext) {
        try {
            cloudContext.addParam("subshop", PropertyManager.getInstance().obtainOurInfo().getSubShops().get(
                    cloudContext.getIntegerParam("subshopId")));
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取分店数据错误：" + e.getMessage());
        }
    }

    public void updateSubshop(CloudContext<ContactOurEntity> cloudContext) {
        SubshopInfoEntity subshop = new SubshopInfoEntity();
        subshop.setAddr(cloudContext.getStringParam("addr"));
        subshop.setContacter(cloudContext.getStringParam("contacter"));
        subshop.setName(cloudContext.getStringParam("name"));
        subshop.setTelphone(cloudContext.getStringParam("telphone"));
        try {
           //if(1==1) return;
            contactOurDAO.mergeSubShop(subshop);
            cloudContext.addSuccessMsg("分店更新成功！");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("更新分店数据错误：" + e.getMessage());
        }
    }

    public void deleteSubshop(CloudContext<ContactOurEntity> cloudContext) {
        try {
            contactOurDAO.deleteSubshop(cloudContext.getIntegerParam("subshopId"));
            cloudContext.addSuccessMsg("删除成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("删除分店数据错误：" + e.getMessage());
        }
    }
}
