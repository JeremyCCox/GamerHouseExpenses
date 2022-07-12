package com.gamerhouse.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gamerhouse.beans.*;

/**
 * Servlet implementation class CalculateExpences
 */
@WebServlet("/CalculateExpences")
public class CalculateExpences extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateExpences() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/expenseReport.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Payee> payees = new ArrayList<Payee>();
		String many = request.getParameter("peopleQuantity");
		
		if(!many.equals(null)) {
			int quantity = Integer.parseInt(many);
			int count=0;
			
			double totalRent = Double.parseDouble(request.getParameter("totalRent"));
			double totalUtils = Double.parseDouble(request.getParameter("totalUtils"));
			double totalExpenses = Double.parseDouble(request.getParameter("totalExpenses"));
			double manyRent=0;
			double manyUtils=0;
			double manyExpenses=0;
			
			double[][]payTable = new double[3][quantity];
			do {
				
				Payee payee = new Payee();
				payees.add(payee);
				System.out.println(request.getParameter("person"+(count+1)));
				payee.setName(request.getParameter("person"+(count+1)));
				if(!(request.getParameter("rent"+(count+1)) == (null))) {
					payTable[0][count] = 1;
					payee.setRent(1);
					manyRent++;
				}else{
					payTable[0][count] = 0;
				}
				if(!(request.getParameter("utils"+ (count+1)) == (null))){
					payTable[1][count] = 1;
					payee.setUtils(1);
					manyUtils++;
				}else{
					payTable[1][count] = 0;
				}
				if(!(request.getParameter("expenses"+(count+1)) == (null))) {
					payTable[2][count] = 1;
					payee.setExpenses(1);
					manyExpenses++;
				}else{
					payTable[2][count] = 0;
				}
				count ++;
			}while(count < quantity);
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < quantity; j++) {
					switch(i) {
					case(0):
						payTable[i][j] = payTable[i][j] * totalRent/manyRent;
						payees.get(j).setRent(payTable[i][j]);
						break;
					case(1):
						payTable[i][j] = payTable[i][j] * totalUtils/manyUtils;
						payees.get(j).setUtils(payTable[i][j]);
						break;
					case(2):
						payTable[i][j] = payTable[i][j] * totalExpenses/manyExpenses;
						payees.get(j).setExpenses(payTable[i][j]);
						break;
					}
				}
			}
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < quantity; j++) {
					System.out.print("   "+payTable[i][j]+"   ");
				}
				System.out.println("");
			}
			for(int j = 0; j < quantity; j++) {
				System.out.println(payees.get(j).toString());
			}
			
		}
		request.getRequestDispatcher("WEB-INF/expenseReport.jsp").forward(request, response);
	}

}
