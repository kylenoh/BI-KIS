<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../style.jsp" %>
<title>Insert title here</title>
<script type="text/javascript">
function moveWrite(){
	location.href = "boardWrite";
}
function getBoardDetail(no){
	location.href = "boardDetail?no="+no;
}
</script>
</head>
<body>
<div class="row">
	<div class="leftcolumn">
		<%@ include file="../sidenav.jsp" %>
	</div>
	<div class="rightcolumn">
		<div class="wrap">
			<div class="header">
				<div class="header-left">
					<ul class="breadcrumb">
					  <li><a href="#">게시판</a></li>
					</ul>
				</div>
				<%@include file="../emp-interface.jsp" %>
			</div>
			
			<div class="main">
				<div class="container">
					<form action="board">
						<fieldset>
							<legend>검색라인</legend>
							<label for="title">제목</label><input type="text" name="title">
							<label for="writer">작성자</label><input type="text"name="writer">
							<button type="submit">Search</button>
						</fieldset>
					</form>
					<button class="write" onclick="moveWrite()">글쓰기</button>
					
					<table border="1">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="15%">
							<col width="20%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">글번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${fn:length(boards)>0 }">
					                <c:forEach var="boards" items="${boards }">
										<tr onclick="getBoardDetail(${boards.NO })">
											<td>${boards.NO }</td>
											<td>${boards.TITLE }</td>
											<td>${boards.EMP_NAME }</td>
											<td>${boards.CREATE_DATE }</td>
											<td>${boards.COUNT }</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5">조회된 결과가 없습니다.</td>
									</tr>					
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
			
				<div class="footer">
					<div align="center">
					<c:if test="${!empty boards }">
						<c:if test="${pagination.cb gt 1 }">
							<a href="board?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
						</c:if>
						<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
							<a href="board?cp=${num}">${num }</a>
						</c:forEach>
						<c:if test="${pagination.cb lt pagination.totalBlocks }">
							<a href="board?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
						</c:if>
					</c:if>
					</div>
				</div><!-- footer -->
		</div>
	</div><!-- right column -->
</div><!-- row -->
</body>
</html>