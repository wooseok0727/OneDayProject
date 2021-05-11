package com.com.food.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyFoodVO;
import com.com.food.service.FoodService;
import com.com.food.service.MyFoodService;
import com.com.food.service.impl.FoodServiceImplV1;
import com.com.food.service.impl.MyFoodServiceImplV1;

@WebServlet("/intake")
public class IntakeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected FoodService fService;
	protected MyFoodService mfService;
	protected String sdate;
	protected String mf_sdate;

	public IntakeController() {

		fService = new FoodServiceImplV1();
		mfService = new MyFoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		sdate = sd.format(date);
		req.setAttribute("FDATE", sdate);
		req.getRequestDispatcher("/WEB-INF/views/intake.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String button = req.getParameter("button");

		if (button.equals("search")) {

			mf_sdate = req.getParameter("mf_date");
			String f_name = req.getParameter("mf_name");
			List<FoodDTO> fList = fService.findByFname(f_name);
			req.setAttribute("FLIST", fList);
			req.getRequestDispatcher("/WEB-INF/views/intake2.jsp").forward(req, resp);

		} else if (button.equals("select")) {

			String f_code = req.getParameter("f_code");
			String f_name = req.getParameter("f_name");
			req.setAttribute("FCODE", f_code);
			req.setAttribute("FNAME", f_name);
			req.setAttribute("FDATE", mf_sdate);
			req.getRequestDispatcher("/WEB-INF/views/intake.jsp").forward(req, resp);

		} else if (button.equals("insert")) {

			String mf_date = req.getParameter("mf_date");
			String mf_code = req.getParameter("mf_code");
			Integer mf_intake = null;
			try {
				mf_intake = Integer.valueOf(req.getParameter("mf_intake"));

				MyFoodVO myfoodVO = new MyFoodVO();
				myfoodVO.setMf_date(mf_date);
				myfoodVO.setMf_pcode(mf_code);
				myfoodVO.setMf_intake(mf_intake);
				int result = mfService.insert(myfoodVO);
				if (result > 0) {
					resp.sendRedirect("/food");
				} else {
					req.getRequestDispatcher("/WEB-INF/views/exception.jsp").forward(req, resp);
				}
			} catch (NumberFormatException e) {
				req.getRequestDispatcher("/WEB-INF/views/exception.jsp").forward(req, resp);
			}
		}
	}
}
