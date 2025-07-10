package com.skyline.configure.elastisearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

// @Configuration
public class ElasticsearchConfig {

//    @Autowired
//    ElasticsearchClient elasticsearchClient;

//    @Bean
//    public RestHighLevelClient client() {
//        ClientConfiguration clientConfiguration
//                = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build();
//
//        return RestClients.create(clientConfiguration).rest();
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchRestTemplate(client());
//    }

//    @Override
//    public ClientConfiguration clientConfiguration() {
//        HttpHeaders defaultHeaders = new HttpHeaders();
//        defaultHeaders.add("skyline", "home");
//
//        return  ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .usingSsl()
//                .withConnectTimeout(Duration.ofSeconds(5))
//                .withSocketTimeout(Duration.ofSeconds(3))
//                .withDefaultHeaders(defaultHeaders)
//                .withBasicAuth("elastic", "fpF8hRUDfaZZxz1OjlOi")
//                .withHeaders(() -> {
//                    HttpHeaders headers = new HttpHeaders();
//                    headers.add("currentTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//                    return headers;
//                })
//                .withClientConfigurer(
//                        ElasticsearchClients.ElasticsearchHttpClientConfigurationCallback.from(clientBuilder -> {
//                            return clientBuilder;
//                        }))
//                .build();
//    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchTemplate(elasticsearchClient);
//    }

}
