<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28.05.2014
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phone</title>
</head>
<body>
  asdasfgasdgasdgasg
  ${phones}
  <c:forEach items="${phones}" var="phone">
  <br/>
      <c:out value="${phone.name}"/>
      <br/>
      <c:out value="${phone.phone}"/>
  </c:forEach>
  <%--${phone.name}
  <br>
  ${phone.phone}--%>

</body>
</html>
