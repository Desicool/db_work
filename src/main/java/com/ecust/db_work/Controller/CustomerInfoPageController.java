package com.ecust.db_work.Controller;

import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.service.SearchServiceImpl;
import com.ecust.db_work.utils.CustomerUtil;
import com.ecust.db_work.utils.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerInfoPageController {
    @Autowired
    private SearchServiceImpl searchService;

    @RequestMapping(value = "findCustomer.post",method= RequestMethod.POST)
    public ModelAndView searchEmployee(String customerName){
        ModelMap modelMap = new ModelMap();
        Customer customer = searchService.findCustomerByName(customerName);
        if(customer != null)
            modelMap.put("result", CustomerUtil.CustomerToHTML(customer));
        return new ModelAndView("customerInfoPage",modelMap);
    }

    @RequestMapping(value = "customerDetail.jmp",method= RequestMethod.GET)
    public ModelAndView transferDetail(String customerName){
        ModelMap modelMap = new ModelMap();
        return new ModelAndView("CustomerInfoForCustomer",modelMap);
    }
}
