package com.chuangfa.dao;

import org.springframework.stereotype.Repository;

import com.chuangfa.BaseDAO;
import com.chuangfa.entity.ComdescEntity;
import com.chuangfa.util.ProjectUtil;

@Repository("comdescDAO")
public class ComdescDAO extends BaseDAO {

    public void merge(ComdescEntity ce) throws Exception {
        ProjectUtil.writeObject2File(ce, ComdescEntity.class);
    }

    public ComdescEntity getComdesc() throws Exception {
        ComdescEntity com = (ComdescEntity) ProjectUtil.getObjectFromFile(ComdescEntity.class);
        return com == null ? new ComdescEntity() : com;
    }

}
