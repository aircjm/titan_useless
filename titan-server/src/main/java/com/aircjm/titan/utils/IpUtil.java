package com.aircjm.titan.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * IpUtil
 *
 * @author aircjm
 */
public class IpUtil {
    private static final String UNKNOWN = "unknown";
    private static final String STRING_NULL = "null";
    private static final List<String> HTTP_HEADERS_RELATED_IP = initHttpHeadersRelatedIp();

    private static List<String> initHttpHeadersRelatedIp() {
        return Arrays.asList("NS-Client-IP", "x-forwarded-for", "Proxy-Client-IP", "WL-Proxy-Client-IP");
    }

    /**
     * 在处理Java web HTTP请求时, 获取浏览器的IP. 在代理存在的情况下, HttpServletRequest.getRemoteAddr()会获取代理的实际IP, 而不是浏览器IP.
     * 本方法忽略HttpServletRequest.getRemoteAddr()的调用.
     *
     * @param request http request
     * @return 返回值
     */
    private static String getClientIpWithoutRemoteAddr(HttpServletRequest request) {
        for (String httpHeaderRelatedIp : HTTP_HEADERS_RELATED_IP) {
            String ip = request.getHeader(httpHeaderRelatedIp);
            if (isValidIp(ip)) {
                return ip;
            }
        }
        return null;
    }

    private static boolean isValidIp(String ip) {
        return ip != null && ip.length() > 0 && !UNKNOWN.equalsIgnoreCase(ip);
    }

    /**
     * 获取客户端IP
     *
     * @param request http request
     * @return 返回值
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = getClientIpWithoutRemoteAddr(request);
        if (null != ip) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 获取客户端的真实IP。如果有浏览器代理，则通过X－FORWARDED－FOR信息跟踪原有的客户端IP
     */
    public static String getRealIPAddr(HttpServletRequest request) {
        String ip = "";
        if (null != request) {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip) || STRING_NULL.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip) || STRING_NULL.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip) || STRING_NULL.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        }
        return ip;
    }
}
