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
</head>
<script type="text/javascript">
$(function() {
	$(".container-content").on('click','[id^=getFile_]',function(){
		var id = $(this).attr('id').substring(8,20);
		$.ajax({
			type:"POST",
			url:"deleteFile",
			data:{no:id},
			success:function(data){
				alert('삭제완료');
				$(this).closet(".fileSection").remove();
			}
		});
	});
});
</script>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li><a href="#">BI 기술 정보</a></li>
			  <li><a href="#">수정</a></li>
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
		
		<form method="post" action="modify" enctype="multipart/form-data">
		  <div class="container">
		  	<div class="container-header">
		 	 	<input type="hidden" name="NO" value="${Board.NO }">
			    <label for="TITLE"><b>제목</b></label>
			    <input type="text" name="TITLE" class="boardTitle" value="${Board.TITLE }" required>
			    <label for="TYPE"><b>분류</b></label>
			    <select class="boardType" name="TYPE">
			    	<option value="문서">문서</option>
			    	<option value="교육">교육</option>
			    	<option value="영어">영어</option>
			    </select>
			</div>
			<div class="container-content">
			    <label for="CONTENT"><b>내용</b></label>
			    <textarea name="CONTENT" class="boardContent">${Board.CONTENT }</textarea>
			    <label for="boardFile"><b>첨부파일</b></label>
			    <input type="file" name="file" multiple="multiple">
			    <c:forEach var="file" items="${Board.FILES }">
					<div class="fileSection">
						${file.NAME }&nbsp;&nbsp;<a id="getFile_${file.NO }">삭제</a><br>
					</div>
				</c:forEach>
			</div>
			<div class="container-footer">
		    	<button type="submit" class="writebtn">수정</button>
		    </div>
		  </div>
		</form>
		
	</div>
	
	<div class="footer">
	</div>
</div>
	
</body>
</html>