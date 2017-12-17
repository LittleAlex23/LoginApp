/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFilter;

import Entity.UserAccount;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexandre
 */
@WebFilter(filterName = "LoginData", urlPatterns = {"/LoggedIn/*"})
public class LoginData implements Filter {
    private FilterConfig config;
    private FilterConfig filterConfig = null;
    public LoginData() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;
        
        HttpSession session = httpReq.getSession(false);
       // ServletContext context = config.getServletContext();
        UserAccount c = null;
        if(session != null)
            c = (UserAccount)session.getAttribute("user");
        if (c != null){
          //  context.log(c.getName() + " logged on " + (new java.util.Date()));
            httpRes.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            httpRes.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            httpRes.setDateHeader("Expires", 0);
            chain.doFilter(request, response);
        } else {
            httpRes.sendRedirect("/WebApp/loginPage");
        }
    }
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    @Override
    public void init(FilterConfig filterConfig) {        
        System.out.println("Instance created of " + getClass().getName());
        this.config = filterConfig;
    }

    @Override
    public void destroy() {
    }
}
