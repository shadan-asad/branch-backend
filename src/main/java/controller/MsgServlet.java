package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserMsgDao;
import model.UserMsg;

/**
 * Servlet implementation class MsgServlet
 */
@WebServlet("/")
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserMsgDao userMsgDao;
	private Gson gson;
	private String JSONresponse;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.userMsgDao = new UserMsgDao();
        this.gson  = new Gson();
        this.JSONresponse = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		
		switch(action) {
		case "/fetch":
			try {
				fetchMsg(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "/getUsers":
			try {
				getUsers(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
		
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(JSONresponse);
		JSONresponse = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void fetchMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 ArrayList<UserMsg> in = null;
		 in = userMsgDao.fetchMsg();
		 JSONresponse = gson.toJson(in);
		 System.out.println(JSONresponse);
	 }
	
	private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 ArrayList<Integer> in = null;
		 in = userMsgDao.getUsers();
		 JSONresponse = gson.toJson(in);
		 System.out.println(JSONresponse);
	 }

}
