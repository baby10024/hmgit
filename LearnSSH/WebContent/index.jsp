<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <%@ include file="/public/head.jspf" %>  
  </head>  
    
  <body>  
  	<a href="send_main_aindex.action">测试到后台</a><br/>
    <a href="${pageContext.request.contextPath }/user_update.action?user.id=2&user.realname=gga">访问update</a>  
    <a href="user_save.action?id=1&type=haha&hot=true">测试ModelDriven</a>  
    <a href="user_query.action">查询所有类别</a><br/>  
    <c:forEach items="${requestScope.userList }" var="user">  
        ${user.id } | ${user.type } | ${user.hot } <br/>  
    </c:forEach>  
      
    <c:forEach items="${sessionScope.userList }" var="user">  
        ${user.id } | ${user.type } | ${user.hot } <br/>  
    </c:forEach>  
      
    <c:forEach items="${applicationScope.userList }" var="user">  
        ${user.id } | ${user.type } | ${user.hot } <br/>  
    </c:forEach>  
  </body>  
</html> 