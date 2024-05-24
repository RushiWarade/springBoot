<%@ page import="com.rushiwarade.attedancetrackerspringboot.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <title>Home page</title>
</head>
<body>





<h2>File Upload Form</h2>
<form action="upload" method="post" enctype="multipart/form-data">
    <%
        String msg = (String) session.getAttribute("msg");
        if (msg != null) {
    %>
    <p style="color: darkred"><%=msg%>
    </p>

    <%
            session.removeAttribute("msg");
        }
    %>
    <input type="file" name="file">
    <br>
    <input type="submit" value="Upload">
</form>


<%
    List<Student> students = (List<Student>) request.getAttribute("files");

    for (Student student : students) {
%>
<a href="delete/<%=student.getId()%>">
    <img src="/upload/<%=student.getFile()%>" alt="uploads Images" height="100px" width="100px">
</a>
<%
    }
%>

</body>
</html>
