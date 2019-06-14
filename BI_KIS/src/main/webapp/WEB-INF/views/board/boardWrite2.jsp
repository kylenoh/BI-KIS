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
<script type="text/javascript" src="resources/js/jQueryForm.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function () {

	function upload(){
        $("#frm").ajaxForm({
            url : "/upload.do",
            enctype : "multipart/form-data",
            dataType : "json",
            error : function(){
                alert("에러") ;
            },
            success : function(result){
                alert("성공") ;
            }
        });
 
        $("#frm").submit() ;
    }

});
</script>
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
			    <input type="file" name="file" multiple="multiple" id="boardFile">
			</div>
			<div class="container-footer">
		    	<button type="submit" class="writebtn">등록</button>
		    </div>
		  </div>
		</form>
	
	<form name="frm" id="frm" method="post" enctype="multipart/form-data">
    <input type="file" name="upfile" id="upfile">
</form>
 
 
<a href="javascript:upload();">등록</a>


		
		
	</div>
	
	<div class="footer">
	</div>
</div>
	
</body>
</html>