package com.dream.mentor;


import com.dream.mentor.common.SHAUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Administrator on 2016/1/17 0017.
 */
public class BaseAction {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    protected  String getCookieValue(String key){
        Cookie[] cookies = request.getCookies();
        if(cookies == null) return null;
        String value = null;
        for (Cookie c : cookies) {
            if (c.getName().equals(key)) {
                value =  c.getValue();
            }
        }
        return value;
    }
    
    protected String[] formatLabels(String labels){
        if(StringUtils.isEmpty(labels)){
            return null;
        }
        String[] labelArray = labels.split("\\{#\\}");
        String[] labelList = new String[labelArray.length];

        for(int i = 0 ;i<= labelArray.length-1;i++){
            String[] result = labelArray[i].split("=");
            try{
                labelList[i] = result[1];
            }catch (Exception e){}

        }
        return labelList;
    }
    public boolean validateCode(String key,String destCode){
        String code = (String)request.getSession().getAttribute(key);
        return destCode.equalsIgnoreCase(code);
    }
    public String[] sortStrings(String[] strArr) {
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return strArr;
    }
    public boolean validateSign(String[] strArr, String sign) {
        StringBuffer params = new StringBuffer();
        for (String s : strArr) {
            params.append(s);
        }
        String destSign = SHAUtil.SHA(params.toString());
        if (sign.equals(destSign))
            return true;
        return false;
    }

    private  int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * 获得用户的真实IP
     *
     * @return 用户的真实IP
     */
    protected String getRealIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("x-real-ip");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public String formatMobile(String mobile){
        String s = mobile.substring(3,7);
        return mobile.replace(s,"****");
    }

    protected boolean addCookie(String key, String value, int expireHour){
		try {
			value = URLEncoder.encode(value,"UTF-8");
			Cookie userNameCookie = new Cookie(key, value);
			userNameCookie.setPath("/");
			if(expireHour >0){
				userNameCookie.setMaxAge(expireHour * 60 * 60);
			}
			response.addCookie(userNameCookie);
			return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
