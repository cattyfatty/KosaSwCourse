package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

	private Connection conn;
	
	public AccountDao(Connection conn) {
		this.conn = conn;
	}
	
	public int update(Account a) throws SQLException{
		int rows = 0;
		String sql = "UPDATE accounts SET account_balance=? WHERE account_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, a.getBalance());
		pstmt.setInt(2, a.getNo());
		
		rows = pstmt.executeUpdate();
		if(rows < 1) {
			System.out.println("failed");
		}
		
		return rows;
	}
	
	public Account selectByPk(int accountNo) throws SQLException {
		Account a = null;
		String sql = "SELECT * FROM accounts WHERE account_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, accountNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			a = new Account();
			a.setNo(rs.getInt("account_no"));
			a.setBalance(rs.getInt("account_balance"));
			a.setOwner(rs.getString("account_owner"));
		}
		
		return a;
	}
}
