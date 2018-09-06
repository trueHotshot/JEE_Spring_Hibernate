<%--
  Created by IntelliJ IDEA.
  User: hotshot
  Date: 04.09.18
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person form</title>
</head>
<body>

    <form:form modelAttribute="person" method="post">
        <label>Login: <form:input path="login" /></label><br>
        <label>Password: <form:input path="password" /></label><br>
        <label>E-mail: <form:input path="email" /></label><br>
        <input type="submit" value="Submit" />
    </form:form>

</body>
</html>
