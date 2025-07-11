package com.skyline.dao.interfaces.oracle;

import com.skyline.entity.oracle.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findAllByName(String name);

}
