package com.example.template.service.impl;

import com.example.template.common.entity.SysUser;
import com.example.template.mapper.SysUserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTest {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    SysUserMapper sysUserMapper;

    @Cacheable(value = "test",key = "1")
    public SysUser test1(SysUser sysUser){
        SysUser user = sysUserMapper.selectOne(sysUser);
        return user;
    }

}
