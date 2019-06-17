<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/ym.css?var=3">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
			  <li>고객사 관리</li>
			  <li>고객사</li>
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
	    <fieldset>
        	<legend>고객사</legend>
        	<div id="companyDetail">
        		<div>
	                <label for="title">고객사 명</label><input type="text" id="name" name="name" value="${company.name }"disabled="disabled">
	            </div>
	            <div>
	                <label for="owner">대표자</label><input type="text" id="owner" name="owner" value="${company.owner}"disabled="disabled">
	            </div>
	            <div>
	                <label for="tel">연락처</label><input type="text" id="tel" name="tel" value="${company.tel }"disabled="disabled">
	            </div>
	            <div>
	                <label for="addr">주소</label><input type="text" id="addr" name="addr" value="${company.addr }" disabled="disabled">
	            </div>
	            <div>
	             	<label for="remark">비고</label>
	               	<textarea id="remark" name="remark" disabled="disabled">${company.remark }</textarea>
	            </div>
        	</div>
            <div id="customerDetail">
	        	<div>
	            	<label for="name">담당자 명</label><input type="text" id="name" name="name" value="${company.customer.name }"disabled="disabled">
	            </div>
	            <div>
	                <label for="rank">직급</label><input type="text" id="rank" name="rank" value="${company.customer.rank }" disabled="disabled">
	            </div>
	            <div>
	                <label for="dept">부서명</label><input type="text" id="dept" name="dept" value="${company.customer.dept }" disabled="disabled">
	            </div>
	            <div>
	                <label for="tel1">연락처1</label><input type="text" id="tel1" name="tel1" value="${company.customer.tel1 }" disabled="disabled">
	                <label for="tel2">연락처2</label><input type="text" id="tel2" name="tel2" value="${company.customer.tel2 }" disabled="disabled">
	            </div>
	            <div>
	                <label for="email">이메일</label><input type="text" id="email" name="email" value="${company.customer.email }" disabled="disabled">
	            </div>
	            <div>
	              	<label for="remark">비고</label>
	               	<textarea id="remark" name="remark" disabled="disabled">${company.customer.remark }</textarea>
	            </div>
	            <div style="float:right;">
	            	<button type="button" class="btn-modify-company" value="${company.customer.no }">수정</button>
	            	<button type="button" class="btn-del-customer" value="${company.customer.no }">삭제</button>
	            	<button type="button" onclick="location.href='project'">목록</button>
	            </div>
            </div>
        </fieldset>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('.btn-del-customer').click(function(){
			var customerNo = $(this).val();
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href="customerDelete?customerNo=" + customerNo;
			}
		});
		$('.btn-modify-company').click(function(){
			var customerNo = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="companyModify?customerNo=" + customerNo;
			}
		});
	});
</script>	
</html>