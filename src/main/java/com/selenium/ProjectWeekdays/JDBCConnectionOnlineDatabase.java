package com.selenium.ProjectWeekdays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionOnlineDatabase {
	/*
	 * <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
	 * <dependency> <groupId>mysql</groupId>
	 * <artifactId>mysql-connector-java</artifactId> <version>8.0.16</version>
	 * </dependency>
	 */
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://sql12.freesqldatabase.com:3306/sql12312815", "sql12312815","3kfmt4VAzZ");

			System.out.println("connected");

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("select * from customers where customerNumber=112");

			while (rs.next()) {
				String name = rs.getString("customerName");
				int code = rs.getInt("postalCode");
				System.out.println("Name is : " + name);
				System.out.println("Postal code is : " + code);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("connection ended");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
