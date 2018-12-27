package com.ecust.db_work.Controller;

import com.ecust.db_work.entity.Station;
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
import java.util.List;

@Controller
public class StationInfoPageController {
    @Autowired
    private SearchServiceImpl searchService;

    @RequestMapping(value="/searchStation",method = RequestMethod.POST)
    public ModelAndView transferStation(String searchStr,String searchType){
        ModelMap modelMap = new ModelMap();
        List<Station> list = searchService.findStation(searchStr,searchType.equals("name"));
        if(list != null)
            modelMap.put("ret", StationUtil.StationToHTML(list));
        return new ModelAndView("forward:station",modelMap);
    }
}
