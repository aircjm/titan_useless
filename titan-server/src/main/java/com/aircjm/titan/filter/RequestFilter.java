package com.aircjm.titan.filter;

import com.aircjm.titan.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请求filter
 *
 * @author aircjm
 */
@Slf4j
@Component
@WebFilter(filterName = "requestFilter", urlPatterns = "/*")
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("RequestFilter.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("token");
        log.info("RequestFilter.doFilter,URL:{},method:[{}],IP:[{}],realIp:[{}],token:[{}]",
                httpServletRequest.getRequestURL(),
                httpServletRequest.getMethod(),
                IpUtil.getClientIp(httpServletRequest),
                IpUtil.getRealIPAddr(httpServletRequest),
                token);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("RequestFilter.destroy");
    }
}
