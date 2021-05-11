package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;

public interface FoodService {

	public List<FoodDTO> selectAll();

	public List<FoodDTO> findByFname(String f_name);

	public int insert(FoodVO foodVO);

	public int update(FoodVO foodVO);

	public int delete(String f_code);
}
