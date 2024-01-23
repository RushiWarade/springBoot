<%@ page import="com.rushiwarade.registrationfile_uploadspringboot.model.Register" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Register data = (Register) session.getAttribute("userData");
    Register profile = (Register) request.getAttribute("profile");
%>

<html>
<head>
    <title>View Profile</title>
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
            <div class="card">
                <div class="card-body ">
                    <a href="/register/logout">Logout</a>
                    <img src="/upload/<%=profile.getFileName()%>" class="mx-auto d-block" alt="Image" width="100px"
                         height="100px" style="border: 1px solid black; border-radius: 50px">
                    <h2>First Name : <%=profile.getFname()%>
                    </h2>
                    <h2>Last Name : <%=profile.getLname()%>
                    </h2>
                    <h2>Email : <%=profile.getEmail()%>
                    </h2>
                    <h2>Mobile Number : <%=profile.getMobile()%>
                    </h2>
                    <h2>Gender : <%=profile.getGender()%>
                    </h2>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
