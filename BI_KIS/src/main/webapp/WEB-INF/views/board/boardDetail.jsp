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
			  <li><a href="#">상세내역</a></li>
			</ul>
		</div>
		<%@include file="../emp-interface.jsp" %>
	</div>
	
	<div class="main">
		<div class="main-inner">
				
			<form method="post" action="boardUpdate">
				<input type="hidden" name="NO" value="${Board.NO }" id="boardNo">
			  <div class="container">
			  	<div class="container-header">
			  		<table border="1">
			  			<thead>
			  				<tr>
			  					<th><label><b>제목</b></label></th>
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
			    	<button type="button" class="writebtn" onclick="DELETE(${Board.NO })">삭제</button>
			    	<button type="button" class="writebtn" onclick="getList()">목록</button>
			    </div>
			  </div>
			</form>
				<!-- 댓글입력라인 -->
				<c:if test="${sessionScope.LOGIN_EMP.id!=null}"> 
						<textarea style="width:100%; height:100px; resize: none;" id="replyContent"></textarea>
						<button id="replyWrite" class="writebtn">댓글등록</button>
				</c:if>
				<!-- 댓글출력라인 -->
					<div id="replyList">
						<c:forEach var="reply" items="${Board.REPLYS }">
							<p id="p_${reply.NO }">
								<span name="reply_0">&nbsp;&nbsp;${reply.CONTENT }&nbsp;&nbsp;${reply.CREATE_DATE }</span>
								<a href="javascript:replyDelete(${reply.NO })">삭제</a>
							</p>
						</c:forEach>
					</div>
		</div>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
$(function(){
	var reply_count=1;
	var boardNo = $("#boardNo").val();
	
	
	$("#replyWrite").on("click",function(e){
		e.preventDefault();
		var replyContent = $("#replyContent").val();
		$.ajax({
			type:"POST",
			url:"replyWrite",
			data:{no:boardNo,content:replyContent},
			success:function(result){
				var row = "<p><span name='reply_"+(reply_count++)+"'>"+replyContent+"</span>"+"&nbsp;&nbsp;"+"<a href='javascript:replyDelete("+result+");'>삭제</a></p>";
				$("#replyList").append(row);
			}
		});
	});
	
});
function replyDelete(replyNo){
	$.ajax({
		type:"POST",
		url: "deleteReply",
		data:{no:replyNo},
		success: function(result){
			$("#p_"+result).remove();
		}
	});
}


function DELETE(no){
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href = "delete?no="+no;
	}
}
function getList(){
	location.href="board";
}
function downloadFile(obj){
	var idx = obj.parent().find("#IDX").val();
	location.href = "download?idx="+idx;
}
</script>
</body>
</html>