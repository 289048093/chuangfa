package com.chuangfa.dao;

import org.springframework.stereotype.Repository;

import com.chuangfa.BaseDAO;
import com.chuangfa.PropertyManager;
import com.chuangfa.entity.ContactOurEntity;
import com.chuangfa.entity.SubshopInfoEntity;
import com.chuangfa.util.ProjectUtil;

@Repository("contactOurDAO")
public class ContactOurDAO extends BaseDAO {

    public ContactOurEntity get() throws Exception {
        return PropertyManager.getInstance().obtainOurInfo();
    }

    public void update(ContactOurEntity coe) throws Exception {
        ProjectUtil.writeObject2File(coe, ContactOurEntity.class);
    }

    public void mergeSubShop(SubshopInfoEntity ssie) throws Exception {
        ContactOurEntity coe = get();
        coe.getSubShops().put(ssie.getId(), ssie);
        ProjectUtil.writeObject2File(coe, ContactOurEntity.class);
    }

    public void merge(ContactOurEntity vo) throws Exception {
        ContactOurEntity coe = PropertyManager.getInstance().obtainOurInfo();
        coe.setAddr(vo.getAddr());
        coe.setComName(vo.getComName());
        coe.setCooperationTel(vo.getCooperationTel());
        coe.setEmail(vo.getEmail());
        coe.setServiceTel(vo.getServiceTel());
        coe.setWorkTime(vo.getWorkTime());
        ProjectUtil.writeObject2File(coe, ContactOurEntity.class);
    }

    public void deleteSubshop(Integer subshopId) throws Exception {
        ContactOurEntity coe = PropertyManager.getInstance().obtainOurInfo();
        coe.getSubShops().remove(subshopId);
        ProjectUtil.writeObject2File(coe, ContactOurEntity.class);
    }
}
