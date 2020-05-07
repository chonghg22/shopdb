package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import vo.Category;
@WebServlet("/InsertCategory") //이 클래스의 주소 
public class InsertCategory extends HttpServlet{
	//InsertCategory요청이 get방식일때 - > 입력폼을 보여줌 
	@Override // controller - view 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/views/insertCategory.jsp").forward(request, response);      
	}
	//InsertCategory요청이 post방식일때 -> 입력 
	@Override // controller - model
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	//1. 요청분석 (input에서 카테고리 아이디값이 넘오익 때문에 request분석을 해야하며 주소 분석도 해야함)
	request.setCharacterEncoding("utf-8");
	
	String categoryName = request.getParameter("categoryName");
	
	System.out.println(categoryName + "<--categoryName");
	//2. 모델 호출
	Category category = new Category();
	category.setCategoryName(categoryName);
	CategoryDao categoryDao = new CategoryDao();
	
	categoryDao.insertCateogry(category);
	//3.뷰 연결 or 다른 컨트롤러를 리다이렉트 해야한다.insert가 없는 이유는?
	response.sendRedirect(request.getContextPath() + "/CategoryList");
	}
}
//do get 입력값을 보여주느것

//do post 입력값을 보내는것 



