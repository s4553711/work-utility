package com.ck.intercepter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserCheck implements Filter {
	private FilterConfig filterConfig;

    /**
     * Default constructor. 
     */
    public UserCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("login") != null && session.getAttribute("login").equals("ok")){
			chain.doFilter(request, response);
		} else {
			chain.doFilter(request, response);
			//((HttpServletResponse) response).sendRedirect("index");
			filterConfig.getServletContext().log("Non-Login");
		}
		
		long begin = System.currentTimeMillis();
		System.out.println("verify user privilege");
		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
        //filterConfig.getServletContext().log("Request process in " +
        //        (System.currentTimeMillis() - begin) + " milliseconds");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}
}

