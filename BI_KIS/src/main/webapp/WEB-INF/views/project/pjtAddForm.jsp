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
		    <form method="post" action="pjtadd" id="pjtForm">
	                <div id="addForm">
		                <div>
		                    <label for="title">프로젝트 명</label><input type="text" id="project" name="title" class="inputTitle">
		                </div>
		                <div>
		                    <label for="company">고객사 명</label>
		                    <select id="company" name="companyNo" class="inputTitle">
		                        <option></option>
		                        <c:forEach var="comList" items="${companyList }">
		                        	<option value="${comList.no }">${comList.name }</option>
		                        </c:forEach>
	                    	</select>    
		                </div>
		                <div class="form-inline">
		                    <label for="startDate">시작일</label><input type="date" id="startDate" name="startDate">    
		                    <label for="endDate">종료일</label><input type="date" id="endDate" name="endDate">
		                </div>
		                <div id="emp-area">
		                	<label>담당자</label>
		                	<select id="emp" class="inputTitle">
		                		<option></option>
		                		<c:forEach var="emp" items="${empList }">
		                			<option id="emp-id-${emp.id }" value="${emp.id }">${emp.name }</option>
		                		</c:forEach>
		                	</select>
		                </div>
		                <div>
		                    <label for="content">내용</label>                    
		                    <textarea class="summernote" name="content"></textarea>
		                </div>
		                <div>
		                	<label for="remark">비고</label>
		                	<textarea class="summernote" name="remark"></textarea>
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
		$('#emp').on('change',function(){
			var empId = $(this).val();
			var row ="";
			var hidden = "";
			
			if($('.close-cate').hasClass(empId)){
				alert("이미 등록 되어 있는 직원 입니다.");
				$('#emp').find('option:first').prop('selected', 'selected');
			} else {
				$.ajax({
					url: "getEmpByEmpIdInfo",
					data: {empId:empId},
					dataType: 'json',
					success:function(result){
						row += '<div style="display:inline-block; width: auto !important;">';
						row += '<span>' + result.name + '</span>';
						row += '<a id="emp-info-' + result.id +'" class="close-cate ' + result.id + '" href="javascript:void(0)"> x </a>';
						row += '<input type="hidden" name="emp-info" value="' + result.id + '">';
						row += '</div>';
						$('#emp').find('option:first').prop('selected', 'selected');
						$('#emp-area').append(row);	
					}
				});
			}
		});
		$('#emp-area').on('click','[id^=emp-info-]',function(){
			$(this).parent().remove();
		})
		
		$('#pjtForm').submit(function(){
			var project = $('#project');
			var company = $('#company');
			var startDate = $('#startDate');
			var endDate = $('#endDate');
			
			if("" == project.val()){
				alert("프로젝트 명을 입력해주세요.");
				project.focus();
				return false;
			}
			if("" == company.val()){
				alert("고객사를 선택해주세요.");
				company.focus();
				return false;
			}
			if("" == startDate.val()){
				alert("시작일을 선택해주세요.");
				startDate.focus();
				return false;
			}
			if("" == endDate.val()){
				alert("종료일을 선택해주세요.");
				endDate.focus();
				return false;
			}
		})
});
</script>
</html>