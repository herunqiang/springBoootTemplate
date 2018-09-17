package com.example.template.mapper;

import com.example.template.common.entity.SysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
@org.apache.ibatis.annotations.Mapper
public interface SysUserMapper extends Mapper<SysUser> {
}