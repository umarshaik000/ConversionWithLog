package com.example.demo.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.time.LocalDateTime;

public class RequestResponseLoggingFilter extends OncePerRequestFilter {

//    private static final Logger log = LoggerFactory.getLogger("REQUEST_RESPONSE_LOG");
    private static final Logger appLog = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    private static final Logger successLog = LoggerFactory.getLogger("SUCCESS_LOG");
    private static final Logger errorLog = LoggerFactory.getLogger("ERROR_LOG");


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws java.io.IOException, jakarta.servlet.ServletException {

        String endpoint = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String time = LocalDateTime.now().toString();

//        log.info("Endpoint={}, Time={}, IP={}", endpoint, time, ip);
        appLog.info("Endpoint={}, Time={}, IP={}", endpoint, time, ip);

        filterChain.doFilter(request, response);
    }
}
