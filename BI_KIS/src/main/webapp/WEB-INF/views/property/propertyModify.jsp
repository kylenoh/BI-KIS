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
			  <li><a href="#">자산등록</a></li>
			</ul>
		</div>
		<%@include file="../emp-interface.jsp" %>
	</div>
	
	<div class="main">
		
		<form method="POST" action="Modify">
		  <div class="container">
		  	<div class="container-header">
		  		<input type="hidden" name="NO" value="${prop.NO }">
			    <label for="uploadtitle"><b>품명</b></label>
			    <input type="text" name="PROP_NAME" class="boardTitle" value="${prop.PROP_NAME }" required>
   			    
   			    <label for="uploadtitle"><b>자산번호</b></label>
			    <input type="text" name="CODE" class="boardTitle" value="${prop.CODE }" required>
   			    
   			    <label for="uploadtitle"><b>구입일자</b></label>
			    <input type="date" name="BUY_DATE" class="boardTitle" value="${prop.BUY_DATE }" required>
			    
			    <label for="uploadtitle"><b>사용자</b></label>
			    <input type="text" name="ID" value="${prop.ID }" class="boardTitle">
			    
			    <label for="uploadtitle"><b>지급일자</b></label>
			    <input type="date" name="PROP_DATE" value="${prop.PROP_DATE }" class="boardTitle">
			</div>
			<div class="container-content">
			    <label for="content"><b>내용</b></label>
			    <textarea name="REMARK" class="boardContent">${prop.REMARK }</textarea>
				
			</div>
			<div class="container-footer">
		    	<button type="submit" class="writebtn">수정</button>
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