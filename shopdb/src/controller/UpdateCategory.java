package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import vo.Category;

/**
 * protected는 톰켓일때만 사용가능
 */
@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
     public CategoryDao categoryDao;
     public ArrayList<Category> category = null;
    //수정폼 (c-m-v)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println(categoryId + "<--UpdateCategory/doGet/categoryId");    	
    	this.categoryDao = new CategoryDao();
    	Category category = new Category();
    	category = categoryDao.selectCategoryOne(categoryId);
    	request.setAttribute("c", category);
    	//view forward
    	request.getRequestDispatcher("/WEB-INF/views/updateCategory.jsp").forward(request, response);
    }
    //수정 액션 (c-m) ->리다이렉트
    //dopost에는 인코딩 받는 코드가 있어야함
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("cateogryName");
		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
		
		this.categoryDao = new CategoryDao();
		
		response.sendRedirect(request.getContextPath()+"/CateogryList");
	}

}
