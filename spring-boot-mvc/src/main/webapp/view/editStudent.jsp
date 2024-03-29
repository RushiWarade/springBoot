<%@ page import="org.example.springbootmvc.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");
%>
<div class="container p-3">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-header text-center">
                    <h3>Update Student</h3>
                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/edit/<%=student.getId()%>" method="post">
                        <div class="mb-3">
                            <label for="fname">Enter First Name</label>
                            <input type="text" id="fname" value="<%=student.getFname()%>" required
                                   name="fname" class="form-control">
                        </div>
                        <div class="mb-3">
                            <labelam for="lname">Enter Last Name</labelam>
                            <input type="text" id="lname" value="<%=student.getLname()%>"
                                   name="lname" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label for="email">Enter Email</label> <input type="text" name="email" id="email" readonly
                                                                          value="<%=student.getEmail()%>"
                                                                          class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="mobile">Enter Mobile Number</label> <input type="tel" name="mobile" id="mobile"
                                                                                   value="<%=student.getMobile()%>"
                                                                                   required
                                                                                   class="form-control">
                        </div>

                        <input type="hidden" name="password"
                               value="<%=student.getPassword()%>"
                               class="form-control">

                        <button class="btn btn-primary col-md-12">Update</button>

                        <div class="text-center mt-2">
                            Return Back <a href="/">click here</a>
                        </div>


                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
