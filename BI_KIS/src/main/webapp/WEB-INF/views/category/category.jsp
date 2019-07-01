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
							<form action="categoryEvent" method="post" id="category-form-${category.CATE_DIVISION_NAME }">
								<c:forEach var="categoryAll" items="${categoryAllList }">
									<c:if test="${category.CATE_DIVISION_NAME == categoryAll.CATE_DIVISION_NAME }">
										<c:if test="${categoryAll.CATE_DIVISION_NAME == '솔루션'}">
											<div style="text-indent:20px;">
												${categoryAll.CATE_SECTION_NAME}
												<button type="button" id="category-modfiy-${categoryAll.CATE_NO}" value="${categoryAll.CATE_SECTION_NAME }">수정</button>
												<a id="category-close-${categoryAll.CATE_NO }" class="category-close close-cate delete-cate" href="javascript:void(0)">x</a>
											</div>
										</c:if>
										<c:if test="${categoryAll.CATE_DIVISION_NAME != '솔루션'}">
											<div style="text-indent:20px;">
												${categoryAll.CATE_SECTION_NAME}
											</div>
										</c:if>
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
		btnRow += "<input type='hidden' name='CATE_DIVISION_NAME' value='솔루션'>";
		categoryArea.children().append(btnRow);
		
		$('[id^=category-form]').on('click','[id^=category-modfiy-]',function(){
			categoryNo = $(this).attr('id').replace('category-modfiy-','');
			categorySectionName = $(this).val();
			var row = "<input type='text' name='SECTION_NAME_LIST' value='" + categorySectionName + "'>";
			row += "<input type='hidden' name='CATE_NO_LIST' value = '" + categoryNo +"'>";
			row += "<a class='category-close close-cate' href='javascript:void(0)'>x</a>";
			$(this).parent().html(row);
		});
		$('[id^=category-form]').on('click','#add-category-btn',function(){
			var row = "<div>";
			row += "<input tpye='text' name='ADD_SECTION_NAME_LIST'>";
			row += "<a class='category-close close-cate' href='javascript:void(0)'> x </a>";
			row += "</div>";
			$(this).before(row);
		})
		$('[id^=category-]').on('click','.category-close',function(){
			if($(this).hasClass('delete-cate')){
				var categoryNo = $(this).attr('id').replace('category-close-','');
				var row = "<input type='hidden' name='DEL_CATE_NO_LIST' value='" + categoryNo +"'>";
				$(this).parent().before(row);
				$(this).parent().remove();
			}else{
				$(this).parent().remove();	
			}
			
		})
	})
	
</script>
</html>