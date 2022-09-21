写学生管理系统时遇到的一些问题：

### 1. 用 PreparedStatement 书写 SQL 的 模糊查询

问题：

因为直接在控制台书写sql的like子句的格式为
```sql
select xxx from xxx where xxx like '%xxx%'
```

于是我这样写：
```java
String sql = "SELECT * FROM sms_teacher WHERE name LIKE '%?%'";
Object[] parameter = new Object[]{vagueName};
```

结果程序报错：
java.sql.SQLException: Parameter index out of range (1 > number of parameters, which is 0).

原因：

这样的写法让 ？ 被包裹在了单引号中，此时 PreparedStatement 不会认为 ？ 是一个占位符，也就不会给他传递参数。导致出现：Parameter index out of range（参数溢出）

解决：

让 Like 子句的内容整体作为一个参数，用 ？ 占位符代替，然后在参数列表中封装 %

```java
String sql = "SELECT * FROM sms_teacher WHERE name LIKE ?";
Object[] parameter = new Object[]{'%' + vagueName + '%'};
```


### 2. Servlet 无法使用 sendRedirect 进行页面跳转

问题：

我在进行用户注册时，在 Servlet 中判断用户提交的信息时用到：

```java
//过滤掉不合法信息
if (isEmpty(_name) || isEmpty(_age) || isEmpty(_sex) || isEmpty(_class) || isEmpty(_email) || isEmpty(_password)){
    req.getSession().setAttribute("errorMassage","以上内容均为必填项，请认真填写");
    resp.sendRedirect("./../into/regist.jsp");
}
```

结果客户端报错：

java.lang.IllegalStateException: 提交响应后无法调用sendRedirect（）。

原因：

response是服务端对客户端请求的一个响应，其中封装了响应头、状态码、内容等，服务端在把response提交到客户端之前，会向缓冲区内写入响应头和状态码，然后
将所有内容flush。这就标志着该次响应已经committed(提交)。对于当前页面中已经committed(提交)的response，就不能再使用这个response向缓冲区写任何东西

注：
- 同一个页面中的response.XXX()是同一个response的不同方法，只要其中一个已经导致了committed，那么其它类似方式的调用都会导致 IllegalStateException异常
- 能够导致响应已经committed的操作包括：forward（转发）, redirect（重定向）, flushBuffer（刷新缓冲区）。
- 可以用response.isCommitted()来判断response是否已经commit

解决：

在使用了response的commit语句后加入return语句
```java
//过滤掉不合法信息
if (isEmpty(_name) || isEmpty(_age) || isEmpty(_sex) || isEmpty(_class) || isEmpty(_email) || isEmpty(_password)) {
    req.getSession().setAttribute("errorMassage", "以上内容均为必填项，请认真填写");
    resp.sendRedirect("./../into/regist.jsp");
    return;
}
```

