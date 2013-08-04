package com.chuangfa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDispatcher extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 8482298381203614318L;

    /**
     * Constructor of the object.
     */
    public LoginDispatcher(){
        super();
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
