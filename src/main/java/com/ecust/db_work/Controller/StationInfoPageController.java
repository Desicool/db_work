package com.ecust.db_work.Controller;

import com.ecust.db_work.service.SearchServiceImpl;
import com.ecust.db_work.utils.StationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class StationInfoPageController {
    @Autowired
    private SearchServiceImpl searchService;

    @RequestMapping(value="/searchStation",method = RequestMethod.POST)
    public ModelAndView transferStation(String searchStr,String searchType){
        ModelMap modelMap = new ModelMap();
        modelMap.put("ret", StationUtil.StationToHTML(searchService.findStation(searchStr,searchType.equals("name"))));
        return new ModelAndView("forward:station",modelMap);
    }
}
