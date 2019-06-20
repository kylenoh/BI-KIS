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
		<div class="header-left">
			<ul class="breadcrumb">
			  <li>BI 기술 지원</li>
			  <li>기술 지원 이력</li>
			  <li>기술 지원 등록</li>
			</ul>
		</div>
		<%@ include file="../emp-interface.jsp" %>
	</div>
	<div class="main">
	    <form method="post" action="addRequest" id="requestForm">
            <fieldset>
                <legend>기술 지원 등록</legend>
                <div id="addForm">
	                <div>
	                    <label for="category">분류 명</label>
	                    <select id="category" name="categoryNo">
	                        <option value="all"></option>
	                        <c:forEach var="category" items="${categoryList }">
	                        	<option value="${category.no }">${category.name }</option>
	                        </c:forEach>
                    	</select>  
	                </div>
	                <div>
	                    <label for="pjtNo">프로젝트 명</label>
	                    <select id="pjtNo" name="pjtNo">
	                    	<option value="all"></option>
	                    	<c:forEach var="project" items="${projectList }">
	                    		<option value="${project.no }">${project.title }</option>
	                    	</c:forEach>
	                    </select>
	                </div>
	                <div>
	                    <label for="companyName">고객사 명</label><input type="text" id="companyName" name="companyName" readonly="readonly">
	                </div>
	                <div>
	                    <label for="customer">담당자 명</label>
						<select id="customer" name="customerNo">
	                        <option value="all">담당자 선택</option>
                    	</select>
	                </div>
	                <div id="requestDate">
	                    <label for="startDate">시작일</label><input type="date" id="startDate" name="startDate">    
	                    <label for="endDate">종료일</label><input type="date" id="endDate" name="endDate">
	                </div>
	                <div>
	                	<label for="flag">진행상황</label>
		            	<select id="flag" name="flag">  
		            		<option value="Y">진행예정</option>
		            		<option value="P">진 행 중</option>
		            		<option value="N">종     료</option>
		            	</select>
	                </div>
	                <div>
	                	<label for="suggest">요청 내용</label>
	                	<textarea id="suggest" name="suggest"></textarea>
	                </div>
	                <div>
	                	<label for="handle">처리 내용</label>
	                	<textarea id="handle" name="handle"></textarea>
	                </div>
	                <button type="submit">등록</button>
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