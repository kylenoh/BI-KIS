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
function propertyWrite(){
	location.href = "propertyWrite";
}
function getBoardDetail(no,cate){
	location.href = "boardDetail?no="+no+"&cate="+cate;
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
			  <li>
			  	<a href="#">
			  		자산관리
			  	</a>
			  </li>
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
		<form action="board">
			<fieldset>
				<legend>검색라인</legend>
				<label for="title">품명</label><input type="text" id="title" name="title">
				<label for="writer">자산번호</label><input type="text" id="writer" name="writer">
				<label for="writer">사용자</label><input type="text" id="writer" name="writer">
				<select>
					<option>ALL</option>
					<option>사용</option>
					<option>미 사용</option>
				</select>
				<button type="submit">Search</button>
			</fieldset>
		</form>
		<button class="write" onclick="propertyWrite()">자산 등록</button>
		
		<table border="1" style="border-collapse: collapse;">
			<colgroup>
				<col width="20%">
				<col width="10">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="20%">
				<col width="5%">
				<col width="5%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">품명</th>
					<th scope="col">자산번호</th>
					<th scope="col">구입일자</th>
					<th scope="col">사용자</th>
					<th scope="col">직급</th>
					<th scope="col">지급일</th>
					<th scope="col">비고</th>
					<th scope="col">수정</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><button onclick="propertyWrite()">수정</button></td>
					<td><button>삭제</button></td>
				</tr>
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