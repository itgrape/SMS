<%--
  User: 普世豪
  Date: 2022/2/20
  Time: 18:08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SMS</title>
    <link rel="stylesheet" href="../static/css/modify.css">
</head>
<body>
<h1 class="title">欢迎来到修改信息页面</h1>

<div class="show">
    <form action="./../servlet/update-teacher-servlet">
        <table>
            <tr>
                <td>姓名：</td>
                <td><label><input type="text" name="name" value="${teacher._name}"></label></td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><label><input type="text" name="age" value="${teacher._age}"></label></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td class="sex">
                    <c:choose>
                        <c:when test="${teacher._sex == 'man'}">
                            男<label><input checked name="sex" type="radio" value="man"></label>
                            女<label><input name="sex" type="radio" value="woman"></label>
                        </c:when>
                        <c:otherwise>
                            男<label><input name="sex" type="radio" value="man"></label>
                            女<label><input checked name="sex" type="radio" value="woman"></label>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td>班级：</td>
                <td><label><input type="text" name="class" value="${teacher._class}"></label></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><label><input type="text" name="email" value="${teacher._email}"></label></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><label><input type="text" name="password" value="${teacher._password}"></label></td>
            </tr>
        </table>


        <input class="submit" type="submit" value="确认修改">
    </form>
</div>
</body>
</html>

