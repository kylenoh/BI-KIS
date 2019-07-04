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
	            <div id="PjtDetail">
		            <div>
		        	    <label for="title">프로젝트 명</label>
		        	    <input type="text" class="inputTitle" value="${pjt.title }" disabled="disabled">
		            </div>
		            <div>
		                <label for="company">고객사 명</label>
		                <input type="text" class="inputTitle" value="${pjt.company.name }" disabled="disabled">    
		            </div>
		            <div class="form-inline">
		                <label for="startDate">시작일</label><input type="date" id="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${pjt.startDate }"/>" disabled="disabled">    
		                <label for="endDate">종료일</label><input type="date" id="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${pjt.endDate }"/>" disabled="disabled">
		            	<label for="flag">진행상태</label>
		            	<c:if test="${pjt.flag eq 'Y' }">
		            		<input type="text" id="flag" value="진행예정" disabled="disabled">
		            	</c:if>
		            	<c:if test="${pjt.flag eq 'P' }">
		            		<input type="text" id="flag" value="진행중" disabled="disabled">
		            	</c:if>
		            	<c:if test="${pjt.flag eq 'N' }">
		            		<input type="text" id="flag" value="종료" disabled="disabled">
		            	</c:if>
		            </div>
		            <div>
		            	<label for="customer">담당자</label>
		            	<c:forEach var="emp" items="${pjt.emps }">
		            		<input type="text" value="${emp.name}" disabled="disabled" class="inputTitle">
		            	</c:forEach>
		            </div>
		            <div>
		                <label for="content">내용</label>
		                <div>${pjt.content }</div>
		            </div>
		            <div>
		            	<label for="remark">비고</label>
		              	<div>${pjt.remark }</div>
		            </div>
		            <div style="float:right;">
		            	<c:if test="${LOGIN_EMP.auth.no eq 1 || LOGIN_EMP.id eq pjt.registrant}">
			            	<button type="button" class="btn success" id="btn-modify-pjt" value="${pjt.no }">수정</button>
			            	<button type="button" class="btn danger" id="btn-del-pjt" value="${pjt.no }">삭제</button>
		            	</c:if>
		            	<button class="btn warning" type="button" onclick="location.href='project'">목록</button>
		            </div>
	            </div>
	       </div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#btn-del-pjt').click(function(){
			var pjtNo = $(this).val();
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href="pjtdelete?pjtNo=" + pjtNo;
			}
		});
		$('#btn-modify-pjt').click(function(){
			var pjtNo = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="pjtmodify?pjtNo=" + pjtNo;
			}
		});
	});
</script>	
</html>