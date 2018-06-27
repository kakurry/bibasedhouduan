package com.example.bibasedhouduan.javabean;

import java.util.Date;

public class YudingMst {
    private String id;

    private String chepaihao;

    private Date yudingtime;

    private String description;

    private String name;

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

    public Date getYudingtime() {
        return yudingtime;
    }

    public void setYudingtime(Date yudingtime) {
        this.yudingtime = yudingtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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