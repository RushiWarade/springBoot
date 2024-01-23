<%--
  Created by IntelliJ IDEA.
  User: rushi
  Date: 23-01-2024
  Time: 10:14 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body>


<div class="container p-5">
    <div class="row">
        <div class="col-md-10 offset-md-1">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3 font-monospace">File upload example</p>

                    <a href="register/profile">View Profile</a>

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
                    <form action="register" method="post" enctype="multipart/form-data">

                        <div class="row g-3">
                            <div class="col">
                                <input type="text" class="form-control" placeholder="First name" name="fname"
                                       aria-label="First name" required>
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" placeholder="Last name" name="lname"
                                       aria-label="Last name" required>
                            </div>

                            <div class="col">
                                <input type="email" class="form-control" placeholder="Your Email" name="email"
                                       aria-label="Email" required>
                            </div>

                            <fieldset class="row mb-4 d-flex">
                                <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                                <div class="col-sm-10 d-flex  ">
                                    <div class="form-check  ">
                                        <input class="form-check-input" type="radio" name="gender" id="gridRadios1"
                                               value="male" checked>
                                        <label class="form-check-label" for="gridRadios1">
                                            Male
                                        </label>
                                    </div>
                                    <div class="form-check ">
                                        <input class="form-check-input" type="radio" name="gender" id="gridRadios2"
                                               value="female">
                                        <label class="form-check-label" for="gridRadios2">
                                            Female
                                        </label>
                                    </div>

                                </div>
                            </fieldset>

                            <div class="col">
                                <input type="tel" class="form-control" placeholder="Mobile Number" name="mobile"
                                       aria-label="Mobile number" required>
                            </div>

                            <div class="col">
                                <input type="file" class="form-control" name="file" aria-label="file example" required>
                            </div>
                            <div class="col">
                                <input type="password" class="form-control" placeholder="Password" name="password"
                                       aria-label="Password" required>
                            </div>

                            <div class="col-12">
                                <button class="btn btn-primary" type="submit">Submit form</button>
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
