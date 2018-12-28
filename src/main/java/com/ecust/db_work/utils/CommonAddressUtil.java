package com.ecust.db_work.utils;

import com.ecust.db_work.entity.Commonaddress;

public class CommonAddressUtil {
    public static String CommonAddressUpdateHTML(Commonaddress commonaddress){
        String ans = "<table border=\"0\">" +
                "<tr><td>地址：</td><td><input type=\"text\" class=\"text-input\" name=\"address\" value=\""
                + commonaddress.getAddress() + "\"></td></tr>";
        if(commonaddress.isSendAddress())
            ans += "<tr><td>发件人：</td>";
        else
            ans += "<tr><td>收件人：</td>";
        ans += "<td><input type=\"text\" class=\"text-input\" value=\""
                + commonaddress.getTargetUser() + "\" name=\"user\"></td></tr>";
        ans += "</table>";
        ans += "<input type=\"submit\" value=\"提交修改\">";
        ans += "<input type=\"text\" value=\""+String.valueOf(commonaddress.getId())+"\" name=\"id\" style=\"display:none\">";
        return ans;
    }
}
