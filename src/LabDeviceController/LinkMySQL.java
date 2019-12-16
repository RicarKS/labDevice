package LabDeviceController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class LinkMySQL {
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/lab?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=true";
	private String user = "root";
	private String password = "www164105";
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	public LinkMySQL() {
		try {
       	 Class.forName(getDriverName());
         con=DriverManager.getConnection(url,user, password);
       }
       catch(java.lang.ClassNotFoundException | SQLException e) {
           System.err.println("Driver loading error: " + e.getMessage());
       }
	}
	private String getDriverName() {
		// TODO 自动生成的方法存根
		return driverName;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Statement getSt() {
		return st;
	}
	public void setSt(Statement st) {
		this.st = st;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public String judgeInformation() {
		rs=null;
		String date=null;
		String queryStr="select * from classschdule";
		try {
			Statement stmt = con.createStatement();
		    rs = stmt.executeQuery(queryStr);
		    String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("insert_dt"));
		    while( rs.next() ) {
		    	
		    }
		}
	}
}
