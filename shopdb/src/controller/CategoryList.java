package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import vo.Category;
@WebServlet("/CategoryList")
public class CategoryList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//controller 분석
		 //1)request �м�
		System.out.println(request.getRemoteAddr());
		 //2)model 호출
		CategoryDao categoryDao = new CategoryDao();
		
		ArrayList<Category> list = categoryDao.selectCategoryListAll();
		System.out.println(list.size());
		request.setAttribute("list", list);
		//3)view 연결
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/categoryList.jsp");
		
		rd.forward(request, response);
		
	}
	
}
