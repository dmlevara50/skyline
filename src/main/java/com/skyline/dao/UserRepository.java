package com.skyline.dao;

import com.skyline.dao.interfaces.oracle.IUserRepository;
import com.skyline.entity.oracle.UserEntity;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    //Injected with DI
    @Resource
    private EntityManagerFactory emf;

    @Override
    public void persist(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    public List<UserEntity> find(UserEntity userEntityFilter) {
        try {
            entityManager =  emf.createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
            Root<UserEntity> user = cq.from(UserEntity.class);
            if (userEntityFilter != null && userEntityFilter.getName() != null) {

            }
            cq.select(user);
            return entityManager.createQuery(cq).getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<UserEntity> find(String hql) {
        return List.of();
    }
}
