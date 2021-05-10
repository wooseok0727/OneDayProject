package com.com.food.service;

import java.util.List;

import com.com.food.model.MyFoodDTO;
import com.com.food.model.MyFoodVO;

public interface MyFoodService {

	public List<MyFoodDTO> selectAll();
	public List<MyFoodDTO> findByDate(String mf_date);
	
	public int insert(MyFoodVO myfoodVO);
	public int update(MyFoodVO myfoodVO);
	public int delete(Long seq);
}
