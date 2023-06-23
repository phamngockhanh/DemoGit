/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.UserDao;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name="validateRegisController", urlPatterns={"/validateRegisController"})
public class validateRegisController extends HttpServlet {
   
 
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
            int value = Integer.parseInt(request.getParameter("otp"));
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("name");
            String emailAddress = (String) session.getAttribute("emailAddress");
            String pass = (String)session.getAttribute("pass");
            String rePass = (String)session.getAttribute("rePass");
            String phone=(String) session.getAttribute("phone");
            String address= (String) session.getAttribute("address");
            boolean gender = request.getParameter("gender").equals("true") ? true : false;
            
            int otp = (int)session.getAttribute("otp");
            UserDao db = new UserDao();
            User u = db.findUser(emailAddress);
            RequestDispatcher dispatcher = null;
            if(value==otp){
                
                db.register(name, emailAddress, pass, gender, phone, address, 1);
                dispatcher=request.getRequestDispatcher("loginjsp.jsp");
                dispatcher.forward(request, response);
            }
            else
		{
			request.setAttribute("message","wrong otp");
                     dispatcher=request.getRequestDispatcher("confirmRegisOtp.jsp");
			dispatcher.forward(request, response);
		
		}
        }

}
