package com.nonage.action.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.AdminOrderDAO;
import com.nonage.dao.OrderDAO;
import com.nonage.dao.impl.AdminOrderDAOImpl;
import com.nonage.dao.impl.OrderDAOImpl;

public class AdminOrderSaveAction implements com.nonage.action.Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String url = "redirect:OrderList.do";
      
      String[] resultArr = request.getParameterValues("result");
      
      for(String oseq:resultArr){
        System.out.println(oseq);
        /*OrderDAO orderDAO = OrderDAO_JDBC.getInstance();*/
        AdminOrderDAO orderDAO = AdminOrderDAOImpl.getInstance();
        try {
			orderDAO.updateOrderResult(oseq);
		} catch (SQLException e) {		
			e.printStackTrace();
		}
      }
      return url;
    }
}
