package com.example.today.controller;

import org.apache.tomcat.jni.Time;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
public class TestRestController {

private final AsyncRestTemplate asyncRestTemplate;

    public TestRestController(AsyncRestTemplate asyncRestTemplate) {
        this.asyncRestTemplate = asyncRestTemplate;
    }

    @GetMapping("/testRestemplate")
    public  void test(){
        long start = System.currentTimeMillis();
        HttpHeaders requestHeaders  = new HttpHeaders();
//        requestHeaders.set("X-Token","60b99a6d248c72398cd1cb0d");
        HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);
        ListenableFuture<ResponseEntity<Object>> response = asyncRestTemplate.exchange(
                "http://ibss.wasumedia.cn:8080/ibss_ol/getProgramList?channelId=1", HttpMethod.GET, requestEntity, Object.class

        );
        response.addCallback(new ListenableFutureCallback<ResponseEntity<Object>>() {

            @Override
            public void onSuccess(ResponseEntity<Object> objectResponseEntity) {
                Object body = objectResponseEntity.getBody();
                System.out.println("body"+body);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
        if(response!=null){
            System.out.println(response);
        }
        long end = System.currentTimeMillis();
        System.out.println(end -start);

    }
    private static Object  o=new Object();
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("加锁后-------------------------");
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }

}
