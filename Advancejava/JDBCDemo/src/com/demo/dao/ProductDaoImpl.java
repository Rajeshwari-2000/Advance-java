package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProducttDao {
 static Connection conn;
 static PreparedStatement pstat, pdel, pupdate, pselect, pfindbyid, psortedbyname;
	static {
		try {
			conn = DButil.getMyConnection();
			pstat = conn.prepareStatement("insert into product1 values(?, ?, ?, ?, ?, ?)");
			pdel = conn.prepareStatement("delete from product1 where pid=?");
			pupdate = conn.prepareStatement("update product1 set qty=?, price=? where pid=?");
			pselect = conn.prepareStatement("select * from product1");
			pfindbyid = conn.prepareStatement("select * from product1 where pid=?");
			psortedbyname = conn.prepareStatement("select * from product1 order by pname");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean save(Product p) {
		try {
			pstat.setInt(1,p.getPid());
			pstat.setString(2, p.getPname());
			pstat.setInt(3, p.getQty());
			pstat.setDouble(4, p.getPrice());
			pstat.setDate(5, Date.valueOf(p.getExpDate()));
			pstat.setInt(6, p.getCid());
			int res = pstat.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int pid) {
		try {
			pdel.setInt(1, pid);
			int n = pdel.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateById(int pid, int qty, double price) {
		try {
		pupdate.setInt(1,qty);
		pupdate.setDouble(2,price);
		pupdate.setInt(1,pid);
		int r=pupdate.executeUpdate();
		if(r>0) {
			return true;
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public List<Product> findAllProducts() {
			List<Product> plst = new ArrayList<Product>();
			try {
				ResultSet rs = pselect.executeQuery();
				while(rs.next()) {
					Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6));
					plst.add(p);
				}
				if(plst.size()>0) {
					return plst;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}

	@Override
	public Product findById(int pid) {
		try {
			pfindbyid.setInt(1, pid);
			ResultSet rs = pfindbyid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
			
	}

	@Override
	public List<Product> getSortedByName() {
		List<Product>plst = new ArrayList<Product>();
		try {
			ResultSet rs = psortedbyname.executeQuery();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6));
				plst.add(p);
			}
			if(plst.size()>0) {
				return plst;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeConnection() {
		DButil.CloseMyConnection();
	}

}
