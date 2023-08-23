package jdbc_ex;

import java.sql.Connection;

import common.JDBCUtil;

public class ConnectionTest {

	public static void main(String[] args) {
		try (Connection conn = JDBCUtil.getConnection()) {
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
