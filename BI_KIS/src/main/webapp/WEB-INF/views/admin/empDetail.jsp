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
	        <div>
	            <label for="empId">아이디</label><input type="text" id="empId" name="empId" disabled="disabled" value="${emp.id }" class="inputTitle">
	        </div>
	        <div>
	          	<label for="name">이름</label><input type="text" id="name" name="name" disabled="disabled" value="${emp.name }" class="inputTitle">
	        </div>
	        <div>
	        	<label for="rank">직책</label><input type="text" id="rank" name="rank" disabled="disabled" value="${emp.rank }" class="inputTitle">
	        </div>
	        <div>
	           	<label for="tel">연락처</label><input type="text" id="tel" name="tel" disabled="disabled" value="${emp.tel }" class="inputTitle">
	        </div>
	        <div>
	          	<label for="addr">주소</label><input type="text" id="addr" disabled="disabled" name="addr" value="${emp.addr }" class="inputTitle">
	        </div>
	        <div>
	          	<label for="email">이메일</label><input type="text" id="email" disabled="disabled" name="email" value="${emp.email }" class="inputTitle">
	        </div>
	        <div style="float:right;">
		       	<c:if test="${LOGIN_EMP.auth.no eq 1 || LOGIN_EMP.auth.no eq 2 || LOGIN_EMP.id eq emp.id}">
			      	<button type="button" class="btn-modify-emp btn success" value="${emp.id }">수정</button>
			       	<button type="button" class="btn-del-emp btn danger" value="${emp.id }">삭제</button>
		       	</c:if>
		       	<button class="btn warning" type="button" onclick="location.href='${HEADER_VALUE.CATE_VALUE}'">목록</button>
		    </div>
	    </div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('.btn-del-emp').click(function(){
			var empId = $(this).val();
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href="empDelete?empId=" + empId;
			}
		});
		$('.btn-modify-emp').click(function(){
			var empId = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="empModify?empId=" + empId;
			}
		});
	});
</script>
</html>