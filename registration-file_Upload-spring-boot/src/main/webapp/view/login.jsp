<%--
  Created by IntelliJ IDEA.
  User: rushi
  Date: 23-01-2024
  Time: 12:35 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3 font-monospace">Validate User</p>

                    <%
                        String success = (String) session.getAttribute("success");
                        String danger = (String) session.getAttribute("danger");
                    %>
                    <%
                        if (success != null) {%>
                    <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
                        <strong><%=success%>
                        </strong>
                        <button type="button" class="btn-close" data-bs-dismiss="alert"
                                aria-label="Close"></button>
                    </div>
                    <%
                        }
                        if (danger != null) {
                    %>
                    <div class="alert alert-danger alert-dismissible fade show text-center" role="alert">
                        <strong><%=danger%>
                        </strong>
                        <button type="button" class="btn-close" data-bs-dismiss="alert"
                                aria-label="Close"></button>
                    </div>
                    <%
                        }
                        session.removeAttribute("success");
                        session.removeAttribute("danger");
                    %>

                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/register/profile" method="post">
                        <div class="row g-3">
                            <div class="col col-md-12">
                                <input type="text" class="form-control" placeholder="Enter Email" name="email"
                                       aria-label="Email" required>
                            </div>
                            <div class="col col-md-12">
                                <input type="text" class="form-control" placeholder="Enter Password" name="password"
                                       aria-label="Password" required>
                            </div>
                            <div class=" col-md-12 ">
                                <button class="btn btn-primary col-md-12 " type="submit">validate</button>
                                <div class="text-center mt-2">
                                    <p>Don't have account <a href=" <%=request.getContextPath()%>/register">Register
                                        now</a></p>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
