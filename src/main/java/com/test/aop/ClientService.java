package com.test.aop;

public class ClientService {
    private static ClientService clientService=new ClientService();
    private ClientService(){

    }
    public static ClientService creatInstance(){
        return clientService;
    }
    public void imFactoryMethod(){
        System.out.println("imFactoryMethod");
    }

    public static interface People {
        String getType();
    }
}
