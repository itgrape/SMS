<%--
  User: 普世豪
  Date: 2022/2/15
  Time: 14:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SMS</title>
    <style>
        body{
            margin: 0;
            padding: 0;
            background-color: rgba(81, 133, 85, 0.34);
        }
        h1{
            padding-top: 60px;
            text-align: center;
            font-family: "黑体", serif;
        }
        .choice{
            position: relative;
            width: 399px;
            height: 60px;
            background-color: rgba(81, 133, 85, 0);
            margin: 0 auto;
            top: 80px;
            border-radius: 10px;
            text-align: center;
            font-size: 20px;
            font-family: "黑体", serif;
        }
        .choice div{
            padding-top: 25px;
            border-radius: 20px;
            float: left;
            width: 133px;
            height: 60px;
            background-color: pink;
        }
        .choice .teacher-regist{
            background-color: #cccccc;
        }
        .form {
            position: relative;
            background-color: #7199fc;
            width: 600px;
            height: 400px;
            top: 90px;
            left: 50%;
            transform: translate(-50%);
            box-shadow: 5px 5px 10px gray;
            border-radius: 10px;
        }
        table{
            position: absolute;
            top: 15%;
            left: 50%;
            transform: translate(-50%);
        }
        tr{
            height: 30px;
            font-size: 20px;
        }
        #submit{
            position: absolute;
            top: 220px;
            left: 50%;
            transform: translate(-50%);
            width: 70px;
            height: 40px;
            font-family: "黑体";
            font-size: 25px;
            color:rgb(2, 2, 2);
            border-radius: 5px;
            background-color: rgb(110, 100, 240);
            border: 0;
            transition: all .3s ease-in;
            -webkit-transition: all .3s ease-in;
        }
        #submit:hover{
            position: absolute;
            top: 210px;
            left: 50%;
            transform: translate(-50%);
            width: 90px;
            height: 60px;
            font-family: "黑体";
            font-size: 25px;
            color:rgb(2, 2, 2);
            border-radius: 5px;
            background-color: rgb(161, 122, 250);
            border: 0;
        }
        .input{
            width: 200px;
            border-bottom: 1px solid #ccc;
            margin: 0 auto;
            height: 20px;
        }
        .input input{
            width: 170px;
            height: 20px;
            border: 0;
            background-color: #7199fc;
            outline: none;
            font-size: 20px;
        }
        .error-massage{
            float: top;
            font-size: 30px;
            color: red;
        }
    </style>
</head>
<body>
<h1>欢迎使用SMS学生管理系统</h1>

<div class="choice">
    <div class="root-login">管理员登录</div>
    <div class="teacher-login">教师登录</div>
    <div class="teacher-regist">教师注册</div>
</div>

<script>
    let rootLogin = document.querySelector(".root-login")
    let teacherLogin = document.querySelector(".teacher-login")
    let teacherRegist = document.querySelector(".teacher-regist")
    rootLogin.onclick = function () {
        location.href = "../index.jsp"
    }
    teacherLogin.onclick = function () {
        location.href = "login.jsp"
    }
</script>


<div class="form">
    <form action="./../servlet/regist-servlet" method="post">
        <table>
            <tr>
                <td>姓名</td>
                <td class="input"><label><input name="name" type="text"></label></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td class="input"><label><input name="age" type="text"></label></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    男：<label for="man"><input name="sex" id="man" type="radio" value="man"></label>
                    女：<label for="woman"><input name="sex" id="woman" type="radio" value="woman"></label>
                </td>
            </tr>
            <tr>
                <td>班级</td>
                <td class="input"><label><input name="class" type="text"></label></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td class="input"><label><input type="email" name="email"></label></td>
            </tr>
            <tr>
                <td>密码</td>
                <td class="input"><label><input type="password" name="password"></label></td>
                <div class="error-massage">
                    <c:out value="${errorMassage}" />
                </div>
            </tr>
            <%
                request.setAttribute("role", 1);
            %>
            <tr>
                <td><label><input id="submit" type="submit" value="注册"></label></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
