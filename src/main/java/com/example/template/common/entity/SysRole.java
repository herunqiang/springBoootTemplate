package com.example.template.common.entity;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "role_desc")
    private String roleDesc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return role_desc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}