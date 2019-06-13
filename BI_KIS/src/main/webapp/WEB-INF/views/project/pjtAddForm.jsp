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
			  <li>프로젝트 관리</li>
			  <li>프로젝트 등록</li>
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
	    <form method="post" action="pjtadd" id="pjtForm">
            <fieldset>
                <legend>프로젝트 등록</legend>
                <div id="addPjtForm">
	                <div>
	                    <label for="title">프로젝트 명</label><input type="text" id="title" name="title">
	                </div>
	                <div>
	                    <label for="company">고객사 명</label>
	                    <select id="company" name="companyNo">
	                        <option value="all"></option>
	                        <c:forEach var="comList" items="${companyList }">
	                        	<option value="${comList.no }">${comList.name }</option>
	                        </c:forEach>
                    	</select>    
	                </div>
	                <div id="PjtDate">
	                    <label for="startDate">시작일</label><input type="date" id="startDate" name="startDate">    
	                    <label for="endDate">종료 예정일</label><input type="date" id="endDate" name="endDate">
	                </div>
	                <div>
	                    <label for="content">내용</label>
	                    <textarea id="content" name="content"></textarea>
	                </div>
	                <div>
	                	<label for="remark">비고</label>
	                	<textarea id="remark" name="remark"></textarea>
	                </div>
	                <button type="submit">등록</button>
                </div>
            </fieldset>
		</form>
	</div>
</div>
	
</body>
</html>