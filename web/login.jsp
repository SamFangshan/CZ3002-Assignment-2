<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>

<h1 align="center">Please Login</h1>

<s:form action="loginProcess" align="center">
  <s:textfield label="Username" key="username" align="center"/>
  <s:password label="Password" key="password" align="center"/>
  <s:submit align="center"/>
</s:form>

<%--Error handling for wrong credentials--%>
<s:actionerror style="color: red"/>

</body>
</html>
