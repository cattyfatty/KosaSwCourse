package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Account;
import dao.AccountDao;
import dao.ConnectionManager;

public class BankService {
	public void transfer(int from, int to, int amount) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			conn.setAutoCommit(false);
			
			AccountDao ac = new AccountDao(conn);
			
			Account fromA = ac.selectByPk(from);
			Account toA = ac.selectByPk(to);
			
			fromA.setBalance(fromA.getBalance() - amount);
			int rows = ac.update(fromA);
			
			toA.setBalance(toA.getBalance() + amount);
			rows = ac.update(toA);
			
			conn.commit();
			System.out.println("successful transfer");
			
		} catch (Exception e) {
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			System.out.println("failed transfer");
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
