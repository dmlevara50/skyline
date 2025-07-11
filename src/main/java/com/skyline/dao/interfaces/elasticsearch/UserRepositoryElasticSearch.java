package com.skyline.dao.interfaces.elasticsearch;

import com.skyline.entity.elasticsearch.UserElasticSearchDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface UserRepositoryElasticSearch extends ElasticsearchRepository<UserElasticSearchDTO, String> {

    UserElasticSearchDTO save(UserElasticSearchDTO userElasticSearchDTO);
}
