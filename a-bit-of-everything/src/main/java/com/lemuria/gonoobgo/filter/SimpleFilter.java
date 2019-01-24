package com.lemuria.gonoobgo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lemuria.gonoobgo.pojo.SimpleClass;

@Component
public class SimpleFilter implements Filter{

	private Logger logger = LogManager.getFormatterLogger(SimpleFilter.class);
	@Autowired
	private SimpleClass clazz;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("SimpleFilter init");
		logger.info("SimpleFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("SimpleFilter doFilter");
		logger.info("SimpleFilter doFilter:"+clazz);
		HttpServletRequest arequest= (HttpServletRequest) request;
		logger.info(arequest.getRequestURI());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("SimpleFilter destory");
		System.out.println("SimpleFilter destory	");
	}

}
