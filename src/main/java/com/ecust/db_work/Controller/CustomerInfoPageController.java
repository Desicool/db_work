package com.ecust.db_work.Controller;

import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.entity.Deliveryinfo;
import com.ecust.db_work.repository.OrderDeliveryRepositoryImpl;
import com.ecust.db_work.service.CommonAddressServiceImpl;
import com.ecust.db_work.service.CustomerServiceImpl;
import com.ecust.db_work.service.OrderService;
import com.ecust.db_work.service.SearchServiceImpl;
import com.ecust.db_work.utils.CommonAddressUtil;
import com.ecust.db_work.utils.CustomerUtil;
import com.ecust.db_work.utils.DeliveryInfoUtil;
import com.ecust.db_work.utils.EmployeeUtil;
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
public class CustomerInfoPageController {
    @Autowired
    private SearchServiceImpl searchService;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommonAddressServiceImpl commonAddressService;
    @RequestMapping(value = "findCustomer.post",method= RequestMethod.POST)
    public ModelAndView searchCustomer(String customerName){
        ModelMap modelMap = new ModelMap();
        Customer customer = searchService.findCustomerByName(customerName);
        if(customer != null)
            modelMap.put("result", CustomerUtil.CustomerToHTML(customer));
        return new ModelAndView("customerInfoPage",modelMap);
    }

    @RequestMapping(value = "/customerDetail.jmp")
    public ModelAndView transferDetail(@CookieValue(value = "usertype",defaultValue = "")String type,String customerID){
        ModelMap modelMap = new ModelMap();
        boolean isCustomer = type.equals("customer");
        List<String> list = CustomerUtil.CommonAddressToHTML(customerService.getCommonAddress(customerID),isCustomer);
        if(!isCustomer) {
            modelMap.put("returnLink", "<a href=javascript:history.back(-1)>返回</a>");
        }
        modelMap.put("sendAddress",list.get(0));
        modelMap.put("receiveAddress",list.get(1));
        modelMap.put("order",CustomerUtil.ExpressOrderToHTML(customerService.getExpressOrder(customerID)));
        return new ModelAndView("CustomerInfoForCustomer",modelMap);
    }

    @RequestMapping(value = "/deliveryDetail",method= RequestMethod.GET)
    public ModelAndView transferDelivery(String orderID){
        ModelMap modelMap = new ModelMap();
        modelMap.put("returnLink", "<a href=javascript:history.back(-1)>返回</a>");
        modelMap.put("ret", DeliveryInfoUtil.DeliveryInfoToHTML(orderService.getDeliveryinfo(orderID)));
        return new ModelAndView("DeliveryDetailPage",modelMap);
    }


    @RequestMapping(value = "/changeAddress",method= RequestMethod.GET)
    public ModelAndView updateAddress(String ID){
        ModelMap modelMap = new ModelMap();
        modelMap.put("returnLink", "<a href=javascript:history.back(-1)>返回</a>");
        modelMap.put("content", CommonAddressUtil.CommonAddressUpdateHTML(
                commonAddressService.findByID(Integer.valueOf(ID).intValue())));
        modelMap.put("action","/address.update");
        return new ModelAndView("UpdateDataPage",modelMap);
    }
}
