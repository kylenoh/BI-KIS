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
			<form method="post" action="customerModify" id="customerForm">
				<input type="hidden" name="no" value="${customer.no}">
		            <div id="customerDetail">
			        	<div>
			            	<label for="name">담당자 명</label><input type="text" id="name" name="name" value="${customer.name }" class="inputTitle">
			            </div>
			            <div>
			                <label for="rank">직급</label><input type="text" id="rank" name="rank" value="${customer.rank }" class="inputTitle">
			            </div>
			            <div>
			                <label for="dept">부서명</label><input type="text" id="dept" name="dept" value="${customer.dept }" class="inputTitle"> 
			            </div>
			            <div>
			                <label for="tel1">연락처1</label><input type="text" id="tel1" name="tel1" value="${customer.tel1 }" class="inputTitle">
			                <label for="tel2">연락처2</label><input type="text" id="tel2" name="tel2" value="${customer.tel2 }" class="inputTitle">
			            </div>
			            <div>
			                <label for="email">이메일</label><input type="text" id="email" name="email" value="${customer.email }" class="inputTitle">
			            </div>
			            <div>
			              	<label for="remark">비고</label>
			               	<textarea id="remark" name="remark" class="summernote">${customer.remark }</textarea>
			            </div>
			            <div style="float:right;">
			            	<button class="btn success" type="submit">수정</button>
			            	<button class="btn danger" type="button" onclick="location.href='customerDetail?no=${customer.no}'">취소</button>
			            </div>
		            </div>
	        </form>
        </div>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$('#CustomerForm').submit(function(){
		var customerName = $('#name');
		
		
		if("" == customerName.val()){
			alert("담당자 명을 입력해주세요.");
			project.focus();
			return false;
		}
	});
})
</script>
</html>