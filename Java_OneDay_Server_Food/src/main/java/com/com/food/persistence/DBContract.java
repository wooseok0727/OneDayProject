package com.com.food.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn = null;

	static {

		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "food";
		String password = "food";

		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("오라클 접속 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 Driver 찾을 수 없음");
		} catch (SQLException e) {
			System.out.println("오라클 연동 실패");
		}
	} // end static

	public static Connection getDBConnection() {
		return dbConn;
	}
}
