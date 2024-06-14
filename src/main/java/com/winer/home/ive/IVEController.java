package com.winer.home.ive;

import javax.servlet.http.HttpServletRequest;

import com.winer.home.Action;

public class IveController {
	public Action start(HttpServletRequest request) throws Exception {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = new Action();
		action.setFlag(true);

		if (uri.equals("list")) {
			action.setPath("/WEB-INF/views/ive/list.jsp");
		}

		return action;
	}
}
