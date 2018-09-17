package com.example.template.mapper;

import com.example.template.common.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;
@org.apache.ibatis.annotations.Mapper
@Repository
public interface SysRoleMapper extends Mapper<SysRole> {
    @Select("SELECT sr.role_desc FROM sys_user_role sur LEFT JOIN sys_role sr ON sr.id = sur.role_id \n" +
            "LEFT JOIN sys_user su ON sur.user_id = su.id WHERE su.id = #{userId}")
    Set<String> findRoleNameByUserId(@Param("userId") int userId);
}