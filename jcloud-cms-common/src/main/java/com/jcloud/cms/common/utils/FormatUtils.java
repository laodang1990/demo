package com.jcloud.cms.common.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatUtils {
    private static final Logger logger = Logger.getLogger(FormatUtils.class);

    private static final String DATE_TIME_FORMAT = "%s %s";

    private static final String DEFAULT_DOMAIN_URL = "http://yq.jd.com/fc";

    private static final String REWRITE_PARAM_KEY = "_park";

    /**
     * 将逗号分隔的id字符串转为列表
     */
    public static List<Long> convertStringToList(String ids) {
        List<Long> idList = new ArrayList<Long>();
        if (ids == null || ids.length() == 0) {
            return idList;
        }
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            idList.add(Long.valueOf(id));
        }
        return idList;
    }

    /**
     * 将包含年、月、日的时间字符串拼接上 00:00:00 的时分秒，作为开始时间用于查询
     */
    public static Date convertFullStartTime(String startTimeString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(startTimeString + " 00:00:00");
    }

    /**
     * 将包含年、月、日的时间字符串拼接上 23:59:59 的时分秒，作为结束时间用于查询
     */
    public static Date convertFullEndTime(String endTimeString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(endTimeString + " 23:59:59");
    }

    public static Date formatDateHourMinute(String date, String hourMinute) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.parse(String.format(DATE_TIME_FORMAT, date, hourMinute));
    }

    // for 接口
    public static String getHostWithParkNameForApi(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        String subUrl = requestURL.substring((request.getScheme() + "://").length());
        String[] urlParts = subUrl.split("/");
        if (urlParts.length < 2) {
            return request.getHeader("host");
        } else {
            return request.getScheme() + "://" + urlParts[0] + "/" + urlParts[1];
        }
    }

    public static String getRedirectHostForHtml(HttpServletRequest request) {
        // Nginx会rewrite页面的请求url，为了本地环境测试，默认使用http://yq.jd.com/fc
        String parkParam = request.getParameter(REWRITE_PARAM_KEY);
        if (parkParam != null) {
            return request.getScheme() + "://" + parkParam;
        }
        logger.info("park param is null, return default domain url");
        return DEFAULT_DOMAIN_URL;
    }

    public static String getH5RedirectUrl(HttpServletRequest request, String defaultUrl) {
        String regex = "/m/(.*)";
        Matcher matcher = Pattern.compile(regex).matcher(request.getRequestURI());
        String redirectURI = matcher.find() ? matcher.group() : defaultUrl;
        String parkParam = request.getParameter(REWRITE_PARAM_KEY);
        String requestURL = request.getRequestURL().toString();
        if (parkParam != null) {
            return request.getScheme() + "://" + parkParam + redirectURI;
        }
        return requestURL;
    }
}
