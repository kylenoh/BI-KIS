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
			  <li>BI 사업부</li>
			  <li>고객사 관리</li>
			  <li>고객사 등록</li>
			</ul>
		</div>
		<%@ include file="../emp-interface.jsp" %>
	</div>
	<div class="main">
	    <form method="post" action="addCompany" id="companyForm">
            <fieldset>
                <legend>고객사 등록</legend>
                <div id="addForm">
	                <div>
	                    <label for="title">고객사 명</label><input type="text" id="name" name="name">
	                </div>
	                <div>
	                    <label for="owner">대표자</label><input type="text" id="owner" name="owner">
	                </div>
	                <div>
	                    <label for="tel">연락처</label><input type="text" id="tel" name="tel">
	                </div>
	                <div>
	                    <label for="addr">주소</label><input type="text" id="addr" name="addr">
	                </div>
	                <div>
	                	<label for="remark">비고</label>
	                	<textarea id="remark" name="remark"></textarea>
	                </div>
	                <button type="submit">등록</button>
                </div>
            </fieldset>
		</form>
	</div>
</div>
	
</body>
</html>