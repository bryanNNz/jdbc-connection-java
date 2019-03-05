package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DB;
import database.DBException;

public class App {

	public static void main(String[] args) {
		Connection conn = DB.getInstance();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM seller");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
		} 
		catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		
		DB.closeStatement(st);
		DB.closeResultSet(rs);
		DB.closeDB();
	}

}
