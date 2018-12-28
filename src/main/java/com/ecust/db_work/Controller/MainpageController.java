package com.ecust.db_work.Controller;
import com.ecust.db_work.service.EmployeeServiceImpl;
import com.ecust.db_work.service.SearchServiceImpl;
import com.ecust.db_work.utils.CustomerUtil;
import com.ecust.db_work.utils.EmployeeUtil;
import com.ecust.db_work.utils.StationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class MainpageController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private SearchServiceImpl searchService;
    @RequestMapping(value = "mainPage", method = RequestMethod.GET)
    public ModelAndView transferMainPage(@CookieValue(value = "username",defaultValue = "") String username,
                                         @CookieValue(value = "usertype",defaultValue = "") String usertype) {
        String customerPage = " <a href=\"/customer\" target=\"MainView\">查询客户</a> <br/>",
                employeePage = "<a href=\"/employee\" target=\"MainView\">查询员工</a> <br> ",
                stationPage = "<a href=\"/station\" target=\"MainView\">查询站点</a><br>",
                quitLink = "<a href=\"/logout\">退出登录</a><br>";
        String loginMenu = "<a href=\"/login?username=姚迟亮&usertype=customer\">客户登录</a>\n" +
                "<br/>\n" +
                "<a href=\"/login?username=赵李洋&usertype=employee\">员工登录</a>\n" +
                "<br>\n";
        ModelMap modelMap = new ModelMap();
        if(username.equals("")){
            modelMap.put("leftMenu",loginMenu);
        }
        else {
            String str = "";
            if(usertype.equals("customer")){
                str +=  "<a href=\"/customerDetail.jmp?customerID=" +
                        searchService.findCustomerByName(username).getCustomerId() + "\" target=\"MainView\">个人信息</a><br>";
            }
            else if(usertype.equals("employee")){
                str += employeePage;
                str += customerPage;
            }
            str += stationPage;
            str += quitLink;
            modelMap.put("leftMenu",str);
        }
        return new ModelAndView("mainPage",modelMap);
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
        return new ModelAndView("employeeInfoPage",modelMap);
    }


    @RequestMapping(value = "/station")
    public ModelAndView transferStation(){
        ModelMap modelMap = new ModelMap();
        modelMap.put("ret", StationUtil.StationToHTML(searchService.findStation("",true)));
        return new ModelAndView("stationInfoPage",modelMap);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView customerLogin(HttpServletResponse response, String username,String usertype){
        Cookie cookie = new Cookie("usertype", usertype);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("username", username);
        cookie.setPath("/");
        response.addCookie(cookie);
        return transferMainPage(username,usertype);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request){
        Cookie[] list = request.getCookies();
        for(Cookie x : list){
            if(x.getName().equals("username")) {
                Cookie cookie = new Cookie("username", x.getValue());
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return transferMainPage("","");
    }
}
