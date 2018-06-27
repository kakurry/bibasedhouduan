package com.example.bibasedhouduan.javabean;

import java.util.Date;

public class CarshiyongMst {
    private String id;

    private String chepaihao;

    private String name;

    private Date starttime;

    private Date endtime;

    private String yiruku;

    private String allchewei;

    private Date createtime;

    private Date updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChepaihao() {
        return chepaihao;
    }

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao == null ? null : chepaihao.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getYiruku() {
        return yiruku;
    }

    public void setYiruku(String yiruku) {
        this.yiruku = yiruku == null ? null : yiruku.trim();
    }

    public String getAllchewei() {
        return allchewei;
    }

    public void setAllchewei(String allchewei) {
        this.allchewei = allchewei == null ? null : allchewei.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}