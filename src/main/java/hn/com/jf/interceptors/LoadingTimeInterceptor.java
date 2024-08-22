package hn.com.jf.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod methodName = ((HandlerMethod) handler);
		logger.info("LoadingTimeInterceptor: pretHandle() entrando al metodo -> "
				+ ((HandlerMethod) handler).getMethod().getName());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		logger.info("LoadingTimeInterceptor: postHandle() saliendo del metodo -> "
				+ ((HandlerMethod) handler).getMethod().getName());
	}

}
