package com.ecust.db_work.Controller;
import com.ecust.db_work.service.EmployeeService;
import com.ecust.db_work.service.EmployeeServiceImpl;
import com.ecust.db_work.service.SearchService;
import com.ecust.db_work.service.SearchServiceImpl;
import com.ecust.db_work.utils.CustomerUtil;
import com.ecust.db_work.utils.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class MainpageController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private SearchServiceImpl searchService;
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String transferMainPage() {
//        实际返回的是View/test.jsp ,spring-mvc.xml中配置过前后缀
        return "mainPage";
    }
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ModelAndView transferCustomer(){
        ModelMap modelMap = new ModelMap();
        modelMap.put("result", CustomerUtil.CustomerListToHTML(searchService.findAllCustomer()));
        return new ModelAndView("customerInfoPage",modelMap);

    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public ModelAndView transferEmployee(){
        ModelMap modelMap = new ModelMap();
        modelMap.put("ret", EmployeeUtil.EmployeeToHTML(employeeService.getAllEmployee()));
        //modelMap.put("page","employeeInfoPage");
        //return new ModelAndView("employeeInfoPage",modelMap);
        return new ModelAndView("employeeInfoPage",modelMap);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView becomeCustomer(HttpServletResponse response, String id){
        response.addCookie(new Cookie("customerId",id));
        //return showMyDiscounts(id);
        return null;
    }

}
