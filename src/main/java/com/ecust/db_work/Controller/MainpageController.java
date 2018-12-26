package com.ecust.db_work.Controller;
import com.ecust.db_work.service.EmployeeService;
import com.ecust.db_work.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MainpageController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String transferMainPage() {
//        实际返回的是View/test.jsp ,spring-mvc.xml中配置过前后缀
        return "mainPage";
    }
    @RequestMapping(value = "/business", method = RequestMethod.GET)
    public ModelAndView transferBusiness(){
        return null;

    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public ModelAndView transferEmployee(){
        EmployeeService employeeService = new EmployeeServiceImpl();
        ModelMap modelMap = new ModelMap();
        //modelMap.put("ret",employeeService.getAllEmployee());
        modelMap.put("page","employeeInfoPage");
        //return new ModelAndView("employeeInfoPage",modelMap);
        return new ModelAndView("employeeInfoPage",modelMap);
    }
    @RequestMapping(value = "employeeInfoPage", method = RequestMethod.GET)
    public ModelAndView transferEmployeeInfoPage() {
        return null;
    }

}
