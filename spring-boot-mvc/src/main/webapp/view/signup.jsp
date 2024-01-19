<%--
  Created by IntelliJ IDEA.
  User: rushi
  Date: 17-01-2024
  Time: 07:09 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup page</title>
    <%@include file="link.jsp" %>
</head>
<body class="bg-light">

<div class="container p-5">
    <div class="row">
        <div class="col-md-10 offset-md-1">
            <div class="card shadow">
                <div class="card-header ">
                    <%@include file="nav.jsp" %>
                    <p class="text-center fs-3 font-monospace">Register page</p>
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
                <div class="card-body ">
                    <form action="register" method="post" class="">
                        <div class="mb-3  ">
                            <label for="fname">Enter First Name</label>
                            <input type="text" id="fname" required
                                   name="fname" class="form-control">
                        </div>
                        <div class="mb-3 ">
                            <labelam for="lname">Enter Last Name</labelam>
                            <input type="text" id="lname"
                                   name="lname" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label for="email">Enter Email</label> <input type="text" name="email" id="email" required
                                                                          class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="mobile">Enter Mobile Number</label> <input type="tel" name="mobile" id="mobile"
                                                                                   required
                                                                                   class="form-control">
                        </div>


                        <div class="mb-3">
                            <label for="pass">Enter Password</label> <input type="text" name="password" id="pass"
                                                                            required
                                                                            class="form-control">
                        </div>

                        <button class="btn btn-primary col-md-12">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
