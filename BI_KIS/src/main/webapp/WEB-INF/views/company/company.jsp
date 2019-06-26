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
	    <form method="post" action="company" id="searchForm">
            <fieldset>
                <legend>검색라인</legend>
                <div>
                    <label for="title">고객사 명</label><input type="text" class="inputSearch" id="name" name="name">
                </div>
                <div>
                    <label for="email">이메일</label><input type="text" class="inputSearch" id="email" name="email">
                </div>
                <div>
                    <label for="customerName">담당자 명</label><input type="text" class="inputSearch" id="customerName" name="customerName">
                </div>
                <div>
                    <div>
                    	<label for="dept">부서</label><input type="text" class="inputSearch" id="dept" name="dept">
                	</div>
                    <button class="btn info" type="submit">검색</button>
                </div>
            </fieldset>
		</form>
		<button class="btn success" onclick="location.href='addCompany'" >고객사 등록</button>
		<button class="btn success" onclick="location.href='addCustomer'">담당자 등록</button>
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
				<c:choose>
					<c:when test="${!empty companyList }">
						<c:forEach var="company" items="${companyList }">
							<tr>
								<td><a class="no-link" href="companyDetail?companyNo=${company.no}">${company.name}</a></td>
								<td><a class="no-link" href="customerDetail?customerNo=${company.customer.no}">${company.customer.name }</a></td>
								<td>${company.customer.tel1 }</td>
								<td>${company.customer.email }</td>
								<td>${company.customer.remark }</td>
							</tr>
						</c:forEach>			
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				
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