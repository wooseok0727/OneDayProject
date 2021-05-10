package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.persistence.DBContract;
import com.com.food.persistence.DBInfo;
import com.com.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService {

	protected Connection dbConn;
	protected PreparedStatement pStr;

	public FoodServiceImplV1() {

		dbConn = DBContract.getDBConnection();
	}

	public List<FoodDTO> select(PreparedStatement pStr) throws SQLException {

		List<FoodDTO> fList = new ArrayList<>();
		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {

			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setF_code(rSet.getString(DBInfo.FOOD.f_code));
			foodDTO.setF_name(rSet.getString(DBInfo.FOOD.f_name));
			foodDTO.setF_date(rSet.getString(DBInfo.FOOD.f_date));
			foodDTO.setC_name(rSet.getString(DBInfo.FOOD.c_name));
			foodDTO.setT_name(rSet.getString(DBInfo.FOOD.t_name));
			foodDTO.setF_aps(rSet.getInt(DBInfo.FOOD.f_aps));
			foodDTO.setF_spc(rSet.getInt(DBInfo.FOOD.f_spc));
			foodDTO.setF_calories(rSet.getInt(DBInfo.FOOD.f_calories));
			foodDTO.setF_protein(rSet.getInt(DBInfo.FOOD.f_protein));
			foodDTO.setF_fat(rSet.getInt(DBInfo.FOOD.f_fat));
			foodDTO.setF_carbohydrate(rSet.getInt(DBInfo.FOOD.f_carbohydrate));
			foodDTO.setF_sugars(rSet.getInt(DBInfo.FOOD.f_sugars));
			fList.add(foodDTO);
		}
		rSet.close();
		return fList;
	}

	@Override
	public List<FoodDTO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품정보 ";

		pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> fList = this.select(pStr);
			pStr.close();
			return fList;
		} catch (SQLException e) {
			System.out.println("selectAll 오라클 연동 오류");
		}
		return null;
	}

	@Override
	public List<FoodDTO> findByFname(String f_name) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE " + DBInfo.FOOD.f_name;
		sql += " LIKE '%' || ? || '%' ";

		pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, f_name.trim());
			List<FoodDTO> fList = this.select(pStr);
			pStr.close();
			return fList;
		} catch (SQLException e) {
			System.out.println("findByFname 오라클 연동 오류");
		}
		return null;
	}

	@Override
	public int insert(FoodVO foodVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(FoodVO foodVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String f_code) {
		// TODO Auto-generated method stub
		return 0;
	}

}
