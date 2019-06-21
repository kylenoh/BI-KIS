<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../style.jsp" %>
<script type="text/javascript" src="resources/js/common.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function(){
	$("a[id='file']").on("click",function(e){
		e.preventDefault();
		downloadFile($(this));
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
			  <li><a href="#">${Board.CATE_NAME }</a></li>
			  <li><a href="#">상세내역</a></li>
			</ul>
		</div>
		<%@include file="../emp-interface.jsp" %>
	</div>
	
	<div class="main">
		<div class="main-inner">
				
			<form method="post" action="boardUpdate">
			<input type="hidden" name="cate" value="${category }">
				<input type="hidden" name="NO" value="${Board.NO }">
			  <div class="container">
			  	<div class="container-header">
			  		<table border="1">
			  			<thead>
			  				<tr>
			  					<th><label for="uploadtitle"><b>제목</b></label></th>
			  					<th><b>작성자</b></th>
			  					<th><b>작성일자</b></th>
			  					<th><b>조회수</b></th>
			  				</tr>
			  			</thead>
			  			<tbody>
				  			<tr>
				  				<td>${Board.TITLE }</td>
				  				<td>${Board.EMP_NAME }</td>
				  				<td>${Board.CREATE_DATE }</td>
				  				<td>${Board.COUNT }</td>
				  			</tr>
							<tr>
								<td colspan="5">${Board.CONTENT }</td>
							</tr>
							<tr>
								<td colspan="5">
									<c:forEach var="file" items="${Board.FILES }">
										<div class="fileSection">
											<input type="hidden" id="IDX" value="${file.NO }">
											<a href="#" id="file">${file.NAME }</a>
										</div>
									</c:forEach>
								</td>
							</tr>			  			
			  			</tbody>
			  		</table>
			  		
				</div>
				<div class="container-footer">
			    	<button type="submit" class="writebtn">수정</button>
			    	<button type="button" class="writebtn" onclick="DELETE(${Board.NO },${category })">삭제</button>
			    	<button type="button" class="writebtn" onclick="getList(${category })">목록</button>
			    </div>
			  </div>
			</form>
				<c:if test="${sessionScope.LOGIN_EMP.id!=null}"> 
						<input type="hidden" name="BOARD_NO" value="${Board.NO }">
						<input type="hidden" name="ID" value="${sessionScope.LOGIN_EMP.name}">
						<textarea style="width:100%; height:200px; resize:none;" name="CONTENT" id="content"></textarea>
						<button onclick="replyWrite(${Board.NO },'${sessionScope.LOGIN_EMP.id}')">등록</button>
				</c:if>
				<c:forEach var="reply" items="${Board.REPLYS }">
					<div id="replyList">
							<p>
								<span name="reply_0">${reply.CONTENT }${reply.ID }&nbsp;&nbsp;${reply.CREATE_DATE }</span>
								<button onclick="deleteReply(${reply.NO })">삭제</button>
							</p>
					</div>
				</c:forEach>
		</div>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
$(function(){
	var reply_count=1;
	
	
});

function replyWrite(boardNo,id){
	var content = $("#content").val();
	var name = id;
	var no = boardNo;
	
	alert(no);
	alert(content);
	alert(name);
	
	
	$.ajax({
		type:"GET",
		url: "replyWrite",
		data:{no:no,name:name,content:content},
		success: function(result){
			var row = "<p><span name='reply_"+(reply_count++)+"'>"+content+"</span>"+name+"&nbsp;&nbsp;"+"<button onclick='deleteReply()'>삭제</button></p>";
			$("#replyList").append(row);
		}
	});
}
function deleteReply(value){
	$.ajax({
		type:"GET",
		url: "deleteReply",
		data:{no:value},
		success: function(result){
			$(this).parent().remove();
		}
	});
}
function DELETE(no,cate){
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href = "delete?no="+no+"&cate="+cate;
	}
}
function getList(cate){
	location.href="board?CATE="+cate;
}
function downloadFile(obj){
	var idx = obj.parent().find("#IDX").val();
	location.href = "download?idx="+idx;
}
</script>
</body>
</html>