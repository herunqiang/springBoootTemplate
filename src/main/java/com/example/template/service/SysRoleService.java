package com.example.template.service;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

public interface SysRoleService {
    Set<String> findRoleNameByUserId(int userId);
}
