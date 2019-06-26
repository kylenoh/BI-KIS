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
		<form method="post" action="companyModify" id="companyForm">
			<input type="hidden" name="companyNo" value="${company.no}">
		    <fieldset>
	        	<legend>고객사</legend>
	        	<div id="companyDetail">
	        		<div>
		                <label for="title">고객사 명</label><input type="text" id="name" name="name" value="${company.name }">
		            </div>
		            <div>
		                <label for="owner">대표자</label><input type="text" id="owner" name="owner" value="${company.owner}">
		            </div>
		            <div>
		                <label for="tel">연락처</label><input type="text" id="tel" name="tel" value="${company.tel }">
		            </div>
		            <div>
		                <label for="addr">주소</label><input type="text" id="addr" name="addr" value=${company.addr }>
		            </div>
		            <div>
		             	<label for="remark">비고</label>
		               	<textarea id="remark" name="remark">${company.remark}</textarea>
		            </div>
	        	</div>
		        <div style="float:right;">
		         	<button class="ym-btn" type="submit">수정</button>
		           	<button class="ym-btn" type="button" onclick="location.href='companyDetail?companyNo=${company.no}'">취소</button>
		        </div>
	        </fieldset>
        </form>
	</div>
</div>
</body>
</html>