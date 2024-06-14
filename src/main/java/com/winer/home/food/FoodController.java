package com.winer.home.food;

import javax.servlet.http.HttpServletRequest;

import com.winer.home.Action;

public class FoodController {

	public Action start(HttpServletRequest request) {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = new Action();
		action.setFlag(true);

		if (uri.equals("list")) {
			action.setPath("/WEB-INF/views/food/list.jsp");
		}
		return action;

	}
}
