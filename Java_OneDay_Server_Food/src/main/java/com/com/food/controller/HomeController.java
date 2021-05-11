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

@WebServlet("/")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected MyFoodService mfService;

	public HomeController() {

		mfService = new MyFoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<MyFoodDTO> mfList = mfService.selectAll();
		req.setAttribute("MFLIST", mfList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
}
