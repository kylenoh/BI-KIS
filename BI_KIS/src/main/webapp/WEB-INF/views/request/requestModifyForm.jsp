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
			<form method="post" action="requestModify" id="requestForm">
				<input type="hidden" name="requestNo" value="${request.no }" >
		            <div id="requestDetail">
			            <div>
			                <label for="category">분류 명</label>
			                <select id="category" name="categoryNo" class="inputTitle">
	                        	<option value="error" <c:if test="${request.categoryName eq 'error' }">selected</c:if>>에러 </option>
	                        	<option value="정기점검" <c:if test="${request.categoryName eq '정기점검' }">selected</c:if>>정기점검 </option>
	                    	</select>   
			            </div>
			            <div>
			        	    <label for="pjtName">프로젝트 명</label><input type="text" class="inputTitle" id="pjtName" name="pjtName" value="${request.project.title }">
			            </div>
			            <div>
			                <label for="companyName">고객사 명</label><input type="text" class="inputTitle" id="companyName" name="companyName" value="${request.project.company.name }" readonly="readonly">
			            </div>
			            <div>
			                <label for="customerName">담당자 명</label>
							<select id="customer" name="customerNo" class="inputTitle">
		                        <c:forEach var="customer" items="${customerList }">
		                        	<option value="${customer.no }" <c:if test="${request.customer.no eq customer.no }">selected</c:if>>${customer.name } </option>
		                        </c:forEach>
	                    	</select>
			            </div>
			            <div id="form-inline">
			                <label for="receiveDate">시작일</label>
			                <input type="date" id="receiveDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.receiveDate }"/>">    
			                <label for="startDate">시작일</label>
			                
			                <input type="date" id="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.startDate }"/>">    
			                <label for="endDate">종료일</label>
			                
			                <input type="date" id="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.endDate }"/>">
			                <label for="closeDate">종료일</label><input type="date" id="closeDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${request.closeDate }"/>">
			            </div>
			            <div>
			              	<label for="flag">진행상황</label>
				          	<select id="flag" name="flag" class="inputTitle">
			            		<option value="Y" <c:if test="${request.flag eq 'Y' }">selected</c:if>>진행예정</option>
			            		<option value="P" <c:if test="${request.flag eq 'P' }">selected</c:if>>진 행 중</option>
			            		<option value="N" <c:if test="${request.flag eq 'N' }">selected</c:if>>종     료</option>
			            	</select>
			            </div>
			            <div>
			             	<label for="suggest">요청 내용</label>
			              	<textarea id="suggest" name="suggest" class="textContent">${request.suggest }</textarea>
			            </div>
			            <div>
			             	<label for="handle">처리 내용</label>
			              	<textarea id="handle" name="handle" class="textContent">${request.handle }</textarea>
			            </div>
			            <div style="float:right;">
				         	<button class="btn success" type="submit">수정</button>
				        	<button class="btn danger" type="button" onclick="location.href='requestDetail?requestNo=${request.no}'">취소</button>
				        </div>
		            </div>
	        </form>
		</div>
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