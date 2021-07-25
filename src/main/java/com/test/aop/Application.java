package com.test.aop;

import com.test.aop.MyResource.MyResourceLoader;
import com.test.aop.modle.ClientS;
import com.test.aop.modle.Game;
import javafx.beans.property.Property;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("pojos/beans.xml");
        Game xiaoming = ctx.getBean("xiaoming", Game.class);
        xiaoming.play();
        ClientService staticfactory = ctx.getBean("staticfactory", ClientService.class);
        staticfactory.imFactoryMethod();
        ClientS clientService = ctx.getBean("clientService", ClientS.class);
        clientService.imClient();
        try {
            UrlResource urlResource = new UrlResource("https://hq.sinajs.cn/list=sz002373");
            System.out.println(urlResource.getDescription());
            System.out.println(urlResource);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        MyResourceLoader myResourceLoader = ctx.getBean("myResourceLoader", MyResourceLoader.class);
        myResourceLoader.getResource("pojos/settings.properties");
        Properties properties = myResourceLoader.getProperties();
        properties.setProperty("sunhaoran","大儿子");
        System.out.println(properties);

    }
}
