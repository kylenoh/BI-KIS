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
						<div id="category-${category.CATE_DIVISION_NAME }">
							${category.CATE_DIVISION_NAME }
							<form action="addCategory" method="post" id="category-form-${category.CATE_DIVISION_NAME }">
								<c:forEach var="categoryAll" items="${categoryAllList }">
									<c:if test="${category.CATE_DIVISION_NAME == categoryAll.CATE_DIVISION_NAME }">
										<div style="text-indent:20px;">
											${categoryAll.CATE_SECTION_NAME}
										</div>
									</c:if>
								</c:forEach>
							</form>
						</div>
					</c:forEach>
				</div>
				<div>
					<input type="submit" form="category-form-솔루션" value="저장"/>
				</div>
			</div>
		</div>
</body>

<script type="text/javascript">
	$(function(){
		var categoryArea = $('#category-솔루션');
		var btnRow = "<div>";
		btnRow += "<button type='button' id='add-category-btn'>+</button>";
		btnRow += "</div>";
		btnRow += "<input type='hidden' name='divisionName' value='솔루션'>";
		categoryArea.children().append(btnRow);
		
		$('[id^=category-form]').on('click','#add-category-btn',function(){
			var row = "<div>";
			row += "<input tpye='text' name='addCategoryName'>";
			row += "<a class='add-category-info close' href='javascript:void(0)'> x </a>";
			row += "</div>";
			$(this).before(row);
		})
		$('[id^=category-]').on('click','.add-category-info',function(){
			$(this).parent().remove();
		})
	})
	
</script>
</html>