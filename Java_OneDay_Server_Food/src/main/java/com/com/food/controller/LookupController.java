package com.com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.MyFoodDTO;
import com.com.food.service.MyFoodService;
import com.com.food.service.impl.MyFoodServiceImplV1;

@WebServlet("/lookup")
public class LookupController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected MyFoodService mfService;

	public LookupController() {

		mfService = new MyFoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/lookup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mf_year = req.getParameter("mf_year");
		String mf_month = null;
		String mf_day = null;
		try {
			mf_month = String.format("%02d", Integer.valueOf(req.getParameter("mf_month")));
			mf_day = String.format("%02d", Integer.valueOf(req.getParameter("mf_day")));
		} catch (NumberFormatException e) {
			req.getRequestDispatcher("/WEB-INF/views/exception.jsp").forward(req, resp);
		}
		String mf_date = String.format(mf_year + "-" + mf_month + "-" + mf_day);
		List<MyFoodDTO> mfList = mfService.findByDate(mf_date);
		req.setAttribute("MFLIST", mfList);
		req.getRequestDispatcher("/WEB-INF/views/lookup2.jsp").forward(req, resp);
	}
}
