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
		<form method="post" action="modify" enctype="multipart/form-data">
		  <div class="container">
		  	<div class="container-header">
		 	 	<input type="hidden" name="NO" value="${Board.NO }">
			    <label><b>제목</b></label>
			    <input type="text" name="TITLE" class="boardTitle" value="${Board.TITLE }" required>
			</div>
			<div class="container-content">
			    <label><b>내용</b></label>
			    <textarea name="CONTENT" class="boardContent">${Board.CONTENT }</textarea>
			    <label><b>첨부파일</b></label>
			    <div id="fileDiv">
				    <c:forEach varStatus="var" var="file" items="${Board.FILES }">
				    	<p>
							<input type="text" id="IDX" name="IDX_${var.index }" value="${file.NO }"><!-- 숨김 상자 -->
							<a href="#this" id="name_${var.index }" name="name_${var.index }">${file.NAME }</a><!-- 파일 명 -->
							<input type="file" id="file_${var.index }" name="file_${var.index }"><!-- 파일 상자 -->
							<a href="#this" class="btn" id="delete_${var.index }" name="delete_${var.index }">삭제</a><!-- 삭제 -->
						</p>
					</c:forEach>
				</div>
			</div>
			<div class="container-footer">
				<button type="button" class="writebtn" id="addFile">파일추가</button>
		    	<button type="button" class="writebtn" onclick="getList()">목록으로</button>
		    	<button type="submit" class="writebtn">수정</button>
		    </div>
		  </div>
		</form>
		
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
var file_count='${fn:length(Board.FILES)+1}';

$(function(){
	$("#addFile").on("click", function(e){ //파일 추가 버튼
		e.preventDefault();
		addFile();
	});
	
	$("a[name^='delete']").on("click", function(e){ //삭제 버튼
		e.preventDefault();
		deleteFile($(this));
	});
});

function getList(){
	location.href="board";
}
function addFile(){
	var str = "<p><input type='file' id='file_"+(file_count)+"' name='file_"+(file_count)+"'>"+
			"<a href='#this' class='btn' id='delete_"+(file_count)+"' name='delete_"+(file_count)+"'>삭제</a>" +
		"</p>";
	$("#fileDiv").append(str);
	$("#delete_"+(file_count++)).on("click", function(e){ //삭제 버튼
		e.preventDefault();
		deleteFile($(this));
	});
}

function deleteFile(obj){
	obj.parent().remove();
}

</script>
</body>
</html>