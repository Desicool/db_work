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
        modelMap.put("ret", EmployeeUtil.EmployeeToHTML(employeeService.getAllEmployee()));
        return new ModelAndView("employeeInfoPage",modelMap);
    }
}
