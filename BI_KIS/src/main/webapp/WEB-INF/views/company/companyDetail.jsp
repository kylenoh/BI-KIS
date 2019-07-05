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
        	<div id="companyDetail">
        		<div>
	                <label for="title">고객사 명</label><input class="inputTitle"type="text" id="name" name="name" value="${company.name }"disabled="disabled">
	            </div>
	            <div>
	                <label for="owner">대표자</label><input class="inputTitle"type="text" id="owner" name="owner" value="${company.owner}"disabled="disabled">
	            </div>
	            <div>
	                <label for="tel">연락처</label><input class="inputTitle"type="text" id="tel" name="tel" value="${company.tel }"disabled="disabled">
	            </div>
	            <div>
	                <label for="addr">주소</label><input class="inputTitle"type="text" id="addr" name="addr" value="${company.addr }" disabled="disabled">
	            </div>
	            <div>
	             	<label for="remark">비고</label>
	               	<div id="remark">${company.remark }</div>
	            </div>
        	</div>
            <div style="float:right;">
            	<c:if test="${LOGIN_EMP.auth.no eq 1 || LOGIN_EMP.id eq company.registrant}">
            		<button type="button" class="btn success" id="btn-modify-company" value="${company.no }">수정</button>
            		<button type="button" class="btn danger" id="btn-del-company" value="${company.no }">삭제</button>
            	</c:if>
            	<button class="btn warning" type="button" onclick="location.href='company'">목록</button>
            </div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#btn-del-company').click(function(){
			var companyNo = $(this).val();
			if (confirm("정말 삭제하시겠습니까?"
					   +"소속 담당자들이 다 삭제 됩니다.")) {
				location.href="companyDelete?companyNo=" + companyNo;
			}
		});
		$('#btn-modify-company').click(function(){
			var companyNo = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="companyModify?companyNo=" + companyNo;
			}
		});
	});
</script>	
</html>