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
            <div id="requestDetail">
	            <div>
	                <label for="category">분류 명</label>
	                <input type="text" id="categoryName" class="inputTitle" name="categoryName" value="${request.categoryName }" disabled="disabled">  
	            </div>
	            <div>
	        	    <label for="pjtName">프로젝트 명</label><input type="text" class="inputTitle" id="pjtName" name="pjtName" value="${request.project.title }" disabled="disabled">
	            </div>
	            <div>
	                <label for="companyName">고객사 명</label><input type="text" class="inputTitle" id="companyName" name="companyName" value="${request.project.company.name }" disabled="disabled">
	            </div>
	            <div>
	                <label for="customerName">담당자 명</label>
					<input type="text" id="customerName" name="customerName" value="${request.customer.name }" disabled="disabled" class="inputTitle">
	            </div>
	            <div class="form-inline">
	                <label for="receiveDate">접수일</label><input type="date" id="receiveDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.receiveDate }"/>" disabled="disabled">    
	                <label for="startDate">시작일</label><input type="date" id="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.startDate }"/>" disabled="disabled">    
	                <label for="endDate">종료일</label><input type="date" id="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.endDate }"/>" disabled="disabled">
	                <label for="closeDate">마감일</label><input type="date" id="closeDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.closeDate }"/>" disabled="disabled">
	            </div>
	            <div>
	              	<label for="flag">진행상황</label>
		          	<input type="text" id="flag" name="flag" value="${request.msg }" disabled="disabled" class="inputTitle">
	            </div>
	            <div>
	             	<label for="suggest">요청 내용</label>
	              	<div id="suggest">${request.suggest }</div>
	            </div>
	            <div>
	             	<label for="handle">처리 내용</label>
	              	<div id="handle">${request.handle }</div>
	            </div>
	            <div style="float:right;">
	            	<c:if test="${LOGIN_EMP.auth.no eq 1 || LOGIN_EMP.id eq pjt.registrant}">
		            	<button type="button" class="btn success"id="btn-modify-request" value="${request.no }">수정</button>
		            	<button type="button" class="btn danger" id="btn-del-request" value="${request.no }">삭제</button>
		            </c:if>
	            	<button class="btn warning" type="button" onclick="location.href='request'">목록</button>
	            </div>
            </div>
		</div>
	</div>
</div>
	
</body>
<script type="text/javascript">
	$(function(){
		$('#btn-del-request').click(function(){
			var requestNo = $(this).val();
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href="requestDelete?requestNo=" + requestNo;
			}
		});
		$('#btn-modify-request').click(function(){
			var requestNo = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="requestModify?requestNo=" + requestNo;
			}
		});
	});
</script>
</html>