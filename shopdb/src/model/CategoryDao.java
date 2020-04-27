package model;

import java.sql.*;
import java.util.*;
import vo.*;

public class CategoryDao {

	public Category UpdateOne(Category categoryId) {
		ArrayList<Category> list = null;
		System.out.println(list + "ArrayList<Category>/CategoryDao");
		Connection conn = null;
		System.out.println(conn + "Connection conn/CategoryDao");
		PreparedStatement stmt = null;
		System.out.println(stmt + "PreparedStatement stmt/CategoryDao");
		ResultSet rs = null;
		System.out.println(rs + "ResultSet rs/CategoryDao");
		Category category = null;
		System.out.println(category + "Category category/CategoryDao");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb", "root", "java1234");
			System.out.println(conn + "conn/try/CategoryDao");
			stmt = conn.prepareStatement("update category set category_name=? where category_id=?");
			System.out.println(stmt + "stmt/try/CategoryDao");
			stmt.setInt(1, category.getCategoryId());
			stmt.setString(2, category.getCategoryName());
			rs = stmt.executeQuery();
			System.out.println(rs + "rs/try/CategoryDao");
			// rs.close(); // 남은 rs값을 정리함 다른코드랑 다르게 서버에서 받아오는거라서 직접 정리

			if (rs.next()) {
				category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return category;

	}

	public void insertCateogry(Category category) {
		// try catch 예외가 발생할 경우 사용 급작스러운 종료가 해야될때 catch 절에 오류메세지좀 보여주자
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb", "root", "java1234");
			stmt = conn.prepareStatement("insert into category(category_name) values(?)");
			stmt.setString(1, category.getCategoryName());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();// 콘솔창에 에러 메세지를 출력 해 주세요.
		} finally {// 문제가 있던 없던 실행 ㄱ
			try {
				conn.close();
				stmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Category> selectCategoryListAll() {
		ArrayList<Category> list = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb", "root", "java1234");
			PreparedStatement stmt = conn.prepareStatement("select * from category");
			ResultSet rs = stmt.executeQuery();
			// rs.close(); // 남은 rs값을 정리함 다른코드랑 다르게 서버에서 받아오는거라서 직접 정리
			list = new ArrayList<Category>();
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Category selectCategoryOne(int categoryId) {		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		Category category = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb", "root", "java1234");
			stmt = conn.prepareStatement("select * from category where category_id=?");
			stmt.setInt(1, categoryId);
			rs = stmt.executeQuery();
			// rs.close(); // 남은 rs값을 정리함 다른코드랑 다르게 서버에서 받아오는거라서 직접 정리			
			if (rs.next()) {
				category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 문제가 있던 없던 실행 ㄱ
			try {
				conn.close();
				stmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return category;
	}
	
}
