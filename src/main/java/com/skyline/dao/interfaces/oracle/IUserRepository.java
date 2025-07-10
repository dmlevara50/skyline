package com.skyline.dao.interfaces.oracle;

import com.skyline.entity.oracle.UserEntity;

import java.util.List;

public interface IUserRepository {

    public void persist(UserEntity userEntity);

    public List<UserEntity> find(UserEntity userEntity);

    public List<UserEntity> find(String hql);
}
