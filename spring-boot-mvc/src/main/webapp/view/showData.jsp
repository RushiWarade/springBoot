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
<body class="bg-light">


<div class="container p-5">
    <div class="row">
        <div class="col-md-10 offset-md-1">
            <div class="card shadow">
                <div class="card-header">
                    <%@include file="nav.jsp" %>
                    <form action="batchDelete" method="post">

                        <hr>
                        <div class="d-flex justify-content-between">
                            <p class="text-center fs-3 font-monospace">Student List</p>
                            <button class="btn btn-danger h-50" type="submit" id="delete-button" disabled><i
                                    class="bi bi-trash3"></i></button>
                        </div>
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

                        <%--                    <input type="submit" id="delete-button" value="Delete selected data" disabled>--%>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>

                            <th scope="col">Sr.No</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Mobile</th>
                            <th scope="col">Edit/Delete</th>
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
                                   class="btn btn-sm me-1 btn-success"><i class="bi bi-pencil"></i></a>
                                <input type="checkbox" id="select" name="selectedId"
                                       class="custom-checkbox p-2"
                                       onchange="updateButtonState()"
                                       value="<%=student.getId()%>">
                            </td>
                        </tr>

                        <%}%>

                        </tbody>
                    </table>

                    </form>


                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function updateButtonState() {
        var checkboxes = document.querySelectorAll('.custom-checkbox');
        var button = document.getElementById("delete-button");

        // Check if at least one checkbox is checked
        var atLeastOneChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);


        // If checkbox is checked, enable the button; otherwise, disable it
        button.disabled = !atLeastOneChecked;
    }
</script>

</body>
</html>
