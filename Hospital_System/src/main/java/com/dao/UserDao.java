package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;
import com.mysql.cj.protocol.Resultset;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	

	public boolean register(User u)
	{
		boolean f=false;
		
		try {
			String sql="insert into user_dtls(full_name,email,password) valuse(?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, u.getFullName());
			ps.setString(2, u.getEmail());
			ps.setString(3,u.getPassword());
			
			
			int i=ps.executeUpdate();	
			
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			
		}
		return f;
	}
	
	public User login(String email,String password)
	{
		User u=null;
		try {
			String sql="select* from user_dtls where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			u=new User();
			u.setId(rs.getInt(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	
}
