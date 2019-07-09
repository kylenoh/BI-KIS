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
	    <form method="post" action="project" id="searchForm">
            <fieldset>
                <legend>검색라인</legend>
                <div class="form-inline">
                    <label for="title">프로젝트 명</label><input type="text"  id="search-title" name="title" value="${param.title }">
                    <label for="companyName">고객사 명</label><input type="text" id="search-companyName" name="companyName" value=${param.companyName }>
                	<label for="flag">진행상태</label>
                    <select id="search-flag" name="flag">
                        <option value="all" ${param.flag eq 'all' ? 'selected' : '' }>전체</option>
                        <option value="Y" ${param.flag eq 'Y' ? 'selected' : '' }>진행예정</option>
                        <option value="P" ${param.flag eq 'P' ? 'selected' : '' }>진행중</option>
                        <option value="N" ${param.flag eq 'N' ? 'selected' : '' }>종료</option>
                    </select>
                </div>
                <div class="form-inline">
	                	<label for="dateOpt">날짜기준</label>
	                	<select id="project-date-opt" name="dateOpt">
	                        <option value="all"></option>
	                        <option value="start" ${param.dateOpt eq 'start' ? 'selected' : '' }>시작일</option>
	                        <option value="end" ${param.dateOpt eq 'end' ? 'selected' :  '' }>종료일</option>
	                    </select>
	                    <label for="fromDate"></label><input type="date" id="search-fromDate" name="fromDate" value="${param.fromDate}">    
                    	<label for="toDate"></label><input type="date" id="search-toDate" name="toDate" value="${param.toDate }">
	                	<button class="btn info" type="submit">검색</button>
                </div>
            </fieldset>
		</form>
		<div>
			<button class="btn success" onclick="location.href='addproject'" >프로젝트 등록</button>
			<span> 게시글 수 : ${totalRows}</span>
		</div>
		<table border="1">
			<thead>
				<tr>
					<th>프로젝트 명</th>
					<th>고객사 명</th>
					<th>진행일자</th>
					<th>담당직원</th>
					<th>진행상태</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${!empty pjtList }">
						<c:forEach var="project" items="${pjtList }">
							<tr>
								<td><a class="no-link" href="pjtdetail?pjtNo=${project.no }">${project.title }</a></td>
								<td>${project.company.name }</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${project.startDate }"/>
								  ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${project.endDate }"/></td>
								<td class="emp-list">
									<c:forEach var="emp" items="${project.emps }" varStatus="status">
										<c:if test="${!status.last }">
											${emp.name},
										</c:if>
										<c:if test="${status.last }">
											${emp.name}
										</c:if> 
									</c:forEach>
								</td>
								<td>
									<c:if test="${project.flag eq 'Y' }">
				                    	진행예정
				                    </c:if>
				                    <c:if test="${project.flag eq 'P' }">
				                    	진행중
				                    </c:if>
				                    <c:if test="${project.flag eq 'N' }">
				                    	종료
				                    </c:if>
								</td>
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
				<c:if test="${!empty pjtList}">
					<c:if test="${pagination.cb gt 1 }">
						<a href="project?cp=${pagination.beginPageIndex - 1}+ &flag=${param.flag}">&laquo;</a>
					</c:if>
					<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
						<a href="project?cp=${num}&title=${param.title }&flag=${param.flag}">${num }</a>
					</c:forEach>
					<c:if test="${pagination.cb lt pagination.totalBlocks }">
						<a href="project?cp=${pagination.endPageIndex + 1 }+ &flag=${param.flag}">&raquo;</a>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
</div>
	
</body>
</html>