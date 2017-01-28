package com.master.template.web.filter;

import com.master.template.config.GatewayProperties;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CachingHttpHeadersFilter implements Filter {

    private final static long LAST_MODIFIED = System.currentTimeMillis();

    private long CACHE_TIME_TO_LIVE = TimeUnit.DAYS.toMillis(1461L);

    private GatewayProperties gatewayProperties;

    public CachingHttpHeadersFilter(GatewayProperties gatewayProperties) {
        this.gatewayProperties = gatewayProperties;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        CACHE_TIME_TO_LIVE = TimeUnit.DAYS.toMillis(gatewayProperties.getHttp().getCache().getTimeToLiveInDays());
    }

    @Override
    public void destroy() {
        // Nothing to destroy
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader("Cache-Control", "max-age=" + CACHE_TIME_TO_LIVE + ", public");
        httpResponse.setHeader("Pragma", "cache");
        httpResponse.setDateHeader("Expires", CACHE_TIME_TO_LIVE + System.currentTimeMillis());
        httpResponse.setDateHeader("Last-Modified", LAST_MODIFIED);

        chain.doFilter(request, response);
    }
}