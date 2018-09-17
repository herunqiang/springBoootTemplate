package com.example.template.mapper;

import com.example.template.common.entity.SysResources;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface SysResourcesMapper extends Mapper<SysResources> {
    @ResultMap(value = "BaseResultMap")
    @Select("SELECT * FROM sys_resources ")
    List<SysResources> selectAll();

    @Select("SELECT sre.res_url FROM sys_user_role sur LEFT JOIN sys_user su ON su.id = sur.user_id " +
            "LEFT JOIN sys_role sr ON sur.role_id=sr.id LEFT JOIN sys_role_resources srr ON sur.role_id = srr.role_id " +
            "LEFT JOIN sys_resources sre ON sre.id = srr.resources_id " +
            "WHERE su.id=#{userId}")
    Set<String> findRoleNameByUserId(@Param("userId") int userId);
}