<%--
  User: 普世豪
  Date: 2022/2/15
  Time: 19:16
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>test</title>
</head>
<body>

<%
    List<String> names = new ArrayList<>();
    names.add("pillage");
    names.add("daisy");
    names.add("tom");
    names.add("jerry");
    names.add("jack");
    names.add("pushihao");
    request.setAttribute("names", names);
%>

<c:forEach items="${names}" var="name" begin="2" end="4" step="1" varStatus="status">
    ${name} <br>
    status:${status.count} <br>
</c:forEach>
==============================
<c:choose>
    <c:when test="${names.contains('jack')}">
        <br>success
    </c:when>
    <c:otherwise>
        <br>filed
    </c:otherwise>
</c:choose>

<br><br><br>
<%
    pageContext.setAttribute("pageNum", 3);
%>
<input type="button" id="btn02" value="按钮">
<script>
    let btn02 = document.querySelector("#btn02")
    btn02.onclick = function () {
        ${pageNum = pageNum + 1}
        document.querySelector("#test02").innerHTML = ${pageNum}
    }
</script>
<h2 id="test02"></h2>
</body>
</html>
