package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.Doctor;

public class DoctorDoa {

	private Connection conn;

	public DoctorDoa(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerDoctor(Doctor d) {

		boolean f = false;
		try {
			String sql = "insert into doctor(full_Name,dob,qualification,specialist,email,mobno,password)values(?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, d.getFullName());
            ps.setString(2, d.getDob());
            ps.setString(3, d.getQualification());
            ps.setString(4, d.getSpecialist());
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getMobno());
            ps.setString(7, d.getPassword());
            int i=ps.executeUpdate();
            if(i==1)
            {
            	f=true;
        
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}
}
