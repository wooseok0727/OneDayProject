package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.MyFoodDTO;
import com.com.food.model.MyFoodVO;
import com.com.food.persistence.DBContract;
import com.com.food.persistence.DBInfo;
import com.com.food.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService {

	protected Connection dbConn;
	protected PreparedStatement pStr;
	
	public MyFoodServiceImplV1() {
		
		dbConn = DBContract.getDBConnection();
	}
	
	public List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException {
		
		List<MyFoodDTO> mfList = new ArrayList<>();
		ResultSet rSet = pStr.executeQuery();
		
		while(rSet.next()) {
			MyFoodDTO myfoodDTO = new MyFoodDTO();
			myfoodDTO.setMf_date(rSet.getString(DBInfo.MYFOOD.mf_date));
			myfoodDTO.setF_name(rSet.getString(DBInfo.MYFOOD.f_name));
			myfoodDTO.setMf_intake(rSet.getInt(DBInfo.MYFOOD.mf_intake));
			myfoodDTO.setMf_spc(rSet.getInt(DBInfo.MYFOOD.mf_spc));
			myfoodDTO.setMf_calories(rSet.getInt(DBInfo.MYFOOD.mf_calories));
			myfoodDTO.setMf_protein(rSet.getInt(DBInfo.MYFOOD.mf_protein));
			myfoodDTO.setMf_fat(rSet.getInt(DBInfo.MYFOOD.mf_fat));
			myfoodDTO.setMf_carbohydrate(rSet.getInt(DBInfo.MYFOOD.mf_carbohydrate));
			myfoodDTO.setMf_sugars(rSet.getInt(DBInfo.MYFOOD.mf_sugars));
			mfList.add(myfoodDTO);
		}
		rSet.close();
		return mfList;
	}
	
	@Override
	public List<MyFoodDTO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품섭취정보 ";
		
		pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> mfList = this.select(pStr);
			pStr.close();
			return mfList;
		} catch (SQLException e) {
			System.out.println("selectAll 오라클 연동 오류");
		}
		return null;
	}

	@Override
	public List<MyFoodDTO> findByDate(String mf_date) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품섭취정보 ";
		sql += " WHERE " + DBInfo.MYFOOD.mf_date + " = ? ";
		
		pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, mf_date.trim());
			List<MyFoodDTO> mfList = this.select(pStr);
			pStr.close();
			return mfList;
		} catch (SQLException e) {
			System.out.println("findBydate 오라클 연동 오류");
		}
		return null;
	}

	@Override
	public int insert(MyFoodVO myfoodVO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_myfoods ";
		sql += "(mf_seq, mf_date, mf_pcode, mf_intake) ";
		sql += " VALUES(seq_myfoods.NEXTVAL, ?, ?, ?) ";
		
		pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myfoodVO.getMf_date());
			pStr.setString(2, myfoodVO.getMf_pcode());
			pStr.setInt(3, myfoodVO.getMf_intake());
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
		} catch (SQLException e) {
			System.out.println("insert 오라클 연동 오류");
		}
		return 0;
	}

	@Override
	public int update(MyFoodVO myfoodVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return 0;
	}
}
