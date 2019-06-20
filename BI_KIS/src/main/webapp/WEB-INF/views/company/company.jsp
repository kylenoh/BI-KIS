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
			  <li>고객사 관리</li>
			</ul>
		</div>
		<%@ include file="../emp-interface.jsp" %>
	</div>
	
	<div class="main">
	    <form method="post" action="company" id="searchForm">
            <fieldset>
                <legend>검색라인</legend>
                <div>
                    <label for="title">고객사 명</label><input type="text" id="name" name="name">
                </div>
                <div>
                    <label for="email">이메일</label><input type="text" id="email" name="email">
                </div>
                <div>
                    <label for="customerName">담당자 명</label><input type="text" id="customerName" name="customerName">
                </div>
                <div>
                    <div>
                    	<label for="dept">부서</label><input type="text" id="dept" name="dept">
                	</div>
                    <button type="submit">Search</button>
                </div>
            </fieldset>
		</form>
		<button type="button" onclick="location.href='addCompany'" class="write">고객사 등록</button>
		<button type="button" onclick="location.href='addCustomer'" class="write">담당자 등록</button>
		
		<table border="1">
			<thead>
				<tr>
					<th>고객사 명</th>
					<th>담당자</th>
					<th>담당자연락처</th>
					<th>이메일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="company" items="${companyList }">
					<tr>
						<td><a href="companyDetail?companyNo=${company.no}&customerNo=${company.customer.no}">${company.name}</a></td>
						<td>${company.customer.name }</td>
						<td>${company.customer.tel1 }</td>
						<td>${company.customer.email }</td>
						<td>${company.customer.remark }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div align="center">
			<c:if test="${!empty companyList}">
				<c:if test="${pagination.cb gt 1 }">
					<a href="company?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
				</c:if>
				<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
					<a href="company?cp=${num}">${num }</a>
				</c:forEach>
				<c:if test="${pagination.cb lt pagination.totalBlocks }">
					<a href="company?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
				</c:if>
			</c:if>
		</div>
	</div>
</div>
	
</body>
</html>