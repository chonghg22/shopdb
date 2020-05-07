package controller;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.*;
import model.CategoryDao;
import model.ItemDao;


@WebServlet("/ItemList")
public class ItemList extends HttpServlet {

    private ItemDao itemDao;
    private CategoryDao categoryDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.itemDao = new ItemDao();
	this.categoryDao = new CategoryDao();
	List<Item> list = this.itemDao.selectItemListAll();
	request.setAttribute("list", list);
	request.getRequestDispatcher("/WEB-INF/views/itemList.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	String itemName = request.getParameter("itemName");
	int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
	String itemContents = request.getParameter("itemContents");
	Item item = new Item();
	item.setCategoryId(categoryId);
	item.setItemName(itemName);
	item.setItemPrice(itemPrice);
	item.setItemContents(itemContents);
	this.itemDao = new ItemDao();
	
	this.categoryDao = new CategoryDao();
	itemDao.insertItem(item); 
	response.sendRedirect(request.getContextPath() + "/ItemList");	
	}

}
