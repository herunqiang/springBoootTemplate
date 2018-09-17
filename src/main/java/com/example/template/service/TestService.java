package com.example.template.service;

import com.example.template.common.entity.SysUser;
import com.example.template.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;

@Service
public class TestService {
    @Autowired
    private SysUserMapper sysUserMapper;
    public List<SysUser> test1() {
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        return sysUsers;
    }
}
