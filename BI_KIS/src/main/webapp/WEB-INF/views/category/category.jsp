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
			<%@include file="../emp-interface.jsp" %>
			<div class="main">
				<div class="container">
					<c:forEach var="category" items="${categoryList}">
						<div>
							${category.CATE_DIVISION_NAME }
						</div>
						<c:forEach var="categoryAll" items="${categoryAllList }">
							<c:if test="${category.CATE_DIVISION_NAME == categoryAll.CATE_DIVISION_NAME }">
								<div style="text-indent:20px;">
									${categoryAll.CATE_SECTION_NAME}
								</div>
							</c:if>
							<c:if test="${category.CATE_DIVISION_NAME == categoryALL.CATE_DIVISION_NAME && categoryALL.CATE_DIVISION_NAME == '솔루션' && category.CATE_NO - 1 == categoryAll.CATE_NO }">
								<div>
								성공
								</div>
							</c:if>
						</c:forEach>
					</c:forEach>
				</div>
			</div>
		</div>
</body>
</html>