package com.suyash586;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suyash on 15-09-2015.
 */
@WebServlet(name = "DogServlet", urlPatterns = {"/dog"}, loadOnStartup = 1)
public class DogServlet extends HttpServlet {

    private static List<Dog> dogsList = new ArrayList<Dog>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String breed = request.getParameter("breed");
        dogsList.add(Dog.instanceByBreed(breed));

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, List of dogs found yet</h1>");

        dogsList.forEach(dog -> out.println(dog.toString() + ",<br/>"));


        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<a href=\"/\" >Back</a>");

    }

}
