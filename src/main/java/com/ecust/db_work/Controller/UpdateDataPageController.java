package com.ecust.db_work.Controller;

import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.service.CommonAddressService;
import com.ecust.db_work.service.EmployeeService;
import com.ecust.db_work.service.OrderService;
import com.ecust.db_work.service.SearchService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UpdateDataPageController {
    @Autowired
    private CommonAddressService commonAddressService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/address.update",method = RequestMethod.POST)
    public ModelAndView commitAddressUpdate(@CookieValue(value = "username",defaultValue = "")String username,
                                            String address, String user, String id){
        int ret = commonAddressService.updateCommonAddress(address,user,id).intValue();
        String idd = searchService.findCustomerByName(username).getCustomerId();
        return new ModelAndView("redirect:customerDetail.jmp?customerID=" + idd,null);
    }

    @RequestMapping(value = "/address.insert",method = RequestMethod.POST)
    public ModelAndView commitAddressInsert(@CookieValue(value = "username",defaultValue = "")String username,
                                            String address, String user, String isSendAddress){
        String idd = searchService.findCustomerByName(username).getCustomerId();
        int ret = commonAddressService.insertCommonAddress(address,user,
                idd,isSendAddress.equals("true")).intValue();
        return new ModelAndView("redirect:customerDetail.jmp?customerID=" + idd,null);
    }

    @RequestMapping(value = "/delivery.update",method = RequestMethod.POST)
    public ModelAndView commitDeliveryInsert(@CookieValue(value = "username",defaultValue = "")String employeeName,
                                             String orderID,String additional){
        List<Employee> list = employeeService.getEmployeeByName(employeeName);
        Employee employeee = new Employee();
        for(Employee employee : list){
            if(employeeName.equals(employee.getName())) {
                employeee = employee;
                break;
            }
        }
        orderService.insertDeliveryInfo(orderID, employeee, additional);
        return new ModelAndView("redirect:changeDelivery");
    }
    @RequestMapping(value = "/delivery.check",method = RequestMethod.POST)
    public ModelAndView checkDelivery(@CookieValue(value = "username",defaultValue = "")String employeeName,
                                             String orderID,String additional){
        List<Employee> list = employeeService.getEmployeeByName(employeeName);
        Employee employeee = new Employee();
        for(Employee employee : list){
            if(employeeName.equals(employee.getName())) {
                employeee = employee;
                break;
            }
        }
        orderService.checkDelivery(orderID, employeee, additional);
        return new ModelAndView("redirect:checkDelivery");
    }
}
