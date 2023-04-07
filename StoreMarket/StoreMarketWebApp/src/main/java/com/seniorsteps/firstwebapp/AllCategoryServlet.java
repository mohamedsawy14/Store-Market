/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.firstwebapp;

import com.seniorsteps.storemarket.bll.BusinessLogicCore;
import com.seniorsteps.storemarket.dal.hibernate.entity.Catagories;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class AllCategoryServlet extends HttpServlet {

    private static BusinessLogicCore blc;

    static {

        try {
            blc = new BusinessLogicCore();

        } catch (Exception e) {

        }

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        //    String id = request.getParameter("id");
            
            out.println(prepareHeader());
                

            try {


                java.util.List<Catagories> categories = blc.findAllcategory();

                out.println("<table border>");
                out.println("<tr>");
                out.println("<th>ID </th>");
                out.println("<th>Name </th>");
                out.println("<th>Description </th>");
                out.println("<th>Actions </th>");
                out.println("</tr>");

                for (Catagories category : categories) {
                    out.println("<tr>");
                    out.println("<td>" + category.getId() + "</td>");
                    out.println("<td>" + category.getName() + "</td>");
                    out.println("<td>" + category.getDecription() + "</td>");
                out.println("<td> <a href=\"DeleteCategoryServlet?id="+category.getId()+"\">Delete</a></td>");
                    out.println("</tr>");

                }
                out.println("</table>");
            } catch (Exception e) {

                out.println(prepareErrorMessage(e.getMessage()));
            }

            /* TODO output your page here. You may use following sample code. */
            //      out.println("<h1>Servlet FirstServlet at " + request.getContextPath() + "</h1>");
            out.println(prepareFooter());

        }
    }

    private String prepareErrorMessage(String error) {

        return "<h2 style='color:red;'>Error : " + error + " </h2>";
    }

    private String prepareSuccesMessage(String newid) {

        return "<h2>Success added seccefully with ID : " + newid + "</h2>";
    }

    private String prepareHeader() {
        String header = "";
        header += "<!DOCTYPE html>";
        header += "<html>";
        header += "<head>";
        header += "<title>Servlet FirstServlet</title>";
        header += "</head>";
        header += "<body>";
        return header;

    }

    private String prepareFooter() {
        String footer = "";
        footer += "</body>";
        footer += "</html>";

        return footer;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
