<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="./header.jsp" flush='false'/>
</head>
<body>
 
    <div class="container">

      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
           <!--  <img alt="" src=""> -->

            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                </div>
              </div>
            </div>
          </div>
        </div>
     
     <div class="col">
          <div class="card shadow-sm">
            <!-- <img alt="" src=""> -->

            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                </div>
              </div>
            </div>
          </div>
        </div>
     </div>
<P>  The time on the server is ${serverTime}. </P>
 </div>
<jsp:include page="./footer.jsp" flush='false'/>
</body>
</html>
