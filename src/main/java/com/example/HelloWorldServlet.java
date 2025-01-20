package com.example;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    private final HelloWorld helloWorld = new HelloWorld();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String message = helloWorld.sayHello(name);

        request.setAttribute("message", message);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
