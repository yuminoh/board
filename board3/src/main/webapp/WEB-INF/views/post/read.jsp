<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = (String)request.getSession().getAttribute("id");
	String manme = (String)request.getSession().getAttribute("mname");
%>
<c:set var="postno" value="${postVO.postno} "/>
<c:set var="writer" value="${postVO.writer} "/>
<c:set var="title" value="${postVO.title} "/>
<c:set var="content" value="${postVO.content} "/>
<c:set var="rdate" value="${postVO.rdate} "/>

<c:set var="replyno" value="${replyVO.replyno}"/>
<c:set var="postno" value="${replyVO.postno} "/>
<c:set var="rwriter" value="${replyVO.rwriter}"/>
<c:set var="rcontent" value="${replyVO.rcontent}"/>
<c:set var="pdate" value="${replyVO.pdate}"/>

<html>
<head>
<jsp:include page="../header.jsp" flush='false'/>
</head>
<body>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	showReplyList();
	
});

function showReplyList(){
	
	var url = "${pageContext.request.contextPath}/post/replylist.do";
	var id = "${sessionScope.id}";
	
	$.ajax({
        type: 'GET',
        url: url,
        data: {postno : "${postVO.postno}"},
        success: function(replylist) {
           	var htmls = "";
           	
           	console.log(id);
			$(replylist).each(function(){
                htmls += '<div class="media text-muted pt-3" id="replyno' + this.replyno + '">';
                htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
                htmls += '<span class="d-block">';
                htmls += '<strong class="text-gray-dark">' + this.rwriter + '</strong>';
                htmls += '<span style="padding-left: 7px; font-size: 9pt">';
                console.log(this.rwriter);
                if(id == this.rwriter){
                	console.log(this.rwriter);
                htmls += '<a href="javascript:fn_reupdate(' + this.replyno + ', \'' + this.rwriter + '\', \'' + this.rcontent + '\')" style="padding-right:5px">update</a>'; //javascript:void(0)
                htmls += '<a href="javascript:fn_deleteReply(' + this.replyno + ')" >delete</a>'; //
                }
                
                htmls += '</span>'; 
                htmls += '</span>';
                htmls += this.rcontent;
                htmls += '</p>';
                htmls += '</div>';
			});
			$("#replylist").html(htmls);
		}
	});
			
}

$(document).on('click', '#btn_add', function(){
	var rcontent = $('#rcontent').val();
	var paramData = {"postno": '${postVO.postno}'
			,"rcontent": rcontent
	};
	
	console.log(paramData);
	$.ajax({
		url: "${pageContext.request.contextPath}/post/reinsert.do"
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			console.log(result);
			showReplyList();
			$('#rcontent').val('');
		}
	});
});

function fn_reupdate(replyno, rwriter, rcontent){
	var htmls = "";
	
	htmls += '<div class="media text-muted pt-3" id="replyno' + replyno + '">';
	htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
	htmls += '<span class="d-block">';
	htmls += '<strong class="text-gray-dark">' + rwriter + '</strong>';
	htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	htmls += '<a href="javascript:fn_reupdateReply(' + replyno + ', \''+ rcontent + '\')" style="padding-right:5px">저장</a>';
	htmls += '<a href="javascript:showReplyList()">취소<a>';
	htmls += '</span>';
	htmls += '</span>';		
	htmls += '<textarea name="updatecontent" id="updatecontent" class="form-control" rows="3">';
	htmls += rcontent;
	htmls += '</textarea>';
	htmls += '</p>';
	htmls += '</div>';
	$('#replyno' + replyno).replaceWith(htmls);
	$('#replyno' + replyno + ' #rcontent').focus();
}

function fn_reupdateReply(replyno, rcontent){
	var updatecontent = $('#updatecontent').val();
	var paramData = {"rcontent": updatecontent
			, "replyno": replyno
	};
	
	$.ajax({
		url: "${pageContext.request.contextPath}/post/reupdate.do"
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
            console.log(result);
			showReplyList();
		}, error: function(error){
			console.log("에러: " + error);
		}
	});
}

function fn_deleteReply(replyno){
	var paramData = {"replyno": replyno};
	$.ajax({
		url: "${pageContext.request.contextPath}/post/redelete.do"
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
		}
	});
}

</script>

    <div class="container">
    <div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">작성자: ${postVO.writer} </span>
  
</div>

<label for="basic-url" class="form-label">제목: ${title} </label><br>

<label for="basic-url" class="form-label">내용: </label>
<div class="input-group">
  <label for="basic-url" class="form-label"> ${content} </label>
  
</div>
<c:set var="writer" value="${postVO.writer} "/>
<c:set var="id" value="${sessionScope.id} "/>
<c:if test="${id == writer}">
	<button type="button" class="btn btn-outline-secondary"><a href="./update.do?postno=${postVO.postno}" class='nav-link link-dark px-2'>update</a></button>
	<button type="button" class="btn btn-outline-secondary"><a href="./delete.do?postno=${postVO.postno}" class='nav-link link-dark px-2'>delete</a></button>
</c:if>
<hr>  
<div id='reply'>
<form name='frm_reply' id='frm_reply' method='post'></form> 

<div class="mb-3 row">
    <label for="staticEmail" class="col-sm-2 col-form-label">댓글 작성자: ${id} </label>
  </div> 
  <div class="col-12">
     <div class="input-group has-validation">
       <input type="text" class="form-control" id="rcontent" name="rcontent" placeholder="댓글" required="required">
   	<div class="invalid-feedback">
     </div>
   </div>
 </div>
 <button type="button" class="btn btn-outline-secondary" id="btn_add">reply</button>
 <hr>

<div>
 <div id="replylist">
 
 </div>

</div>
 </div>

</div>
<jsp:include page="../footer.jsp" flush='false'/>
</body>
</html>