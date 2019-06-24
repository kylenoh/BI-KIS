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
		<div class="header-left">
			<ul class="breadcrumb">
			  <li>BI 기술 지원</li>
			  <li>기술 지원 이력</li>
			  <li>기술 지원 등록</li>
			</ul>
		</div>
		<%@ include file="../emp-interface.jsp" %>
	</div>
	<div class="main">
        <fieldset>
            <legend>기술 지원 등록</legend>
            <div id="requestDetail">
	            <div>
	                <label for="category">분류 명</label>
	                <input type="text" id="categoryName" name="categoryName" value="${request.categoryName }" disabled="disabled">  
	            </div>
	            <div>
	        	    <label for="pjtName">프로젝트 명</label><input type="text" id="pjtName" name="pjtName" value="${request.project.title }" disabled="disabled">
	            </div>
	            <div>
	                <label for="companyName">고객사 명</label><input type="text" id="companyName" name="companyName" value="${request.project.company.name }" disabled="disabled">
	            </div>
	            <div>
	                <label for="customerName">담당자 명</label>
					<input type="text" id="customerName" name="customerName" value="${request.customer.name }" disabled="disabled">
	            </div>
	            <div id="requestDate">
	                <label for="startDate">시작일</label><input type="date" id="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.startDate }"/>" disabled="disabled">    
	                <label for="endDate">종료일</label><input type="date" id="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.endDate }"/>" disabled="disabled">
	            </div>
	            <div>
	              	<label for="flag">진행상황</label>
		          	<input type="text" id="flag" name="flag" value="${request.msg }" disabled="disabled">
	            </div>
	            <div>
	             	<label for="suggest">요청 내용</label>
	              	<textarea id="suggest" name="suggest" disabled="disabled">${request.suggest }</textarea>
	            </div>
	            <div>
	             	<label for="handle">처리 내용</label>
	              	<textarea id="handle" name="handle" disabled="disabled">${request.handle }</textarea>
	            </div>
	            <div style="float:right;">
	            	<c:if test="${LOGIN_EMP.auth.no eq 1 || LOGIN_EMP.auth.no eq 2 || LOGIN_EMP.id eq pjt.registrant}">
		            	<button type="button" class="btn-modify-request" value="${request.no }">수정</button>
		            	<button type="button" class="btn-del-request" value="${request.no }">삭제</button>
		            </c:if>
	            	<button type="button" onclick="location.href='request'">목록</button>
	            </div>
            </div>
        </fieldset>
	</div>
</div>
	
</body>
<script type="text/javascript">
	$(function(){
		$('.btn-del-request').click(function(){
			var requestNo = $(this).val();
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href="requestDelete?requestNo=" + requestNo;
			}
		});
		$('.btn-modify-request').click(function(){
			var requestNo = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="requestModify?requestNo=" + requestNo;
			}
		});
	});
</script>
</html>