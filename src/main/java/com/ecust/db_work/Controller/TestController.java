package com.ecust.db_work.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
//        实际返回的是View/test.jsp ,spring-mvc.xml中配置过前后缀
        return "test";
    }
}