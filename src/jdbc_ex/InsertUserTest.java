package jdbc_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCUtil;

public class InsertUserTest {

	public static void main(String[] args) {
		String sql = "insert into users(id, password, name, role) " + "values(?, ?, ?, ?)";

		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "ssamz22");
			pstmt.setString(2, "ssamz123");
			pstmt.setString(3, "와쌘즈");
			pstmt.setString(4, "ADMIN");

			int count = pstmt.executeUpdate();

			System.out.println(count + "건 데이터 처리 성공!");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
