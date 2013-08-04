package com.chuangfa.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.chuangfa.BaseDAO;
import com.chuangfa.PropertyManager;
import com.chuangfa.entity.ProductEntity;
import com.chuangfa.entity.TypeEntity;
import com.chuangfa.util.ProjectUtil;

@Repository("productDAO")
public class ProductDAO extends BaseDAO {
    @Resource
    private TypeDAO typeDAO;

    public List<ProductEntity> query(Integer typeId) throws Exception {
        return PropertyManager.getInstance().queryProducts(typeId);
    }

    public void merge(ProductEntity pro) throws Exception {
        Map<Integer, ProductEntity> map = getFileObj();
        if (pro.getId() == null) {
            pro.setId(PropertyManager.getInstance().generateId());
            addPro2Type(pro);
            if (pro.getTopIndex() != 0) {//加入热门产品
                mergeTopPro(pro);
            }
        } else {
            pro.setAddTime(map.get(pro.getId()).getAddTime());
            ProductEntity oldPro = map.get(pro.getId());
            if (oldPro.getTypeId() != pro.getTypeId() || !oldPro.getTypeId().equals(pro.getTypeId())) {
                //更新type的pro
                if (oldPro.getTypeId() != null) {
                    delPro2Type(oldPro);
                }
                if (pro.getTypeId() != null) {
                    addPro2Type(pro);
                }
            }
            if (pro.getTopIndex() != oldPro.getTopIndex()) {
                TreeMap<Integer, Integer> treeMap = PropertyManager.getInstance().getTopProMap();
                if (treeMap.remove(oldPro.getTopIndex()) != null) {
                    ProjectUtil.writeObject2File(treeMap, TreeMap.class);
                }
                mergeTopPro(pro);
            }
        }
        map.put(pro.getId(), pro);
        ProjectUtil.writeObject2File(map, ProductEntity.class);
    }

    /**
     * 插入热门产品
     * 
     * @param pro
     * @throws Exception
     */
    private void mergeTopPro(ProductEntity pro) throws Exception {
        TreeMap<Integer, Integer> treeMap = PropertyManager.getInstance().getTopProMap();
        Integer oldId = treeMap.get(pro.getTopIndex());
        ProductEntity oldTopPro = oldId == null ? null : get(oldId);
        if (oldTopPro != null) {
            oldTopPro.setTopIndex(0);
            //merge(oldTopPro);
            Map<Integer, ProductEntity> mapBuf = getFileObj();
            mapBuf.put(oldTopPro.getId(), oldTopPro);
            ProjectUtil.writeObject2File(mapBuf, ProductEntity.class);
        }
        treeMap.put(pro.getTopIndex(), pro.getId());
        //如果到达设定上限
        if (treeMap.size() > Integer.parseInt(PropertyManager.getInstance().getXMLProperty(
                PropertyManager.XML_CHUANGFA_TOPPRODUCTSIZE))) {
            ProductEntity oldLastPro = get(treeMap.get(treeMap.lastKey()));
            oldLastPro.setTopIndex(0);
            merge(oldLastPro);
            treeMap.remove(treeMap.lastKey());
        }
        ProjectUtil.writeObject2File(treeMap, TreeMap.class);
    }

    private void addPro2Type(ProductEntity pro) throws Exception {
        if (pro.getTypeId() != null) {
            TypeEntity type = typeDAO.get(pro.getTypeId());
            if (type.getProducts() == null) {
                type.setProducts(new HashSet<Integer>());
            }
            type.getProducts().add(pro.getId());
            typeDAO.merge(type);
        }
    }

    private void delPro2Type(ProductEntity pro) throws Exception {
        if (pro.getTypeId() != null) {
            TypeEntity oldType = typeDAO.get(pro.getTypeId());
            oldType.getProducts().remove(pro.getId());
            typeDAO.merge(oldType);
        }
    }

    public void delete(Integer id) throws Exception {
        Map<Integer, ProductEntity> map = getFileObj();
        ProductEntity pro = map.get(id);
        if (pro.getId() == null) {
            pro.setId(PropertyManager.getInstance().generateId());
        }
        map.remove(id);
        delPro2Type(pro);
        ProjectUtil.writeObject2File(map, ProductEntity.class);
    }

    public ProductEntity get(Integer id) throws Exception {
        Map<Integer, ProductEntity> map = getFileObj();
        return map.get(id);
    }

    @SuppressWarnings("unchecked")
    private Map<Integer, ProductEntity> getFileObj() throws Exception {
        PropertyManager.getInstance().queryProducts(null);
        return PropertyManager.getInstance().products;
    }

}
