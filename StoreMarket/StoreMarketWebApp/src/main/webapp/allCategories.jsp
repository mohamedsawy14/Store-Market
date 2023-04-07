<%-- 
    Document   : allCategories
    Created on : Feb 17, 2023, 11:33:49 PM
    Author     : Administrator
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.seniorsteps.storemarket.dal.hibernate.entity.Catagories"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale.Category"%>
<%@page import="com.seniorsteps.storemarket.bll.BusinessLogicCore"%>
<%! 
BusinessLogicCore blc;
Catagories category = new Catagories();
//String id;
%>
<% 
    List<Catagories> categories = new ArrayList<>();
    try{
 //   category.setId(id);
    blc = new BusinessLogicCore();
    categories=blc.findAllcategory();
   // blc.deletecategory(category, id);
    }catch(Exception e){
    
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello </h1>
        <table boreder="4" >
            <tr>
                <th>ID</th>
                <th>NAme</th>
                <th>Description</th>
                <th>Action</th>
                
            </tr>
        <% for (Catagories icategory : categories) {%>
    <tr>
        <td> <%=icategory.getId() %>  </td>
        <td> <%=icategory.getName() %>  </td>
        <td> <%=icategory.getDecription() %>  </td>
        <td>
    <a href="DeleteCategoryServlet?id=<%=icategory.getId() %>">Delete</a>
        </td>
    </tr>    
        <%} %>
        </table>
    </body>
</html>
