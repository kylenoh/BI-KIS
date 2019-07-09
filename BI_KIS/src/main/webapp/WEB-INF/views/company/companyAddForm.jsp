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
		    <form method="post" action="addCompany" id="companyForm">
	                <div id="addForm">
		                <div>
		                    <label for="title">고객사 명</label><input type="text" id="name" name="name" class="inputTitle">
		                </div>
		                <div>
		                    <label for="owner">대표자</label><input type="text" id="owner" name="owner"class="inputTitle">
		                </div>
		                <div>
		                    <label for="tel">연락처</label><input type="text" id="tel" name="tel" class="inputTitle">
		                </div>
		                <div>
		                    <label for="addr">주소</label><input type="text" id="addr" name="addr" class="inputTitle">
		                </div>
		                <div>
		                	<label for="remark">비고</label>
		                	<textarea id="remark" name="remark" class="summernote"></textarea>
		                </div>
		                <button type="submit" class="btn success">등록</button>
	                </div>
			</form>
		</div>
	</div>
</div>
	
</body>
<script type="text/javascript">
$(function(){
	$('#companyForm').submit(function(){
		var companyName = $('#name');
		
		if("" == companyName.val()){
			alert("고객사 명을 입력해주세요.");
			project.focus();
			return false;
		}
	});
})
</script>
</html>