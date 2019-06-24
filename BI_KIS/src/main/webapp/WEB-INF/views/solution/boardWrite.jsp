<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../style.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li><a href="#">게시글 등록</a></li>
			</ul>
		</div>
		<%@include file="../emp-interface.jsp" %>
	</div>
	
	<div class="main">
		<form method="post" action="upload" enctype="multipart/form-data">
		  <div class="container">
		  	<div class="container-header">
			    <label for="uploadtitle"><b>제목</b></label>
			    <input type="text" name="TITLE" class="boardTitle" required>
			</div>
			<div class="container-content">
			    <label for="content"><b>내용</b></label>
			    <textarea name="CONTENT" class="boardContent"></textarea>
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