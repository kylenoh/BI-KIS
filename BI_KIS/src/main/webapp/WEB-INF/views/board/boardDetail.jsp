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
		<%@include file="../emp-interface.jsp" %>
	<div class="main">
		<div class="main-inner">
				
			<form method="post" action="boardUpdate">
				<input type="hidden" name="NO" value="${Board.NO }" id="boardNo">
			  <div class="container">
			  	<div class="container-header">
			  		<table border="1">
			  			<colgroup>
							<col width="10%">
							<col width="*">
							<col width="15%">
							<col width="15%">
						</colgroup>
			  			<thead>
			  				<tr>
				  				<th scope="col">글번호</th>
			  					<th scope="col"><b>제목</b></th>
			  					<th scope="col"><b>작성자</b></th>
			  					<th scope="col"><b>작성일자</b></th>
			  				</tr>
			  			</thead>
			  			<tbody>
				  			<tr>
				  				<td>${Board.NO }</td>
				  				<td>${Board.TITLE }</td>
				  				<td>${Board.EMP_NAME }</td>
				  				<td><fmt:formatDate value="${Board.CREATE_DATE }" pattern="yyyy-MM-dd HH:mm"/></td>
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
			    	<button type="submit" class="btn success">수정</button>
			    	<button type="button" class="btn danger" onclick="DELETE(${Board.NO })">삭제</button>
			    	<button type="button" class="btn warning" onclick="getList()">목록</button>
			    </div>
			  </div>
			</form>
			<!-- 댓글출력라인 -->
					<div id="replyList">
						<c:forEach var="reply" items="${Board.REPLYS }">
							<p id="p_${reply.NO }">
								<span name="reply_0">&nbsp;&nbsp;${reply.CONTENT }&nbsp;&nbsp;${reply.EMP_NAME}&nbsp;&nbsp;${reply.CREATE_DATE }</span>
								<a href="javascript:replyDelete(${reply.NO },${Board.NO })">삭제</a>
							</p>
						</c:forEach>
					</div>
			
				<!-- 댓글입력라인 -->
				<c:if test="${sessionScope.LOGIN_EMP.id!=null}"> 
					<div class="replyBox clearfix">
						<form action="replyWrite" method="POST">
							<input type="hidden" name="no" value="${Board.NO }">
							<textarea class="replyContent" name="replyContent"></textarea>
							<button id="replyWrite" type="submit" class="btn success">댓글등록</button>
						</form>
					</div>
				</c:if>
				
		</div>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">

function replyDelete(replyNo,no){
	location.href="deleteReply?replyNo="+replyNo+"&no="+no;
}

function DELETE(no){
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href = "delete?no="+no;
	}
}
function getList(){
	if (confirm("목록으로돌아가시겠습니까?")) {
		location.href="board";
	}
}
function downloadFile(obj){
	var idx = obj.parent().find("#IDX").val();
	location.href = "download?idx="+idx;
}
</script>
</body>
</html>