package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import vo.*;

	public class ItemDao {
	

	
	public List<Item> selectItemListAll(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Item item = null;
		List<Item> list = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb","root","java1234");
			stmt = conn.prepareStatement("select * from item");
			rs = stmt.executeQuery();
			list = new ArrayList<Item>();			
			while(rs.next()) {
			item = new Item();
			item.setCategoryId(rs.getInt("category_id"));
			item.setItemContents(rs.getString("item_contents"));
			item.setItemId(rs.getInt("item_id"));
			item.setItemName(rs.getString("item_name"));
			item.setItemPrice(rs.getInt("item_price"));
			list.add(item);
			}
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}
			return list;
		}
		
	
	

	public Item selectOne() {
		return null;
	}

	public void insertItem(Item item) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb","root","java1234");
		stmt = conn.prepareStatement("insert into item(category_id, item_name, item_price, item_contents) values(?,?,?,?) ");
		stmt.setInt(1, item.getCategoryId());
		stmt.setString(2, item.getItemName());
		stmt.setInt(3,  item.getItemPrice());
		stmt.setString(4, item.getItemContents());
		
		
		stmt.executeUpdate();
	}catch(Exception e) {
		
		e.printStackTrace();
	}finally {// 문제가 있던 없던 실행 ㄱ
		try {
			conn.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


	public void updateItem(Item item) {

	}
}
