package com.ecust.db_work.Controller;

import com.ecust.db_work.service.EmployeeServiceImpl;
import com.ecust.db_work.utils.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeInfoPageController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = "searchEmployee.post",method= RequestMethod.POST)
    public ModelAndView searchEmployee(String searchStr, String searchType){
        ModelMap modelMap = new ModelMap();
        if(searchType.equals("name")){
            modelMap.put("ret",EmployeeUtil.EmployeeToHTML(employeeService.getEmployeeByName(searchStr)));
        }
        else{
            modelMap.put("ret",EmployeeUtil.EmployeeToHTML(employeeService.getEmployeeByStation(searchStr)));
        }
        modelMap.put("title", searchStr + "的搜索结果");
        return new ModelAndView("employeeInfoPage",modelMap);
    }


    @RequestMapping(value = "showPayroll",method= RequestMethod.GET)
    public ModelAndView showPayroll(String employeeID){
        ModelMap modelMap = new ModelMap();
        modelMap.put("title","工资发放情况");
        modelMap.put("returnLink","<a href=javascript:history.back(-1)>返回</a>");
        modelMap.put("ret", EmployeeUtil.PayrollToHTML(employeeService.getPayrollByEmployeeId(employeeID)));
        return new ModelAndView("PaymentDetailPage",modelMap);
    }


    @RequestMapping(value = "showPayrollDetail",method= RequestMethod.GET)
    public ModelAndView showPayrollDetail(String payrollID){
        ModelMap modelMap = new ModelMap();
        modelMap.put("title","工资详情");
        modelMap.put("returnLink","<a href=javascript:history.back(-1)>返回</a>");
        modelMap.put("ret", EmployeeUtil.PayrollDetailToHTML(employeeService.getPayrollDetailByPayrollID(payrollID)));
        return new ModelAndView("PaymentDetailPage",modelMap);
    }
}
