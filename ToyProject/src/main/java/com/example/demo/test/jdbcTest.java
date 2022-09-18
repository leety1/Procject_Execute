package com.example.demo.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class jdbcTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("SUCCESSSSS");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521/orcl",
						"system",
						"@$!@$!@")){
			System.out.println(con+"SUCCESS");
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
