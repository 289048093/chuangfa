package com.chuangfa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.chuangfa.BaseDAO;
import com.chuangfa.PropertyManager;
import com.chuangfa.entity.ProductEntity;
import com.chuangfa.entity.TypeEntity;
import com.chuangfa.util.ProjectUtil;

@Repository("typeDAO")
public class TypeDAO extends BaseDAO {
    @Resource
    private ProductDAO productDAO;

    public List<TypeEntity> query() throws Exception {
        return new ArrayList<TypeEntity>(PropertyManager.getInstance().getTypesMap().values());
    }

    public TypeEntity get(Integer id) throws Exception {
        if (PropertyManager.getInstance().types == null) {
            PropertyManager.getInstance().queryTypes();
        }
        return PropertyManager.getInstance().types.get(id);
    }

    public void merge(TypeEntity type) throws Exception {
        Map<Integer, TypeEntity> map = getFileObj();
        if (type.getId() == null) {
            type.setId(PropertyManager.getInstance().generateId());
        }
        map.put(type.getId(), type);
        ProjectUtil.writeObject2File(map, TypeEntity.class);
    }

    public void delete(Integer id) throws Exception {
        Map<Integer, TypeEntity> map = getFileObj();
        List<ProductEntity> pros = PropertyManager.getInstance().queryProducts(id);
        if (pros != null) {
            for (ProductEntity pro : pros) {
                pro.setTypeId(null);
                productDAO.merge(pro);
            }
        }
        map.remove(id);
        ProjectUtil.writeObject2File(map, TypeEntity.class);
    }

    @SuppressWarnings("unchecked")
    private Map<Integer, TypeEntity> getFileObj() throws Exception {
        PropertyManager.getInstance().queryTypes();
        return PropertyManager.getInstance().getTypesMap();
    }
}
