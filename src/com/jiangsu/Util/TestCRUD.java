package com.jiangsu.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class TestCRUD {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<user>  list = qr.query("select * from users",new ResultSetHandler<List<user>>(){
			public List<user> handle(ResultSet rs) throws SQLException {
				//当query方法执行select语句之后，将结果返回
				List<user> list = new ArrayList<user>();
				while (rs.next()) {
					user u = new user();
					u.setId(rs.getInt(1));
					u.setName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setBirthday(rs.getString(5));
					list.add(u);
				}
				return list;
			}
		});
		
		for(user u : list){
			System.out.println(u);
		}
		
	}

}
