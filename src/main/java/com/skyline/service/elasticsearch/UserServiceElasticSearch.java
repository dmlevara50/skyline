package com.skyline.service.elasticsearch;

import com.skyline.dao.interfaces.elasticsearch.UserRepositoryElasticSearch;
import com.skyline.entity.elasticsearch.UserElasticSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceElasticSearch {

    @Autowired
    UserRepositoryElasticSearch userRepositoryElasticSearch;

    public List<UserElasticSearchDTO> findAll() {
        List<UserElasticSearchDTO> usersAll = new ArrayList<>();
        Iterable<UserElasticSearchDTO> users = userRepositoryElasticSearch.findAll();
        while (users.iterator().hasNext()) {
            usersAll.add(users.iterator().next());
        }
        return usersAll;
    }

    public List<UserElasticSearchDTO> findAllByName(String name) {
        List<UserElasticSearchDTO> usersAll = new ArrayList<>();
        if (name != null) {
            Iterable<UserElasticSearchDTO> users = userRepositoryElasticSearch.findAll();
            while (users.iterator().hasNext()) {
                UserElasticSearchDTO userElasticSearchDTO = users.iterator().next();
                if (name.equals(userElasticSearchDTO.getName())) {
                    usersAll.add(users.iterator().next());
                }
            }
        }

        return usersAll;
    }

    public UserElasticSearchDTO saveUser(UserElasticSearchDTO userElasticSearchDTO) {
        userRepositoryElasticSearch.save(userElasticSearchDTO);
        return userElasticSearchDTO;
    }

    public UserElasticSearchDTO findById(String id) {
        Optional<UserElasticSearchDTO> user = userRepositoryElasticSearch.findById(id);
        return user.orElse(null);
    }

    public UserElasticSearchDTO save(UserElasticSearchDTO userElasticSearchDTO) {
        return userRepositoryElasticSearch.save(userElasticSearchDTO);
    }
}
