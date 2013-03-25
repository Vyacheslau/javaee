package com.enterprise.organization.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.enterprise.organization.entities.User;
import com.enterprise.organization.enums.UserRole;

public class ActionsInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		String role = user.getUserRole();
		if (role.equalsIgnoreCase(String.valueOf(UserRole.ADMIN))
				|| role.equalsIgnoreCase(String.valueOf(UserRole.MANAGER))) {
			return true;
		} else {
			response.sendRedirect("/organization/accessDenied");
			return false;
		}
	}
}
