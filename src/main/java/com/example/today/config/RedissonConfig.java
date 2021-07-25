//package com.example.today.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.spring.cache.CacheConfig;
//import org.redisson.spring.cache.RedissonSpringCacheManager;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@ComponentScan
//@EnableCaching
//public  class RedissonConfig {
//
//    @Bean(destroyMethod="shutdown")
//    RedissonClient redisson() throws IOException {
//        Config config = new Config();
//        config.useClusterServers()
//                .addNodeAddress("47.97.204.53:6379");
//        return Redisson.create(config);
//    }
//
//    @Bean
//    CacheManager cacheManager(RedissonClient redissonClient) {
//        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
//        // 创建一个名称为"testMap"的缓存，过期时间ttl为24分钟，同时最长空闲时maxIdleTime为12分钟。
//        config.put("testMap", new CacheConfig(24*60*1000, 12*60*1000));
//        return new RedissonSpringCacheManager(redissonClient, config);
//    }
//
//}
//
