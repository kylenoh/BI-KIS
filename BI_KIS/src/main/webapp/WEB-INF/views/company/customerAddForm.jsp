<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../style.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<%@ include file="../emp-interface.jsp" %>
	</div>
	<div class="main">
		<div class="container">
	    <form method="post" action="addCustomer" id="CustomerForm">
                <div id="addForm">
	                <div>
	                    <label for="name">담당자 명</label><input type="text" id="name" name="name" class="inputTitle">
	                </div>
	                <div>
	                    <label for="rank">직급</label><input type="text" id="rank" name="rank" class="inputTitle">
	                </div>
	                <div>
	                    <label for="dept">부서명</label><input type="text" id="dept" name="dept" class="inputTitle">
	                </div>
	                <div>
	                    <label for="tel1">연락처1</label><input type="text" id="tel1" name="tel1" class="inputTitle">
	                    <label for="tel2">연락처2</label><input type="text" id="tel2" name="tel2" class="inputTitle">
	                </div>
	                <div>
	                    <label for="email">이메일</label><input type="text" id="email" name="email" class="inputTitle">
	                </div>
	                <div>
	                    <label for="company">고객사 명</label>
	                    <select id="company" name="companyNo" class="inputTitle">
	                        <option value="all"></option>
	                        <c:forEach var="comList" items="${companyList }">
	                        	<option value="${comList.no }">${comList.name }</option>
	                        </c:forEach>
                    	</select>    
	                </div>
	                <div>
	                	<label for="remark">비고</label>
	                	<textarea id="remark" name="remark" class="summernote"></textarea>
	                </div>
	                <button class="btn success" type="submit">등록</button>
                </div>
		</form>
		</div>
	</div>
</div>
	
</body>
</html>