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
						<th scope="col">접근 가능</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(auths)>0 }">
							<c:forEach var="auths" items="${auths }">
									<tr>
										<td>${auths.no }</td>
										<td>${auths.name }</td>
										<td class="category-auth">
											<c:forEach var="category"  items="${categoryList }" varStatus="stauts">
												<c:if  test="${auths.no <= category.CATE_AUTH_NO }">${category.CATE_DIVISION_NAME },</c:if>
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
	</div>
</div>
	
</body>
<script type="text/javascript">
$(function(){
	$(".category-auth").each(function(){
		var text = $.trim($(this).text());
		$(this).text(text.substring(0, text.length -1));	
	})
})
</script>
</html>