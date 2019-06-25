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
	    <form method="post" action="addCustomer" id="CustomerForm">
            <fieldset>
                <legend>담당자 등록</legend>
                <div id="addForm">
	                <div>
	                    <label for="name">담당자 명</label><input type="text" id="name" name="name">
	                </div>
	                <div>
	                    <label for="rank">직급</label><input type="text" id="rank" name="rank">
	                </div>
	                <div>
	                    <label for="dept">부서명</label><input type="text" id="dept" name="dept">
	                </div>
	                <div>
	                    <label for="tel1">연락처1</label><input type="text" id="tel1" name="tel1">
	                    <label for="tel2">연락처2</label><input type="text" id="tel2" name="tel2">
	                </div>
	                <div>
	                    <label for="email">이메일</label><input type="text" id="email" name="email">
	                </div>
	                <div>
	                    <label for="company">고객사 명</label>
	                    <select id="company" name="companyNo">
	                        <option value="all"></option>
	                        <c:forEach var="comList" items="${companyList }">
	                        	<option value="${comList.no }">${comList.name }</option>
	                        </c:forEach>
                    	</select>    
	                </div>
	                <div>
	                	<label for="remark">비고</label>
	                	<textarea id="remark" name="remark"></textarea>
	                </div>
	                <button class="ym-btn" type="submit">등록</button>
                </div>
            </fieldset>
		</form>
	</div>
</div>
	
</body>
</html>