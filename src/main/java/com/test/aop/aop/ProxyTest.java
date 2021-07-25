package com.test.aop.aop;

import com.test.aop.ClientService;
import com.test.aop.aop.CustermJdk;
import com.test.aop.aop.Man;

public class ProxyTest {
    public static void main(String[] args) {
        Man man = new Man();
        CustermJdk custermJdk = new CustermJdk(man);
        ClientService.People proxy = (ClientService.People)custermJdk.getProxy();
        proxy.getType();
    }
}
