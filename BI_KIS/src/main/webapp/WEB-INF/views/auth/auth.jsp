<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../style.jsp" %>
<title>Insert title here</title>
<script type="text/javascript">
function propertyWrite(){
	location.href = "propertyWrite";
}
function propertyModify(no){
	location.href = "propertyModify?no="+no;
}
function propertyDelete(no,flag){
	location.href = "propertyDelete?no="+no+"&flag="+flag;
}
</script>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
		<%@include file="../emp-interface.jsp" %>
	<div class="main">
		<div class="container">
			<table border="1" style="border-collapse: collapse;">
				<colgroup>
					<col width="10%">
					<col width="20%">
					<col width="*">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">권한번호</th>
						<th scope="col">권한 명</th>
						<th scope="col">권한 내용</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(auths)>0 }">
							<c:forEach var="auths" items="${auths }">
									<tr>
										<td>${auths.no }</td>
										<td>${auths.name }</td>
										<td>
											<c:forEach var="category" items="${categoryList }" varStatus="stauts">
												<c:if test="${auths.no <= category.CATE_AUTH_NO }">
													<c:if test="${!stauts.last }">
														${category.CATE_SECTION_NAME },
													</c:if>
													<c:if test="${status.last }">
														${category.CATE_SECTION_NAME }
													</c:if>
												</c:if>
											</c:forEach>
										</td>
									</tr>
								</c:forEach>
			
						</c:when>
							<c:otherwise>
								<tr>
									<td colspan="3">조회된 결과가 없습니다.</td>
								</tr>					
							</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="footer">
		<div align="center">
			<c:if test="${!empty auths }">
				<c:if test="${pagination.cb gt 1 }">
					<a href="auth?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
				</c:if>
				<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
					<a href="auth?cp=${num}">${num }</a>
				</c:forEach>
				<c:if test="${pagination.cb lt pagination.totalBlocks }">
					<a href="auth?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
				</c:if>
			</c:if>
		</div>
	</div>
</div>
	
</body>
</html>