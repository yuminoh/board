<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
	<title>게시판</title>
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	
	
	<nav class="py-2 bg-light border-bottom">
    <div class="container d-flex flex-wrap">
      <ul class="nav me-auto">
        <!-- <li class="nav-item"><a href="${pageContext.request.contextPath}" class="nav-link link-dark px-2 active" aria-current="page">Home</a></li> -->
        <li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link link-dark px-2">Board</a></li>
        
      </ul>
      <ul class="nav">
      
      <c:choose>
        <c:when test="${id != null}">
           <li class='nav_item' ><a href='${pageContext.request.contextPath}/member/update_read.do?memberno=${memberno}' class='nav-link link-dark px-2'>${id } <a/></li>
           <li class='nav_item'> <A href='${pageContext.request.contextPath}/member/logout.do' class='nav-link link-dark px-2'>Logout</A></li>
        </c:when>
        <c:otherwise>
          <li class='nav-item'><a href='${pageContext.request.contextPath}/member/login.do' class='nav-link link-dark px-2'>Login</a></li>
          <li class="nav-item"><a href="${pageContext.request.contextPath}/member/add.do" class="nav-link link-dark px-2">Sign up</a></li>
        </c:otherwise>
      </c:choose>
        
      </ul>
    </div>
  </nav>
  <header class="py-3 mb-4 border-bottom">
    <div class="container d-flex flex-wrap justify-content-center">
     
        <span class="fs-4"><strong>Board</strong></span>
      </a>
    </div>
  </header>
</head>

</html>