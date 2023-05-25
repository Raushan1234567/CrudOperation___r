package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.dto.Medicine;
import com.exception.NorecordFound;
import com.exception.SomethingWentWrong;


public class ServiceImple implements Inter{

	@Override
	public void Add(Medicine a) throws SomethingWentWrong {
		
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			String q="create table if not exists Medicine (med_id varchar(4) primary key, name varchar(20) unique not null,company1 varchar(20) not null, price_per_unit DECIMAL(6,2) not null, MfgDate date, ExpDate date)";
			
			PreparedStatement p=c.prepareStatement(q);
			p.executeUpdate();
			
			String qw="insert into medicine values(?,?,?,?,?,?)";
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setString(1, a.getId());
			ps.setString(2, a.getName());
			ps.setString(3, a.getCompany());
			ps.setDouble(4, a.getPrice());
			ps.setDate(5, Date.valueOf(a.getMfgdate()));
			ps.setDate(6, Date.valueOf(a.getExpdate()));
			
			
			ps.executeUpdate();
			System.out.println("Added Success");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			
			throw new SomethingWentWrong("Some thing wenr wrong");
			
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void Update(Medicine a) throws SomethingWentWrong {

		Connection c=null;
		
		try {
			c=Connect.getco();
			
			
			String qw="update medicine set name=?,company1=?,price_per_unit=?,MfgDate=?,ExpDate=? where med_id=?";
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setString(6, a.getId());
			ps.setString(1, a.getName());
			ps.setString(2, a.getCompany());
			ps.setDouble(3, a.getPrice());
			ps.setDate(4, Date.valueOf(a.getMfgdate()));
			ps.setDate(5, Date.valueOf(a.getExpdate()));
			
			
			if(ps.executeUpdate()>0) {
			System.out.println("Update Success");}
			else {
				System.out.println("Not updated");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			
			throw new SomethingWentWrong("Some thing wenr wrong");
			
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void Deletd(String id) throws SomethingWentWrong {
		
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			String q="Delete from medicine where med_id=?";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ps.setString(1, id);
			
			if(ps.executeUpdate()>0) {
				System.out.println("deleted Sucessfully");
			}else {
				System.out.println("Not Delete");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrong("Some thinf went wrong");
		}
		
	}

	@Override
	public List<Medicine> View() throws NorecordFound {
		Connection c=null;
	
		List<Medicine> med=new ArrayList<>();
		
		
		try {
			c=Connect.getco();
			String q="select * from medicine";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ResultSet rs=ps.executeQuery();
			
			if(isempty(rs)) {
				
				throw new NorecordFound("not able rto fetch data");
			}else {
				while(rs.next()) {
					med.add(new Medicine(rs.getNString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),LocalDate.parse(rs.getString(5)),LocalDate.parse(rs.getString(6))));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return med;
	}

	private boolean isempty(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return (!rs.isBeforeFirst() && rs.getRow() == 0);
	}
	

}
