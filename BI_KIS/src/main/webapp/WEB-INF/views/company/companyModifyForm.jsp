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
		<form method="post" action="companyModify" id="companyForm">
			<input type="hidden" name="companyNo" value="${customer.company.no}">
			<input type="hidden" name="customerNo" value="${customer.no}">
		    <fieldset>
	        	<legend>고객사</legend>
	        	<div id="companyDetail">
	        		<div>
		                <label for="title">고객사 명</label><input type="text" id="name" name="name" value="${customer.company.name }">
		            </div>
		            <div>
		                <label for="owner">대표자</label><input type="text" id="owner" name="owner" value="${customer.company.owner}">
		            </div>
		            <div>
		                <label for="tel">연락처</label><input type="text" id="tel" name="tel" value="${customer.company.tel }">
		            </div>
		            <div>
		                <label for="addr">주소</label><input type="text" id="addr" name="addr" value=${customer.company.addr }>
		            </div>
		            <div>
		             	<label for="remark">비고</label>
		               	<textarea id="remark" name="remark">${customer.company.remark}</textarea>
		            </div>
	        	</div>
	            <div id="customerDetail">
		        	<div>
		            	<label for="name">담당자 명</label><input type="text" id="name" name="name" value="${customer.name }">
		            </div>
		            <div>
		                <label for="rank">직급</label><input type="text" id="rank" name="rank" value="${customer.rank }">
		            </div>
		            <div>
		                <label for="dept">부서명</label><input type="text" id="dept" name="dept" value="${customer.dept }">
		            </div>
		            <div>
		                <label for="tel1">연락처1</label><input type="text" id="tel1" name="tel1" value="${customer.tel1 }">
		                <label for="tel2">연락처2</label><input type="text" id="tel2" name="tel2" value="${customer.tel2 }">
		            </div>
		            <div>
		                <label for="email">이메일</label><input type="text" id="email" name="email" value="${customer.email }">
		            </div>
		            <div>
		              	<label for="remark">비고</label>
		               	<textarea id="remark" name="remark">${customer.remark }</textarea>
		            </div>
		            <div style="float:right;">
		            	<button type="submit">수정</button>
		            	<button type="button" onclick="location.href='companyDetail?companyNo=${customer.company.no}&customerNo=${customer.no}'">뒤로가기</button>
		            </div>
	            </div>
	        </fieldset>
        </form>
	</div>
</div>
</body>
</html>