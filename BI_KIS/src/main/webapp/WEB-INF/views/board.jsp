<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

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
                     <div id="myDropdown" class="dropdown-content">
                        <a href="#home">Home</a>
                        <a href="#about">About</a>
                        <a href="#contact">Contact</a>
                      </div>
				</li>
				<li><span><i class="fas fa-sign-in-alt">로그아웃</i></span></li>
			</ul>
             
		</div>
	</div>
	
	<div class="sidenav">
	
	</div>
	
	<div class="main">
		<fieldset>
			<legend>검색라인</legend>
			<label for="title">제목</label><input type="text" id="title">
			<label for="writer">작성자</label><input type="text" id="writer">
			<button>Search</button>
		</fieldset>
		
		<button class="write">글쓰기</button>
		
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
				<tr>
					<td>3</td>
					<td>문서게시글<span><i class="fas fa-file-alt"></i></span></td>
					<td>노수혁</td>
					<td>2019-06-11</td>
					<td>3</td>
				</tr>
                <tr>
					<td>3</td>
					<td>문서게시글</td>
					<td>노수혁</td>
					<td>2019-06-11</td>
					<td>3</td>
				</tr>
                <tr>
					<td>3</td>
					<td>문서게시글</td>
					<td>노수혁</td>
					<td>2019-06-11</td>
					<td>3</td>
				</tr>
                <tr>
					<td>3</td>
					<td>문서게시글</td>
					<td>노수혁</td>
					<td>2019-06-11</td>
					<td>3</td>
				</tr>
                <tr>
					<td>3</td>
					<td>문서게시글</td>
					<td>노수혁</td>
					<td>2019-06-11</td>
					<td>3</td>
				</tr>
			</tbody>
			<tfoot>
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
			</tfoot>
		</table>
	</div>
	
	<div class="footer">
	
	</div>
</div>
	
</body>
</html>