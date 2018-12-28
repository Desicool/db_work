package com.ecust.db_work.Controller;

import com.ecust.db_work.service.CommonAddressService;
import com.ecust.db_work.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateDataPageController {
    @Autowired
    private CommonAddressService commonAddressService;
    @Autowired
    private SearchService searchService;
    @RequestMapping(value = "/address.update",method = RequestMethod.POST)
    public ModelAndView commitAddressUpdate(@CookieValue(value = "username",defaultValue = "")String username,
                                            String address, String user, String id){
        int ret = commonAddressService.updateCommonAddress(address,user,id).intValue();
        String idd = searchService.findCustomerByName(username).getCustomerId();
        return new ModelAndView("redirect:customerDetail.jmp?customerID=" + idd,null);
    }
}
