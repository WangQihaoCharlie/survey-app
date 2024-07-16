package com.lepton.surveyauth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lepton.surveyauth.entity.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("SELECT * FROM user where username = #{username}")
    User getByUsername(String username);

}
