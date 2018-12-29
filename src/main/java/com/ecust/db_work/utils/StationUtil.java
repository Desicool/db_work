package com.ecust.db_work.utils;


import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Station;

import java.util.Iterator;
import java.util.List;

public class StationUtil {
    public static String StationToHTML(List<Station> list,boolean isEmployee){
        String ans="<table border =\"1\"><tr><th>编号</th><th>名称</th><th>地址</th><th>联系电话</th>" +
                (isEmployee?"<th><a href=/insertStation>添加<a></th>":"")+"</tr>";

        Iterator<Station> iterator = list.iterator();
        while(iterator.hasNext()) {
            Station station = iterator.next();
            ans += "<tr>";
            ans += "<td>"+station.getStationId()+"</td>";
            ans += "<td>"+station.getName()+"</td>";
            ans += "<td>"+station.getAddress()+"</td>";
            ans += "<td>"+station.getPhone()+"</td>";
            if(isEmployee){
                ans += "<td><a href=\"/updateStation?stationID=" + station.getStationId() + "\">修改</a></td>";
            }
            ans += "</tr>";
        }
        ans += "</table>";
        return ans;
    }

    public static String StationUpdateHTML(Station station){
        String ans = "<table border=\"0\">" +
                "<tr><td>地址：</td><td><input type=\"text\" class=\"text-input\" name=\"address\" value=\""
                + station.getAddress() + "\"></td></tr>";
        ans += "<td>站点名称</td><td><input type=\"text\" class=\"text-input\" value=\""
                + station.getName() + "\" name=\"stationName\"></td></tr>";
        ans += "<td>联系电话</td><td><input type=\"text\" class=\"text-input\" value=\""
                + station.getPhone() + "\" name=\"phone\"></td></tr>";
        ans += "</table>";
        ans += "<input type=\"submit\" value=\"提交修改\">";
        ans += "<input type=\"text\" value=\""+station.getStationId()+"\" name=\"id\" style=\"display:none\">";
        return ans;
    }

    public static String StationInsertHTML(){
        String ans = "<table border=\"0\">" +
                "<tr><td>地址：</td><td><input type=\"text\" class=\"text-input\" name=\"address\"></td></tr>";
        ans += "<td>站点名称</td><td><input type=\"text\" class=\"text-input\" name=\"stationName\"></td></tr>";
        ans += "<td>联系电话</td><td><input type=\"text\" class=\"text-input\" name=\"phone\"></td></tr>";
        ans += "</table>";
        ans += "<input type=\"submit\" value=\"添加\">";
        //ans += "<input type=\"text\" value=\""+station.getStationId()+"\" name=\"id\" style=\"display:none\">";
        return ans;
    }
}
