package com.sj.filter;

import com.sj.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/index.html",filterName = "userFilter")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        User user=(User) httpServletRequest.getSession().getAttribute("user");
        if(user==null)
        {
            httpServletResponse.sendRedirect("login.html");
        }
        else
        {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
