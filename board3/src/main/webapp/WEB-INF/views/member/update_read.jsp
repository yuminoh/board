<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="memberno" value="${memberVO.memberno} "/>
<c:set var="id" value="${memberVO.id} "/>
<c:set var="mname" value="${memberVO.mname} "/>
<c:set var="pw" value="${memberVO.pw} "/>

<html>
<head>
<jsp:include page="../header.jsp" flush='false'/>
</head>
<body>

<div class="container">
<div class="col-md-7 col-lg-8">
        <h4 class="mb-3">회원 정보</h4>
        
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="mname" class="form-label">Name</label>
              <input type="text" class="form-control" id="mname" name="mname" value="${mname}" disabled>
              <div class="invalid-feedback">
                필수 입력
              </div>
            
            <div class="col-12">
              <label for="id" class="form-label">ID</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="id" name="id" placeholder="아이디" value="${id}" disabled>
            	<div class="invalid-feedback">
                필수 입력
              </div>
            </div>
			</div>
            <div class="col-12">
              <label for="pw" class="form-label">PassWord</label>
              <input type="pw" class="form-control" id="pw" name="pw" placeholder="비밀번호" value="${pw}" disabled>
              <div class="invalid-feedback">
                필수 입력
              </div>
            </div>

          </div>


          <hr class="my-4">
			
          <button class="w-100 btn btn-primary btn-lg" type="submit" ><a href="./update.do?memberno=${memberno }" class='nav-link link-dark px-2'>update</a></button>
        </form>
      </div>
    </div>
<jsp:include page="../footer.jsp" flush='false'/>
</body>
</html>