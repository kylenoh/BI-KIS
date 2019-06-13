<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/ym.css">
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
function moveWrite(){
	location.href = "boardWrite";
}

$(document).ready(function(){
    $(".sidenav").on('click','[class^=dropdown-div]',function(){
        $(this).find("span").toggleClass("active");
        if($(this).find("span").hasClass("active")){
            $(".dropdown-div > div").css("display","none");
            $(this).children().css("display","block");
            $(this).siblings().find("span").removeClass("active");    
        }else{    
            $(".dropdown-div > div").css("display","none");
        }
   });
});
</script>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li><a href="#">BI 기술 정보</a></li>
			  <li><a href="#">문서</a></li>
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
			<legend>검색라인</legend>
			<label for="title">제목</label><input type="text" id="title">
			<label for="writer">작성자</label><input type="text" id="writer">
			<button>Search</button>
		</fieldset>
		
		<button class="write" onclick="moveWrite()">글쓰기</button>
		
		<table border="1">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
                <c:forEach var="boards" items="${boards }">
					<tr>
						<td>${boards.NO }</td>
						<td>${boards.TITLE }</td>
						<td>${boards.ID }</td>
						<td>${boards.CREATE_DATE }</td>
						<td>${boards.COUNT }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div class="pagination">
                  <a href="#">&laquo;</a>
                  <a href="#">1</a>
                  <a href="#" class="active">2</a>
                  <a href="#">3</a>
                  <a href="#">4</a>
                  <a href="#">5</a>
                  <a href="#">6</a>
                  <a href="#">&raquo;</a>
        </div>
        <div>
        		<ul class="pagination">
					<li value=${pagination.cp-1 }><a>&laquo;</a></li>
						<c:forEach var="num" begin="${pagination.beginPageIndex lt 0 ? 1: pagination.beginPageIndex}"
												end="${pagination.endPageIndex eq 0? 1 : pagination.endPageIndex}">
							<c:choose>
								<c:when test="${pagination.cp eq num }">
									<li value="${num }" class="active"><a>${num }</a></li>
								</c:when>
								<c:otherwise>
									<li value="${num }"><a>${num }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					<li value=${pagination.cp+1 }><a>&raquo;</a></li>
				</ul>
        </div>
	</div>
</div>
	
</body>
</html>