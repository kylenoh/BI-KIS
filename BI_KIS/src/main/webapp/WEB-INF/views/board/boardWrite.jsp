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
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li><a href="#">BI 기술 정보</a></li>
			  <li><a href="#">등록</a></li>
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
		
		<form method="post" action="upload" enctype="multipart/form-data">
		  <div class="container">
		  	<div class="container-header">
			    <label for="uploadtitle"><b>제목</b></label>
			    <input type="text" name="uploadtitle" class="boardTitle" required>
			    <label for="uploadtype"><b>분류</b></label>
			    <select class="boardType" name="uploadtype">
			    	<option selected value="문서">문서</option>
			    	<option value="교육">교육</option>
			    	<option value="영어">영어</option>
			    </select>
			</div>
			<div class="container-content">
			    <label for="content"><b>내용</b></label>
			    <textarea name="uploadcontent" class="boardContent"></textarea>
			    <label for="file"><b>첨부파일</b></label>
			    <div id="fileDiv">
			    	<p>
					    <input type="file" name="file_0" id="boardFile">
					    <a href="#this" class="btn" id="delete" name="delete">삭제</a>
					</p>
				</div>
				
			</div>
			<div class="container-footer">
		    	<button type="button" class="writebtn" id="addFile">파일추가</button>
		    	<button type="submit" class="writebtn">등록</button>
		    	<button type="button" class="writebtn" onclick="getList()">목록으로</button>
		    </div>
		  </div>
		</form>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
function getList(){
	location.href="board";
}
</script>
<script type="text/javascript">
var file_count=1;
$(function(){

	$("#addFile").on("click",function(e){
		e.preventDefault();
		
		var str = "<p><input type='file' name='file_"+(file_count++)+"'><a href='#this' class='btn' name='delete'>삭제</a></p>";
		$("#fileDiv").append(str);
		$("a[name='delete']").on("click",function(e){
			e.preventDefault();
			$(this).parent().remove();
		});
	});
});
</script>
</body>
</html>