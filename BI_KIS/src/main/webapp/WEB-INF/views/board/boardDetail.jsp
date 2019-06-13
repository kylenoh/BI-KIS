<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/ym.css">
<link rel="stylesheet" href="resources/css/sh.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li><a href="#">BI 기술 정보</a></li>
			  <li><a href="#">상세내역</a></li>
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
		<div class="main-inner">
				
			<form method="post" action="boardUpdate">
			  <div class="container">
			  	<div class="container-header">
			  		<input type="hidden" name="NO" value="${Board.NO }">
				    <label for="uploadtitle"><b>제목</b></label>
				    <input type="text" name="uploadtitle" class="boardTitle" value="${Board.TITLE }" required>
				    <b>작성자</b><p>${Board.ID }</p>
				    <b>작성일자</b><p>${Board.CREATE_DATE }</p>
				    <b>조회수</b><p>${Board.COUNT }</p>
				    <label for="uploadtype"><b>분류</b></label>
				    <select class="boardType" name="uploadtype">
				    	<option selected value="문서">문서</option>
				    	<option value="교육">교육</option>
				    	<option value="영어">영어</option>
				    </select>
				</div>
				<div class="container-content">
				    <label for="content"><b>내용</b></label>
				    <textarea name="uploadcontent" class="boardContent">${Board.CONTENT }</textarea>
				    <label for="boardFile"><b>첨부파일</b></label>
				    <c:forEach var="file" items="${Board.FILES }">
						${file.NAME }
					</c:forEach>
				</div>
				<div class="container-footer">
			    	<button type="submit" class="writebtn">수정</button>
			    	<button type="button" class="writebtn" onclick="DELETE(${Board.NO })">삭제</button>
			    	<button type="button" class="writebtn">목록</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
function DELETE(no){
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href = "delete?no="+no;
	}
}
</script>
</body>
</html>