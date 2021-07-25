package com.test.aop;

import com.test.aop.modle.ClientS;

public class DefaultServiceLocator {

    private static ClientS clientS =new ClientS();

    public ClientS createClientServiceInstance() {
        return clientS;
    }
}