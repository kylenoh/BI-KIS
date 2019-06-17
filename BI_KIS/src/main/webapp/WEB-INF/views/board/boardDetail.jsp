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
			  <li><a href="#">상세내역</a></li>
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
		<div class="main-inner">
				
			<form method="post" action="boardUpdate">
			  <div class="container">
			  	<div class="container-header">
			  		<table border="1">
			  			<thead>
			  				<tr>
			  					<th><label for="uploadtitle"><b>제목</b></label></th>
			  					<th><b>작성자</b></th>
			  					<th><b>작성일자</b></th>
			  					<th><b>조회수</b></th>
			  					<th><b>분류</b></th>
			  				</tr>
			  			</thead>
			  			<tbody>
				  			<tr>
				  				<td>${Board.TITLE }</td>
				  				<td>${Board.ID }</td>
				  				<td>${Board.CREATE_DATE }</td>
				  				<td>${Board.COUNT }</td>
				  				<td>${Board.CATE }</td>
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
			  		<input type="hidden" name="NO" value="${Board.NO }">
				</div>
				<div class="container-footer">
			    	<button type="submit" class="writebtn">수정</button>
			    	<button type="button" class="writebtn" onclick="DELETE(${Board.NO })">삭제</button>
			    	<button type="button" class="writebtn" onclick="getList()">목록</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
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