package com.ecust.db_work.Controller;

import com.ecust.db_work.entity.Station;
import com.ecust.db_work.repository.StationRepository;
import com.ecust.db_work.service.SearchServiceImpl;
import com.ecust.db_work.utils.CommonAddressUtil;
import com.ecust.db_work.utils.StationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StationInfoPageController {
    @Autowired
    private SearchServiceImpl searchService;

    @Autowired
    private StationRepository stationRepository;
    @RequestMapping(value="/searchStation",method = RequestMethod.POST)
    public ModelAndView transferStation(String searchStr,String searchType){
        ModelMap modelMap = new ModelMap();
        List<Station> list = searchService.findStation(searchStr,searchType.equals("name"));
        if(list != null)
            modelMap.put("ret", StationUtil.StationToHTML(list,searchType.equals("employee")));
        return new ModelAndView("stationInfoPage",modelMap);
    }

    @RequestMapping(value = "/updateStation",method = RequestMethod.GET)
    public ModelAndView commitStationUpdate(String stationID){
        Station station = stationRepository.get(stationID);
        ModelMap modelMap = new ModelMap();
        modelMap.put("returnLink", "<a href=javascript:history.back(-1)>返回</a>");
        modelMap.put("content", StationUtil.StationUpdateHTML(station));
        modelMap.put("action","/station.update");
        return new ModelAndView("UpdateDataPage",modelMap);
    }

    @RequestMapping(value = "/insertStation",method = RequestMethod.GET)
    public ModelAndView commitStationInsert(){
        ModelMap modelMap = new ModelMap();
        modelMap.put("returnLink", "<a href=javascript:history.back(-1)>返回</a>");
        modelMap.put("content", StationUtil.StationInsertHTML());
        modelMap.put("action","/station.insert");
        return new ModelAndView("UpdateDataPage",modelMap);
    }
}
