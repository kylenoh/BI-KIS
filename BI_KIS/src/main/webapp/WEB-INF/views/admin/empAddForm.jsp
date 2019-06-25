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
	    <form method="post" action="empAdmin" id="searchForm">
            <fieldset>
                <legend>검색라인</legend>
                <div>
                    <label for="name">사원 명</label><input type="text" id="name" name="name">
                </div>
                <div>
                    <button type="submit">Search</button>
                </div>
            </fieldset>
		</form>
		<table border="1">
			<thead>
				<tr>
					<th>아이디</th>
					<th>사원명</th>
					<th>직책</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>권한</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${empList }">
					<tr>
						<td><a class="no-link" href="empDetail?empId=${emp.id}">${emp.id}</a></td>
						<td>${emp.name}</td>
						<td>${emp.rank}</td>
						<td>${emp.tel}</td>
						<td>${emp.email}</td>
						<td>
							<select id="empAuth" name="empAuth">
								<c:forEach var="listAuth" items="${authList }">
									<option value="${listAuth.no }" <c:if test="${emp.auth.no eq listAuth.no }">selected</c:if>>${listAuth.name}</option>
								</c:forEach>
							</select>
						</td>
						<td><button type="button" id="btn-modify-emp-${emp.id }" value="${emp.id }">수정</button></td>
						<td><button type="button" id="btn-delete-emp-${emp.id }" value="${emp.id }">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div align="center">
			<c:if test="${!empty empList}">
				<c:if test="${pagination.cb gt 1 }">
					<a href="empAdmin?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
				</c:if>
				<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
					<a href="empAdmin?cp=${num}">${num }</a>
				</c:forEach>
				<c:if test="${pagination.cb lt pagination.totalBlocks }">
					<a href="empAdmin?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
				</c:if>
			</c:if>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$('[id^=btn-delete-emp-]').click(function(){
			var empId = $(this).val();
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href="empDelete?empId=" + empId;
			}
		});
		$('[id^=btn-modify-emp-]').click(function(){
			var empId = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="empModify?empId=" + empId;
			}
		});
	});
</script>	
</body>

</html>