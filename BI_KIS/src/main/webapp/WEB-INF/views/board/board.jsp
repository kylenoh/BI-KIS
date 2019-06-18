<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/ym.css">
<link rel="stylesheet" href="resources/css/sh.css">
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
function getBoardDetail(NO){
	location.href = "boardDetail?NO="+NO;
}
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
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="15%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(boards)>0 }">
		                <c:forEach var="boards" items="${boards }">
							<tr onclick="getBoardDetail(${boards.NO })">
								<td>${boards.NO }</td>
								<td>${boards.TITLE }</td>
								<td>${boards.ID }</td>
								<td>${boards.CREATE_DATE } </td>
								<td>${boards.COUNT }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">조회된 결과가 없습니다.</td>
						</tr>					
					</c:otherwise>
				</c:choose>

					
					
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div align="center">
		<c:if test="${!empty boards }">
			<c:if test="${pagination.cb gt 1 }">
				<a href="board?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
			</c:if>
			<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
				<a href="board?cp=${num}">${num }</a>
			</c:forEach>
			<c:if test="${pagination.cb lt pagination.totalBlocks }">
				<a href="board?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
			</c:if>
		</c:if>
	</div>
	</div>
</div>
	
</body>
</html>