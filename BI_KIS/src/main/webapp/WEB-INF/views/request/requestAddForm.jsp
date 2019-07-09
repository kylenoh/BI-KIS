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
		    <form method="post" action="addRequest" id="requestForm">
	                <div id="addForm">
		                <div>
		                    <label for="categoryName">분류 명</label>
		                    <select id="category" name="categoryName" class="inputTitle">
		                        <option></option>
	                        	<option value="error">에러</option>
	                        	<option value="정기점검">정기점검</option>
	                    	</select>  
		                </div>
		                <div>
		                    <label for="pjtNo">프로젝트 명</label>
		                    <select id="pjtNo" name="pjtNo" class="inputTitle">
		                    	<option></option>
		                    	<c:forEach var="project" items="${projectList }">
		                    		<option value="${project.no }">${project.title }</option>
		                    	</c:forEach>
		                    </select>
		                </div>
		                <div>
		                    <label for="companyName">고객사 명</label><input type="text" id="companyName" name="companyName" readonly="readonly" class="inputTitle">
		                </div>
		                <div>
		                    <label for="customer">담당자 명</label>
							<select id="customer" name="customerNo" class="inputTitle">
		                        <option></option>
	                    	</select>
		                </div>
		                <div class="form-inline">
		                    <label for="receiveDate">접수일</label><input type="date" id="receiveDate" name="receiveDate">    
		                    <label for="startDate">시작일</label><input type="date" id="startDate" name="startDate">    
		                    <label for="endDate">종료일</label><input type="date" id="endDate" name="endDate">
		                    <label for="closeDate">마감일</label><input type="date" id="closeDate" name="closeDate">
		                </div>
		                <div>
		                	<label for="flag">진행상황</label>
			            	<select id="flag" name="flag" class="inputTitle">  
			            		<option value="Y">진행예정</option>
			            		<option value="P">진 행 중</option>
			            		<option value="N">종     료</option>
			            	</select>
		                </div>
		                <div>
		                	<label for="suggest">요청 내용</label>
		                	<textarea id="suggest" name="suggest" class="summernote"></textarea>
		                </div>
		                <div>
		                	<label for="handle">처리 내용</label>
		                	<textarea id="handle" name="handle" class="summernote"></textarea>
		                </div>
		                <button class="btn success" type="submit">등록</button>
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
				rows += '<option>담당자 선택</option>';
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
	$('#requestForm').submit(function(){
		var category = $('#category');
		var project = $('#pjtNo');
		var customer = $('#customer');
		var receiveDate = $('#receiveDate');
		var closeDate = $('#closeDate');
		
		if("" == category.val()){
			alert("분류를 선택해주세요.");
			category.focus();
			return false;
		}
		if("" == project.val()){
			alert("프로젝트를 선택해주세요.");
			project.focus();
			return false;
		}
		if("" == customer.val()){
			alert("담당자를 선택해주세요.");
			customer.focus();
			return false;
		}
		if("" == receiveDate.val()){
			alert("접수일을 선택해주세요.");
			receiveDate.focus();
			return false;
		}
		if("" == closeDate.val()){
			alert("마감일을 선택해주세요.");
			closeDate.focus();
			return false;
		}
	})
})
</script>
</html>