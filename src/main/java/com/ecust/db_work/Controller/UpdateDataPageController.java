package com.ecust.db_work.Controller;

import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Expressorder;
import com.ecust.db_work.entity.Station;
import com.ecust.db_work.repository.ExpressOrderRepository;
import com.ecust.db_work.repository.ExpressOrderRepositoryImpl;
import com.ecust.db_work.repository.StationRepository;
import com.ecust.db_work.repository.StationRepositoryImpl;
import com.ecust.db_work.service.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @Autowired
    private StationRepositoryImpl stationRepository;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private ExpressOrderRepositoryImpl expressOrderRepository;
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

    @RequestMapping(value = "/station.update",method = RequestMethod.POST)
    public ModelAndView commitStationUpdate(String address,String id,String stationName,String phone){
        Station station = stationRepository.get(id);
        boolean ok = false;
        if(!address.equals(station.getAddress())){
            ok = true;
            station.setAddress(address);
        }
        if(!stationName.equals(station.getName())){
            ok = true;
            station.setName(stationName);
        }
        if(!phone.equals(station.getPhone())){
            ok = true;
            station.setPhone(phone);
        }
        if(ok) {
            stationRepository.update(station);
            stationRepository.flush();
        }
        return new ModelAndView("redirect:station" ,null);
    }

    @RequestMapping(value = "/station.insert",method = RequestMethod.POST)
    public ModelAndView commitStationInsert(String address, String stationName, String phone){
        Station station = new Station();
        station.setPhone(phone);
        station.setName(stationName);
        station.setAddress(address);
        station.setStationId(stationRepository.generatedStationID());
        stationRepository.save(station);
        stationRepository.flush();
        return new ModelAndView("redirect:station",null);
    }

    @RequestMapping(value = "/order.add",method = RequestMethod.POST)
    public ModelAndView AddOrder(String sentaddress, String customerName,
                                 String receiveAddress,String receiverName,String money){
        Expressorder expressorder = new Expressorder();
        expressorder.setExpressOrderByCustomer(customerService.findCustomerByName(customerName));
        expressorder.setSentAddress(sentaddress);
        expressorder.setReceiveAddress(receiveAddress);
        expressorder.setReceiverName(receiverName);
        expressorder.setPayment(Double.valueOf(money));
        expressorder.setOrderNo(expressOrderRepository.generatedOrderID());

        expressOrderRepository.save(expressorder);
        expressOrderRepository.flush();
        return new ModelAndView("redirect:order.add",null);
    }
}
