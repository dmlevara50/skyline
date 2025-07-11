package com.skyline.dao.interfaces.oracle;

import com.skyline.entity.oracle.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRespository extends JpaRepository<RolEntity, String> {
}
