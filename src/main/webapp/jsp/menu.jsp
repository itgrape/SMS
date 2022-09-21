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
    <link rel="stylesheet" href="../static/css/addPerson.css">
    <link rel="stylesheet" href="../static/css/menu.css">
</head>
<body>

<div class="welcome">
    欢迎您：${USER.get_name()}
</div>
<div class="exitLogin">
    <form>
        <button type="submit" name="exitLogin" value="exit" formaction="./../servlet/exit-login-servlet">退出登录</button>
    </form>
</div>

<div class="menu">
    <form action="./../servlet/teacher-show-student-servlet">
        <label for="name">姓名：<input id="name" type="text" name="name"></label>
        <select class="select-option" name="sex">
            <option value="all">=请选择=</option>
            <option value="boy">男同学</option>
            <option value="girl">女同学</option>
        </select>
        <select class="select-option" name="score">
            <option value="all">=请选择=</option>
            <option value="passed">及格</option>
            <option value="failed">不及格</option>
        </select>
        <input id="search-input" type="submit" value="搜索">
    </form>
</div>

<%--<%--%>
<%--    Student student = new Student();--%>
<%--    student.set_id(1);--%>
<%--    student.set_name("pillage");--%>
<%--    student.set_age(19);--%>
<%--    student.set_sex("boy");--%>
<%--    student.set_score(99);--%>
<%--    student.set_class(1);--%>
<%--    student.set_role(2);--%>
<%--    student.set_phoneNumber("18336597584");--%>

<%--    Student student1 = new Student();--%>
<%--    student1.set_id(1);--%>
<%--    student1.set_name("pillage");--%>
<%--    student1.set_age(19);--%>
<%--    student1.set_sex("boy");--%>
<%--    student1.set_score(99);--%>
<%--    student1.set_class(1);--%>
<%--    student1.set_role(2);--%>
<%--    student1.set_phoneNumber("110");--%>

<%--    List<Student> list = new ArrayList<>();--%>
<%--    list.add(student);--%>
<%--    list.add(student1);--%>

<%--    request.setAttribute("students", list);--%>
<%--    request.setAttribute("startIndex", 0);--%>
<%--    request.setAttribute("endIndex", 1);--%>
<%--%>--%>

<div class="show">
    <table>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>分数</th>
            <th>班级</th>
            <th>手机号码</th>
        </tr>
        <c:if test="${students != null and startIndex != null and endIndex != null}">
            <c:forEach items="${students}" var="student" begin="${startIndex}" end="${endIndex}" step="1"
                       varStatus="status">
                <c:choose>
                    <c:when test="${(status.index + 1) % 2 == 0}">
                        <tr class="deep-color">
                    </c:when>
                    <c:otherwise>
                        <tr class="normal-color">
                    </c:otherwise>
                </c:choose>
                            <td>${student._name}</td>
                            <td>${student._age}</td>
                            <c:choose>
                                <c:when test="${student._sex == 'boy'}">
                                    <td><img class="sex-img" src="./../img/people/e7.png" alt="${teacher._sex}"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><img class="sex-img" src="./../img/people/e5.png" alt="${teacher._sex}"></td>
                                </c:otherwise>
                            </c:choose>
                            <td>${student._score}</td>
                            <td>${student._class}</td>
                            <td>${student._phoneNumber}</td>

                            <%--删改操作--%>
                            <td>
                                <form>
                                    <input type="hidden" name="studentId" value="${student._id}">
                                    <button formaction="./../servlet/delete-student-servlet">删除</button>
                                    <button formaction="./../servlet/find-student-servlet">修改</button>
                                </form>
                            </td>
                        </tr>

            </c:forEach>
        </c:if>

    </table>
</div>


<div class="add-person">
    <form action="./../servlet/add-student-servlet">
        <table>
            <tr>
                <td>姓名</td>
                <td>年龄</td>
                <td>性别</td>
                <td>分数</td>
                <td>手机号码</td>
            </tr>
            <tr>
                <td><label><input id="addName" name="addName" type="text"></label></td>
                <td><label><input id="addAge" name="addAge" type="text"></label></td>
                <td>
                    <label>男<input class="addSex" name="addSex" value="boy" type="radio"></label>
                    <label>女<input class="addSex" name="addSex" value="girl" type="radio"></label>
                </td>
                <td><label><input id="addScore" name="addScore" type="text"></label></td>
                <td><label><input id="addPhoneNumber" name="addPhoneNumber" type="text"></label></td>
                <td><input type="submit" value="添加同学"></td>
            </tr>
        </table>
    </form>
</div>



<div class="select">
    <div class="total-pages">第${CURRENT_PAGE}页/共${pageSupport.getTotalPageNum()}页</div>
    <div class="turn-page">
        <form action="./../servlet/turn-page-servlet" method="post">
            <input type="hidden" name="do" value="up">
            <button id="turnUp">上一页</button>
        </form>
        <form action="./../servlet/turn-page-servlet" method="post">
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
