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
    <title>Login page</title>
    <%@include file="link.jsp" %>
</head>
<body class="bg-light">
<%@include file="nav.jsp" %>


<div class="conatiner p-3">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card shadow">
                <div class="card-header text-center">
                    <h3>Login Page</h3>

                </div>
                <div class="card-body">
                    <form action="studentLogin" method="post">

                        <div class="mb-3">
                            <label for="email">Enter Email</label> <input type="text" name="email" id="email" required
                                                                          class="form-control">
                        </div>

                        <div class="mb-3">
                            <label for="password">Enter Password</label> <input type="text" name="password" required
                                                                                id="password"
                                                                                class="form-control">
                        </div>

                        <button class="btn btn-primary col-md-12">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
