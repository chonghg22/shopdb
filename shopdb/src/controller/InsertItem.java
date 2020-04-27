package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import model.ItemDao;
import vo.Category;
import vo.Item;

import java.util.*;
/**
 * Servlet implementation class InsertItem
 */
@WebServlet("/InsertItem")
public class InsertItem extends HttpServlet {
	private ItemDao itemDao;
	private CategoryDao categoryDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.categoryDao = new CategoryDao();
	List<Category> list = this.categoryDao.selectCategoryListAll();		
	request.setAttribute("list", list);		
	request.getRequestDispatcher("/WEB-INF/jsp/insertItem.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}
}
