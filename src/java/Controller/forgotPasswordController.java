/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.MD5;
import DAO.UserDao;
import Model.Email;
import Model.EmailUtils;
import Model.User;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;
/**
 *
 * @author ngock
 */
@WebServlet(name="forgotPasswordController", urlPatterns={"/forgotPasswordController"})
public class forgotPasswordController extends HttpServlet {
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
    } 

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                       
                        RequestDispatcher dispatcher = null;
        try {
                        int otpvalue = 0;
                        
                        String fullname = request.getParameter("fullname");
                        String emailAddress = request.getParameter("email");
			HttpSession mySession = request.getSession();
			UserDao udao = new UserDao();
			User user = udao.checkUserExistByFullNameAndEmail(fullname, emailAddress);
			if(user == null) {
				request.setAttribute("error", "Email hoac username sai!");
			}
                        else {
                             
                // sending otp
                                Random rand = new Random();
                                otpvalue = rand.nextInt(1255650);
				Email email =new Email();
				email.setFrom("mirano12121212@gmail.com");
				email.setFromPassword("tszeaqvxuewzzdbv");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(fullname).append("<br>");
				sb.append("You are used the forgot password. <br> ");
				sb.append("Your otp is <b>").append(otpvalue).append(" </b> <br>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				request.setAttribute("mess", "Ma otp da duoc gui den email cua ban!");
                                dispatcher = request.getRequestDispatcher("enterOtp.jsp");
                                mySession.setAttribute("otp", otpvalue);
                                mySession.setAttribute("email", emailAddress);
                                
                                dispatcher.forward(request, response);
                                
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    
    }


}
