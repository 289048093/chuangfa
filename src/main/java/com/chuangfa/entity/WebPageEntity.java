package com.chuangfa.entity;

import java.io.Serializable;
import java.util.Map;

import com.chuangfa.BaseEntity;

public class WebPageEntity extends BaseEntity implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 8833074435590650885L;

    private String logoPic;
    
    private String indexPic;
    
    private Map<String, String> links;

    public String getLogoPic() {
        return logoPic;
    }

    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    public String getIndexPic() {
        return indexPic;
    }

    public void setIndexPic(String indexPic) {
        this.indexPic = indexPic;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }
}
