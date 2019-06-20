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
function myPage(){
	var condition = $('#myPage').toggleClass("show");
	if (condition.hasClass("show")) {
		$('.dropdown-content').css("display","block");
	}else{
		$('.dropdown-content').css("display","none");
	}
}
</script>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li>BI 기술 지원</li>
			  <li>기술 지원 이력</li>
			  <li>기술 지원 등록</li>
			</ul>
		</div>
		<div class="header-right">
			<ul class="userInterface">
				<li>
					<span id="myPage" onclick="myPage();" class="dropbtn"><i class="fas fa-cog">마이페이지</i></span>
				</li>
				<li><span><i class="fas fa-sign-in-alt">로그아웃</i></span></li>
			</ul>
            <div id="myDropdown" class="dropdown-content">
            	<a href="#home">Home</a>
                <a href="#about">About</a>
                <a href="#contact">Contact</a>
            </div>
		</div>
	</div>
	<div class="main">
		<form method="post" action="requestModify" id="requestForm">
			<input type="hidden" name="requestNo" value="${request.no }">
	        <fieldset>
	            <legend>기술 지원 등록</legend>
	            <div id="requestDetail">
		            <div>
		                <label for="category">분류 명</label>
		                <select id="category" name="categoryNo">
	                        <c:forEach var="category" items="${categoryList }">
	                        	<option value="${category.no }" <c:if test="${request.category.no eq category.no }">selected</c:if>>${category.name } </option>
	                        </c:forEach>
                    	</select>   
		            </div>
		            <div>
		        	    <label for="pjtName">프로젝트 명</label><input type="text" id="pjtName" name="pjtName" value="${request.project.title }">
		            </div>
		            <div>
		                <label for="companyName">고객사 명</label><input type="text" id="companyName" name="companyName" value="${request.project.company.name }" readonly="readonly">
		            </div>
		            <div>
		                <label for="customerName">담당자 명</label>
						<select id="customer" name="customerNo">
	                        <c:forEach var="customer" items="${customerList }">
	                        	<option value="${customer.no }" <c:if test="${request.customer.no eq customer.no }">selected</c:if>>${customer.name } </option>
	                        </c:forEach>
                    	</select>
		            </div>
		            <div id="requestDate">
		                <label for="startDate">시작일</label><input type="date" id="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.startDate }"/>">    
		                <label for="endDate">종료일</label><input type="date" id="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.endDate }"/>">
		            </div>
		            <div>
		              	<label for="flag">진행상황</label>
			          	<select id="flag" name="flag">
		            		<option value="Y" <c:if test="${request.flag eq 'Y' }">selected</c:if>>진행예정</option>
		            		<option value="P" <c:if test="${request.flag eq 'P' }">selected</c:if>>진 행 중</option>
		            		<option value="N" <c:if test="${request.flag eq 'N' }">selected</c:if>>종     료</option>
		            	</select>
		            </div>
		            <div>
		             	<label for="suggest">요청 내용</label>
		              	<textarea id="suggest" name="suggest">${request.suggest }</textarea>
		            </div>
		            <div>
		             	<label for="handle">처리 내용</label>
		              	<textarea id="handle" name="handle">${request.handle }</textarea>
		            </div>
		            <div style="float:right;">
			         	<button type="submit">수정</button>
			        	<button type="button" onclick="location.href='requestDetail?requestNo=${request.no}'">뒤로가기</button>
			        </div>
	            </div>
	        </fieldset>
        </form>
	</div>
</div>
	
</body>
<script type="text/javascript">
$(function(){
	$('#pjtNo').on('change',function(){
		var projectNo = $(this).val();
		$.ajax({
			url: "getCustomerByProjectInfo",
			data: {projectNo:projectNo},
			dataType: 'json',
			success:function(results){
				var rows = "";
				rows += '<option value="all">담당자 선택</option>';
				$.each(results, function(index, result){
					rows += '<option value="' + result.no + '" >';
					rows += result.name + '</option>';
				});
				$('#companyName').val(results[0].company.name);
				$('#customer').children().remove();
				$('#customer').append(rows);
			}
		})
	});
})
</script>
</html>