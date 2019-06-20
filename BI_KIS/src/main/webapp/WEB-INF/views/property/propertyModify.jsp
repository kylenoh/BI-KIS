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
			  <li><a href="#">자산등록</a></li>
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
		
		<form method="post" action="register">
		  <div class="container">
		  	<div class="container-header">
			    <label for="uploadtitle"><b>품명</b></label>
			    <input type="text" name="PROP_NAME" class="boardTitle" required>
   			    
   			    <label for="uploadtitle"><b>자산번호</b></label>
			    <input type="text" name="CODE" class="boardTitle" required>
   			    
   			    <label for="uploadtitle"><b>구입일자</b></label>
			    <input type="date" name="BUY_DATE" class="boardTitle" required>
			    
			    <label for="uploadtitle"><b>사용자</b></label>
			    <input type="text" name="ID" class="boardTitle">
			    
			    <label for="uploadtitle"><b>지급일자</b></label>
			    <input type="date" name="DATE" class="boardTitle">
			</div>
			<div class="container-content">
			    <label for="content"><b>내용</b></label>
			    <textarea name="REMARK" class="boardContent"></textarea>
				
			</div>
			<div class="container-footer">
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
	location.href="property";
}
function deleteFile(obj){
	obj.parent().remove();
}
</script>
<script type="text/javascript">
var file_count=1;
$(function(){

	$("#addFile").on("click",function(e){
		e.preventDefault();
		var str = "<p><input type='file' name='file_"+(file_count++)+"'><a href='#this' class='btn' name='delete'>삭제</a></p>";
		$("#fileDiv").append(str);	
		$("a[name='delete']").on("click", function(e){
			e.preventDefault();
			deleteFile($(this));
		});
	});
	

});
</script>
</body>
</html>