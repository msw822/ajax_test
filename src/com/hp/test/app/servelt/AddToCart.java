package com.hp.test.app.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.hp.test.app.beans.ShoppingCart;

/**
 * Servlet implementation class AddToCart
 */
//@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1,获取请求参数 bookName price
		String bookName =  request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		//2,获取购物车对象
		HttpSession session = request.getSession();
		ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");
		
		if(sc==null){
			sc = new ShoppingCart();
			session.setAttribute("sc", sc);
		}
		
		//3，把点击的选项加入购物车
		sc.addCart(bookName, price);
		
		//4,准备响应Json对象
		
		ObjectMapper mapper =  new ObjectMapper();		
		String result = mapper.writeValueAsString(sc);
		response.getWriter().println(result);
	}

}
