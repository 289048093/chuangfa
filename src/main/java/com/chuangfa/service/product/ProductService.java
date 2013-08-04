package com.chuangfa.service.product;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.PropertyManager;
import com.chuangfa.dao.ProductDAO;
import com.chuangfa.dao.TypeDAO;
import com.chuangfa.entity.ProductEntity;
import com.chuangfa.entity.TypeEntity;
import com.chuangfa.util.CompressPicUtil;
import com.chuangfa.util.LogUtil;

@Service("productService")
public class ProductService extends BaseService<ProductEntity> {

    /**
     * 
     */
    private static final long serialVersionUID = 204250571294410465L;
    @Resource
    private ProductDAO productDAO;
    @Resource
    private TypeDAO typeDAO;

    public void query(CloudContext<ProductEntity> cloudContext) {
        try {
            cloudContext.addParam("products", productDAO.query(cloudContext.getIntegerParam("typeId")));
            cloudContext.addParam("types", typeDAO.query());
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据获取错误：" + e.getMessage());
        }
    }

    public void insert(CloudContext<ProductEntity> cloudContext) {
        if (cloudContext.getVo().getId() == null) {
            cloudContext.getVo().setAddTime(new Date());
        }
        if (cloudContext.getVo().getProPic() != null) {
            generateHeadPic(cloudContext);
            generateRealPic(cloudContext);
        }
        try {
            productDAO.merge(cloudContext.getVo());
            cloudContext.addSuccessMsg("添加成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据插入错误：" + e.getMessage());
        }
    }

    private void generateHeadPic(CloudContext<ProductEntity> cloudContext) {
        CompressPicUtil mypic = new CompressPicUtil();
        String webRootPath = cloudContext.getStringParam("webRootPath");
        String proPic = cloudContext.getVo().getProPic();
        String headPic = "head_" + proPic;
        String srcDic = new File(webRootPath, "productImage").getAbsolutePath() + File.separator;
        String destDic = new File(webRootPath, "productHeadImage").getAbsolutePath() + File.separator;
        String widthStr = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_CHUANFA_PROHEADWIDTH);
        String heightStr = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_CHUANFA_PROHEADHEIGHT);
        int width = widthStr == null ? 90 : Integer.parseInt(widthStr);
        int height = heightStr == null ? 90 : Integer.parseInt(heightStr);
        if (mypic.compressPic(srcDic, destDic, proPic, headPic, width, height, true)) {
            cloudContext.getVo().setHeadPic(headPic);
        }
    }

    private void generateRealPic(CloudContext<ProductEntity> cloudContext) {
        CompressPicUtil mypic = new CompressPicUtil();
        String webRootPath = cloudContext.getStringParam("webRootPath");
        String proPic = cloudContext.getVo().getProPic();
        String srcDic = new File(webRootPath, "productImage").getAbsolutePath() + File.separator;
        String destDic = new File(webRootPath, "productRealImage").getAbsolutePath() + File.separator;
        String widthStr = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_CHUANFA_PROREALWIDTH);
        String heightStr = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_CHUANFA_PROREALHEIGHT);
        int width = widthStr == null ? 90 : Integer.parseInt(widthStr);
        int height = heightStr == null ? 90 : Integer.parseInt(heightStr);
        if (mypic.compressPic(srcDic, destDic, proPic, proPic, width, height, true)) {
        }
    }

    public void delete(CloudContext<ProductEntity> cloudContext) {
        try {
//            if (cloudContext.getVo().getHeadPic() != null) {
//                removeHeadPic(cloudContext, cloudContext.getVo());
//            }
            productDAO.delete(cloudContext.getVo().getId());
            cloudContext.addSuccessMsg("删除成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据删除错误：" + e.getMessage());
        }
    }

    public void update(CloudContext<ProductEntity> cloudContext) {
        try {
            ProductEntity oldPro = productDAO.get(cloudContext.getVo().getId());
            if (!oldPro.getProPic().equals(cloudContext.getVo().getProPic())) {
                //removeHeadPic(cloudContext, oldPro);
                generateHeadPic(cloudContext);
                generateRealPic(cloudContext);
            }
            productDAO.merge(cloudContext.getVo());
            cloudContext.addSuccessMsg("修改成功");
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("数据更新错误：" + e.getMessage());
        }
    }

//    private boolean removeHeadPic(CloudContext<ProductEntity> cloudContext, ProductEntity product) {
//        if (product.getHeadPic() == null) {
//            return false;
//        }
//        String webRootPath = cloudContext.getStringParam("webRootPath");
//        String destDic = new File(webRootPath, "productHeadImage").getAbsolutePath();
//        return new File(destDic, product.getHeadPic()).delete();
//    }

    public void init(CloudContext<ProductEntity> cloudContext) {
        Integer id = cloudContext.getVo().getId();
        if (id != null) {
            try {
                cloudContext.setVo(productDAO.get(id));
            } catch (Exception e) {
                LogUtil.error(e);
                cloudContext.addErrorMsg("获取产品数据错误：" + e.getMessage());
                return;
            }
        }
        try {
            List<TypeEntity> ts = typeDAO.query();
            cloudContext.addParam("types", ts == null ? new ArrayList<TypeEntity>() : ts);
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取产品类型错误：" + e.getMessage());
        }
    }

    public void productDetail(CloudContext<ProductEntity> cloudContext) {
        Integer proId = cloudContext.getVo().getId();
        if (proId == null) {
            cloudContext.addErrorMsg("id为空，不能查询相关信息");
        }
        List<TypeEntity> types = null;
        try {
            types = typeDAO.query();
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取产品类型错误：" + e.getMessage());
            return;
        }
        for (TypeEntity type : types) {
            try {
                type.setProEntitys(new HashSet<ProductEntity>(productDAO.query(type.getId())));
            } catch (Exception e) {
                LogUtil.error(e);
                cloudContext.addErrorMsg("获取类型" + type.getName() + "的产品错误：" + e.getMessage());
                return;
            }
        }
        cloudContext.addParam("types", types);
        try {
            cloudContext.setVo(productDAO.get(proId));
        } catch (Exception e) {
            LogUtil.error(e);
            cloudContext.addErrorMsg("获取产品详细信息错误：" + e.getMessage());
            return;
        }
    }
}
