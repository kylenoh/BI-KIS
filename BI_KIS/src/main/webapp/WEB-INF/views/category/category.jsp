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
						<div class="category-${category.CATE_DIVISION_NAME }">
							${category.CATE_DIVISION_NAME }
						<c:forEach var="categoryAll" items="${categoryAllList }">
							<c:if test="${category.CATE_DIVISION_NAME == categoryAll.CATE_DIVISION_NAME }">
								<div style="text-indent:20px;">
									${categoryAll.CATE_SECTION_NAME}
								</div>
							</c:if>
						</c:forEach>
						</div>
					</c:forEach>
			</div></div>
		</div>
</body>
<script type="text/javascript">
	$(function(){
		var gr = $('.category-솔루션');
		row = "<div>추가</div>";
		gr.append(row);
	})
</script>
</html>