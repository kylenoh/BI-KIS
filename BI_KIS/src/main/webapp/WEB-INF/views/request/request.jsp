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
	    <form method="post" action="request" id="searchForm">
            <fieldset>
                <legend>검색라인</legend>
                <div class="search-line">
                    <label for="categoryValue">분류 명</label>
	                <select id="category" name="categoryValue">
		                <option value="0"></option>
		               	<option value="error">error</option>
		               	<option value="정기점검">정기점검</option>
	                </select>      
                </div>
                <div class="search-line">
                	<label for="flag">진행상황</label>
                	<select id="request-flag" name="flag">
                        <option value="all">All</option>
                        <option value="Y">진행예정</option>
                        <option value="P">진행중</option>
                        <option value="N">종료</option>
                    </select>
                </div>
                <div class="search-line">
                    <label for="companyName">고객사 명</label><input type="text" id="companyName" name="companyName">
                </div>
                <div class="search-line">
                	<div>
	                	<label for="dateOpt">날짜기준</label>
	                	<select id="request-date-opt" name="dateOpt">
	                        <option value="all"></option>
	                        <option value="receive">접수일</option>
	                        <option value="start">시작일</option>
	                        <option value="end">종료일</option>
	                        <option value="close">마감일</option>
	                    </select>
                    </div>
                    <div>
                    	<label for="fromDate"></label><input type="date" id="fromDate" name="fromDate">~    
                    	<label for="toDate"></label><input type="date" id="toDate" name="toDate">
                    </div>
                </div>
                <div class="search-line">
                    <label for="suggest">요청내용</label><input type="text" id="suggest" name="suggest">
                    <button class="ym-search-btn" type="submit">검색</button>
                </div>
            </fieldset>
		</form>
		<button type="button" onclick="location.href='addRequest'" class="write">기술지원 등록</button>
		<div>
			<span> 게시글 수 : ${totalRows}</span>
		</div>
		<table border="1">
			<thead>
				<tr>
					<th>분류 명</th>
					<th>요청내용</th>
					<th>고객사 명</th>
					<th>프로젝트 명</th>
					<th>담당자 명</th>
					<th>지원담당자</th>
					<th>접수일</th>
					<th>마감일</th>
					<th>진행상황</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${!empty requestList }">
						<c:forEach var="request" items="${requestList }">
						<tr>
							<td>${request.categoryName }</td>
							<td><a class="no-link" href="requestDetail?requestNo=${request.no }">${request.suggest }</a></td>
							<td>${request.project.company.name }</td>
							<td>${request.project.title }</td>
							<td>${request.customer.name }</td>
							<td>${request.emp.name }</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${request.receiveDate }"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${request.closeDate }"/></td>
							<td>
								<c:if test="${request.flag eq 'Y' }">
			                    	진행예정
			                    </c:if>
			                    <c:if test="${request.flag eq 'P' }">
			                    	진행중
			                    </c:if>
			                    <c:if test="${request.flag eq 'N' }">
			                    	종료
			                    </c:if>
							</td>
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="9">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div align="center"> 
			<c:if test="${!empty requestList}">
				<c:if test="${pagination.cb gt 1 }">
					<a href="request?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
				</c:if>
				<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
					<a href="request?cp=${num}">${num }</a>
				</c:forEach>
				<c:if test="${pagination.cb lt pagination.totalBlocks }">
					<a href="request?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
				</c:if>
			</c:if>
		</div>
	</div>
</div>
	
</body>
</html>