/**
 * 
 */
package com.zaichiyikou.starter.pojo;

import java.sql.Date;


/**
 * @author ASUS
 *
 */

public class SysRole {
    
    // 初步体验
    private Long id;
    private String name;
    private String remark;
    private String available;
    private Date createtime;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getAvailable() {
        return available;
    }
    public void setAvailable(String available) {
        this.available = available;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public SysRole(Long id, String name, String remark, String available, Date createtime) {
        super();
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.available = available;
        this.createtime = createtime;
    }
    public SysRole() {
        super();
    }
    
    
    
}
