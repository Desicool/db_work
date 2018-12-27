package com.ecust.db_work.utils;


import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Station;

import java.util.Iterator;
import java.util.List;

public class StationUtil {
    public static String StationToHTML(List<Station> list){
        String ans="<table border =\"1\"><tr><th>编号</th><th>名称</th><th>地址</th><th>联系电话</th></tr>";

        Iterator<Station> iterator = list.iterator();
        while(iterator.hasNext()) {
            Station station = iterator.next();
            ans += "<tr>";
            ans += "<td>"+station.getStationId()+"</td>";
            ans += "<td>"+station.getName()+"</td>";
            ans += "<td>"+station.getAddress()+"</td>";
            ans += "<td>"+station.getPhone()+"</td>";
            ans += "</tr>";
        }
        ans += "</table>";
        return ans;
    }
}
