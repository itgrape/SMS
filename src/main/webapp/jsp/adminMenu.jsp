<%--
  User: 普世豪
  Date: 2022/2/15
  Time: 17:46
--%>
<%@ page import="com.pushihao.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SMS</title>
    <link rel="stylesheet" href="../static/css/adminMenu.css">
    <link rel="stylesheet" href="../static/css/addPerson.css">
</head>
<body>

<div class="welcome">
    欢迎您：<%="系统管理员"%>
</div>
<div class="exitLogin">
    <form>
        <button type="submit" name="exitLogin" value="exit" formaction="./../servlet/exit-login-servlet">退出登录</button>
    </form>
</div>

<div class="menu">
    <form action="./../servlet/system-manager-show-servlet">
        <label for="name">姓名：<input id="name" type="text" name="name"></label>
        <label for="class">班级：<input id="class" type="text" name="class"></label>
        <input id="search-input" type="submit" value="搜索">
    </form>
</div>

<div class="show">
    <table>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>班级</th>
            <th>邮箱</th>
            <th>密码</th>
        </tr>
        <c:if test="${teachers != null and startIndex != null and endIndex != null}">
            <c:forEach items="${teachers}" var="teacher" begin="${startIndex}" end="${endIndex}" step="1"
                       varStatus="status">
                <c:choose>
                    <c:when test="${(status.index + 1) % 2 == 0}">
                        <tr class="deep-color">
                    </c:when>
                    <c:otherwise>
                        <tr class="normal-color">
                    </c:otherwise>
                </c:choose>
                            <td>${teacher._name}</td>
                            <td>${teacher._age}</td>
                            <c:choose>
                                <c:when test="${teacher._sex == 'man'}">
                                    <td><img class="sex-img" src="./../img/people/e8.png" alt="${teacher._sex}"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><img class="sex-img" src="./../img/people/e10.png" alt="${teacher._sex}"></td>
                                </c:otherwise>
                            </c:choose>
                            <td>${teacher._class}</td>
                            <td>${teacher._email}</td>
                            <td>${teacher._password}</td>

                            <%--删改操作--%>
                            <td>
                                <form>
                                    <input type="hidden" name="teacherId" value="${teacher._id}">
                                    <button formaction="./../servlet/delete-teacher-servlet">删除</button>
                                    <button formaction="./../servlet/find-teacher-servlet">修改</button>
                                </form>
                            </td>
                        </tr>
            </c:forEach>
        </c:if>

    </table>
</div>


<div class="add-person">
    <form action="./../servlet/add-teacher-servlet">
        <table>
            <tr>
                <td>姓名</td>
                <td>年龄</td>
                <td>性别</td>
                <td>班级</td>
                <td>邮箱</td>
                <td>密码</td>
            </tr>
            <tr>
                <td><label><input id="addName" name="addName" type="text"></label></td>
                <td><label><input id="addAge" name="addAge" type="text"></label></td>
                <td>
                    <label>男<input class="addSex" name="addSex" value="man" type="radio"></label>
                    <label>女<input class="addSex" name="addSex" value="woman" type="radio"></label>
                </td>
                <td><label><input id="addClass" name="addClass" type="text"></label></td>
                <td><label><input id="addEmail" name="addEmail" type="text"></label></td>
                <td><label><input id="addPassword" name="addPassword" type="text"></label></td>
                <td><input type="submit" value="添加老师"></td>
            </tr>
        </table>
    </form>
</div>

<div class="select">
    <div class="total-pages">第${CURRENT_PAGE}页/共${pageSupport.getTotalPageNum()}页</div>
    <div class="turn-page">
        <form action="./../servlet/turn-page-servlet">
            <input type="hidden" name="do" value="up">
            <button id="turnUp">上一页</button>
        </form>
        <form action="./../servlet/turn-page-servlet">
            <input type="hidden" name="do" value="down">
            <button id="turnDown">下一页</button>
        </form>
    </div>

    <div class="search-page">
        <form action="./../servlet/turn-page-servlet">
            <input type="hidden" name="do" value="jump">
            <label for="pageNum"><input type="text" id="pageNum" name="pageNum"></label>
            <button>跳转</button>
        </form>
    </div>
</div>
</body>
</html>
