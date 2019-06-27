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
		    <form method="post" action="empModify" id="searchForm">
	                <div>
	                    <label for="empId">아이디</label><input type="text" id="empId" name="empId" readonly="readonly" value="${emp.id }" class="inputTitle">
	                </div>
	                <div>
	                	<label for="name">이름</label><input type="text" id="name" name="name" value="${emp.name }" class="inputTitle">
	                </div>
	                <div>
	                	<label for="rank">직책</label><input type="text" id="rank" name="rank" value="${emp.rank }" class="inputTitle">
	                </div>
	                <div>
	                	<label for="tel">연락처</label><input type="text" id="tel" name="tel" value="${emp.tel }" class="inputTitle">
	                </div>
	                <div>
	                	<label for="addr">주소</label><input type="text" id="addr" name="addr" value="${emp.addr }" class="inputTitle">
	                </div>
	                <div>
	                	<label for="email">이메일</label><input type="text" id="email" name="email" value="${emp.email }" class="inputTitle">
	                </div>
	                <div>
	                    <button type="submit" class="btn success">수정</button>
	                    <button type="button" class="btn warning" onclick="location.href='${HEADER_VALUE.CATE_VALUE}'">취소</button>
	                </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>