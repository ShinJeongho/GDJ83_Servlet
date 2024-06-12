package com.winer.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winer.home.student.StudentController;
import com.winer.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("실행 됨");

		String uri = request.getRequestURI();
		String method = request.getMethod();

		if (!uri.equals("/favicon.ico")) {

			// String path = uri.substring(1, uri.lastIndexOf("/"));

			// System.out.println(path);

			String[] p = uri.split("/");

//			for (String s : p) {
//				System.out.println(s);
//			}

//			StringTokenizer st = new StringTokenizer(uri, "/");
//			while (st.hasMoreTokens()) {
//				System.out.println(st.nextToken());
//			}

			System.out.println(uri);
			System.out.println(method);
			String path = "";
			Action action = new Action();

			if (uri.equals("/")) {

				action.setFlag(true);
				action.setPath("/WEB-INF/views/Index.jsp");

			} else if (p[1].equals("student")) {

				StudentController sc = new StudentController();
				action = sc.start(request);

			} else if (p[1].equals("weather")) {

				WeatherController wc = new WeatherController();
				try {
					action = wc.start(request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (action.isFlag()) {

				RequestDispatcher view = request.getRequestDispatcher(action.getPath());
				view.forward(request, response);
			} else {
				response.sendRedirect(action.getPath());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
