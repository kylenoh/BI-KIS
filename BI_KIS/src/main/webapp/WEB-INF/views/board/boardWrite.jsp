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
		<%@include file="../emp-interface.jsp" %>
	<div class="main">
		<form method="post" action="upload" enctype="multipart/form-data">
		  <div class="container">
		  	<div class="container-header">
			    <label for="uploadtitle"><b>제목</b></label>
			    <input type="text" name="TITLE" class="inputTitle" required>
			</div>
			<div class="container-content">
			    <label for="content"><b>내용</b></label>
			    <textarea name="CONTENT" class="summernote"></textarea>
			    
			    <button type="button" class="btn success" id="addFile">파일추가</button>
		    	<button type="submit" class="btn success">등록</button>
		    	<button type="button" class="btn warning" onclick="getList()">목록으로</button>
			    
			</div>

			    <label for="file"><b>첨부파일</b></label>
			    <div id="fileDiv">
			    	<p>
					    <input type="file" name="file_0" id="boardFile">
					    <a href="#" id="delete" name="delete">삭제</a>
					</p>
				</div>
		  </div>
		</form>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
function getList(){
	if (confirm("목록으로돌아가시겠습니까?")) {
		location.href="board";
	}
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
		var str = "<p><input type='file' name='file_"+(file_count++)+"'><a href='#' name='delete'>삭제</a></p>";
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