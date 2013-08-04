package com.chuangfa.service.comdesc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.dao.ComdescDAO;
import com.chuangfa.entity.ComdescEntity;
import com.chuangfa.util.LogUtil;
import com.chuangfa.util.ProjectUtil;

@Service("comdescService")
public class ComdescService extends BaseService<ComdescEntity> {

    @Resource
    private ComdescDAO comdescDAO;

    public void update(CloudContext<ComdescEntity> cloudContext) {
        ComdescEntity ce = cloudContext.getVo();
        try {
            ce.setContent(ProjectUtil.processContent(ce.getContent()));
            comdescDAO.merge(ce);
            cloudContext.addSuccessMsg("修改成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据保存错误：" + e.getMessage());
        }
    }

    public void initUpdate(CloudContext<ComdescEntity> cloudContext) {
        try {
            ComdescEntity ce = comdescDAO.getComdesc();
            ce.setContent(ProjectUtil.reProcessContent(ce.getContent()));
            cloudContext.setVo(ce);
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误：" + e.getMessage());
        }
    }

    public void query(CloudContext<ComdescEntity> cloudContext) {
        try {
            cloudContext.setVo(comdescDAO.getComdesc());
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误：" + e.getMessage());
        }
    }

}
