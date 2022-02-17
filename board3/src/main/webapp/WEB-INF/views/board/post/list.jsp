<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<jsp:include page="../header.jsp" flush='false'/>
</head>
<body>
<div class="container">
<nav class="navbar navbar-light bg-light">
<button type="button" class="btn btn-outline-secondary" ><a href="../board/post/add.do" class='nav-link link-dark px-2'>add</a></button>
 

    <form class="d-flex" name='frm' action='/board/'>
      <input class="form-control me-2" type="text" placeholder="Search" name="word" id="word" style="width:300px;height:50px;" value="${word}">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
 </nav>
<table class="table">
  <thead>
    <tr>
      <th scope="col">postno</th>
      <th scope="col">title</th>
      <th scope="col">writer</th>
      <th scope="col">rdate</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="postVO" items="${list}">
  		<c:set var="postno" value="${postVO.postno}"/>
  		<tr>
  			<td scope="row">${postVO.postno} </td>
  			<td scope="row"><a href="../board/post/read.do?postno=${postVO.postno}">${postVO.title}</a> </td>
  			<td scope="row">${postVO.writer} </td>
  			<td scope="row">${postVO.rdate} </td>
  		</tr>
  	</c:forEach>
  </tbody>
</table>
<div class="btn-group me-2" role="group" aria-label="Second group">
	<c:if test="${pageb.prev }">
		<button type="button" class="btn btn-secondary"><a href='<c:url value="./?page=${pageb.start-1 }&word=${param.word}"/>' class='nav-link link-dark px-2'></a></button>
    </c:if>
    <c:forEach begin="${pageb.start }" end="${pageb.end }" var="pageNum">
    
        <button type="button" class="btn btn-secondary"><a href='<c:url value="./?page=${pageNum }&word=${param.word}"/>' class='nav-link link-dark px-2'>${pageNum }</a></button>
    
    </c:forEach>
    <c:if test="${pageb.next && pageb.end >0 }">
   
        <button type="button" class="btn btn-secondary"><a href='<c:url value="./?page=${pageb.end+1 }&word=${param.word}"/>' class='nav-link link-dark px-2'></a></button>
   
    </c:if>
  </div>
  
  
<jsp:include page="../footer.jsp" flush='false'/>
</div>
</body>
</html>