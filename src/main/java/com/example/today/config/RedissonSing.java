//package com.example.today.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RAtomicLong;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.core.io.FileSystemResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//
//import java.io.File;
//import java.io.IOException;
//
//
//public class RedissonSing {
//    public void connection() throws IOException {
//        // 1. Create config object
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://47.97.204.53:6379");
//
//    // or read config from file
////        ResourceLoader resourceLoader = new FileSystemResourceLoader();
////        Resource resource = resourceLoader.getResource("classpath:redisson.yml");
////        config = Config.fromYAML(resource.getInputStream());
//        RedissonClient redisson = Redisson.create(config);
//        RAtomicLong longObject = redisson.getAtomicLong("myLong");
//// 同步执行方式
//        longObject.set(2);
//        longObject.compareAndSet(2,8);
//        longObject.compareAndSet(2,6);
//        redisson.shutdown();
//    }
//
//    public static void main(String[] args) throws IOException {
//        new RedissonSing().connection();
//    }
//}
