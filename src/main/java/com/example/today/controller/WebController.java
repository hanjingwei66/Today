package com.example.today.controller;

import com.example.today.myAnnotation.Idempotent;
import com.example.today.service.HotSwappable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
   @Qualifier("hotSwappableImpl")
   @Autowired
   private HotSwappable hotSwappable;
   @RequestMapping(value = "/index")
   public String index() {
      return "index";
   }
   @RequestMapping("/login")
   @ResponseBody
   @Idempotent
   public String login(){
      return "login";
   }
   @Idempotent
   @RequestMapping("/hello")
   @ResponseBody
   public String sayhello(){
      hotSwappable.hello();
      return "hello";
   }

}