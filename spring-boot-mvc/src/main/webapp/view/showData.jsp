<%@ page import="org.example.springbootmvc.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rushi
  Date: 17-01-2024
  Time: 07:47 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All data</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>


<div class="container p-5">
    <div class="row">
        <div class="col-md-10 offset-md-1">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Student List</p>
                   <%-- <div class="text-center">
                        <a class="" href="batchDelete">delete</a>
                    </div>--%>
                    <%--                    print message from session     --%>
                    <%
                        String msg = (String) session.getAttribute("msg");
                        if (msg != null) {
                    %>
                    <div class="alert alert-warning alert-dismissible fade show text-center" role="alert">
                        <strong><%=msg%>!</strong>
                        <button type="button" class="btn-close" data-bs-dismiss="alert"
                                aria-label="Close"></button>
                    </div>
                    <%
                        }
                        session.removeAttribute("msg");
                    %>


                </div>
                <div class="card-body">

                    <form action="batchDelete" method="post">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">Select</th>
                                <th scope="col">Sr.No</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Mobile</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                List<Student> studentList = (List<Student>) request.getAttribute("allData");
                                int srNo = 1;
                                for (int i = 0; i < studentList.size(); i++) {
                                    Student student = studentList.get(i);
                            %>

                            <tr>
                                <th scope="col"><input type="checkbox" id="select" name="selectedId"
                                                       value="<%=student.getId()%>"></th>
                                <th scope="col"><%=srNo%>
                                </th>
                                <%srNo++;%>
                                <td><%=student.getFname()%>
                                </td>
                                <td><%=student.getLname()%>
                                </td>
                                <td><%=student.getEmail()%>
                                </td>
                                <td><%=student.getMobile()%>

                                <td class="d-flex">
                                    <%--                                edit and delete expense buttons--%>

                                    <a href="edit/<%=student.getId()%>"
                                       class="btn btn-sm me-1 btn-success">Edit</a>
                                    <a href="delete/<%=student.getId()%>"
                                       class="btn btn-sm me-1 btn-danger">Delete</a>


                                </td>
                            </tr>

                            <%}%>

                            </tbody>
                        </table>
                        <input type="submit" value="Delete selectd data">
                    </form>


                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
