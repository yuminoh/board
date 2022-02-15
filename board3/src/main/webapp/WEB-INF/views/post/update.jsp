<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="postno" value="${postVO.postno} "/>
<c:set var="writer" value="${postVO.writer} "/>
<c:set var="title" value="${postVO.title} "/>
<c:set var="content" value="${postVO.content} "/>
<c:set var="rdate" value="${postVO.rdate} "/>


<html>
<head>
<jsp:include page="../header.jsp" flush='false'/>
</head>
<body>
 <form name="frm" method="post" action='/board/post/update.do?postno=${postno}' novalidate>
    <div class="container">
        <div class="container">
    <div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">작성자: ${writer} </span>
	</div>

<label for="basic-url" class="form-label">제목</label>
<div class="input-group mb-3">
  <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" name="title" value="${title}" />
</div>

<label for="basic-url" class="form-label">내용</label>
<div class="input-group">
  <textarea class="form-control" aria-label="With textarea" name="content">${content} </textarea>
  
</div>
<button type="submit" class="btn btn-outline-secondary">update</button>
     </div>
     </div>
</form>
<jsp:include page="../footer.jsp" flush='false'/>
</body>
</html>