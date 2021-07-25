package com.example.today.config;

import com.example.today.service.HotSwappable;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Autowired
    private HotSwappable byeHotSwappableImpl;

    @Autowired
    private HotSwappable hotSwappableImpl;
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
//    AsyncRestTemplate
    @Bean
    public AsyncRestTemplate getAsyncRestTemplate() {
        return new AsyncRestTemplate();
    }
    @Bean
    public HotSwappableTargetSource swappableTargetSource(){
        HotSwappableTargetSource hotSwappableTargetSource = new HotSwappableTargetSource(hotSwappableImpl);
//        hotSwappableImpl.hello();
        return hotSwappableTargetSource;
    }
    @Bean
    public ProxyFactoryBean person() throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyInterfaces(new Class[]{HotSwappable.class});
//        HotSwappable oldTarget  =(HotSwappable) swappableTargetSource().swap(byeHotSwappableImpl);
        proxyFactoryBean.setTargetSource(swappableTargetSource());
        return proxyFactoryBean;
    }
}
