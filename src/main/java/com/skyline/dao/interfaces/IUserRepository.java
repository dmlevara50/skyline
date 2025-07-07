package com.skyline.dao.interfaces;

import com.skyline.entity.UserEntity;

import java.io.Serializable;
import java.util.List;

public interface IUserRepository {

    public void persist(UserEntity userEntity);

    public List<UserEntity> find(UserEntity userEntity);

    public List<UserEntity> find(String hql);
}
