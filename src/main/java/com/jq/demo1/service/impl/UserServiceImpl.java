package com.jq.demo1.service.impl;

import com.jq.demo1.dao.UserDOMapper;
import com.jq.demo1.dao.UserPasswordDOMapper;
import com.jq.demo1.dataObject.UserDO;
import com.jq.demo1.dataObject.UserPasswordDO;
import com.jq.demo1.service.UserService;
import com.jq.demo1.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jq
 * @Date: 2019/1/17 11:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;
    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if(userDO == null) return null;
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        UserModel userModel = getUserModel(userDO, userPasswordDO);
        return userModel;
    }

    private UserModel getUserModel(UserDO userDO, UserPasswordDO userPasswordDO) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if(userPasswordDO!=null) {
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
