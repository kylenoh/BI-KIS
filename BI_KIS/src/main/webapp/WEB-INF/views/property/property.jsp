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
function propertyWrite(){
	location.href = "propertyWrite";
}
function propertyModify(no){
	location.href = "propertyModify?no="+no;
}
function propertyDelete(no,flag){
	location.href = "propertyDelete?no="+no+"&flag="+flag;
}
</script>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
		<%@include file="../emp-interface.jsp" %>
	<div class="main">
		<div class="container">
		<form action="property">
			<fieldset>
				<legend>검색라인</legend>
					<div class="row">
						<div class="grid-container">
							<label for="title" class="labelItem">품명</label><input type="text"name="PROP_NAME" class="inputItem inputSearch2">
							<label for="writer"class="labelItem">자산번호</label><input type="text"name="PROP_NO" class="inputItem inputSearch2">
						</div>
					</div>
					<div class="row">
						<div class="grid-container">
							<label for="writer" class="labelItem">사용자</label><input type="text"name="EMP_ID" class="inputItem inputSearch2">
							<label for="writer" class="labelItem">사용구분</label>
							<select name="PROP_FLAG" class="inputItem inputSearch2">
								<option value="ALL">ALL</option>
								<option value="N">사용</option>
								<option value="Y">미 사용</option>
							</select>
							<button type="submit" class="findBtn info">검색</button>
						</div>
					</div>
			</fieldset>
		</form>
		<button class="btn success" onclick="propertyWrite()">자산 등록</button>
		<small> 게시글 수 : ${pagination.totalRows}</small>
		
		<table border="1" style="border-collapse: collapse;">
			<colgroup>
				<col width="20%">
				<col width="10">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="20%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">품명</th>
					<th scope="col">자산번호</th>
					<th scope="col">구입일자</th>
					<th scope="col">사용자</th>
					<th scope="col">지급일</th>
					<th scope="col">비고</th>
					<th scope="col">사용여부</th>
					<th scope="col">수정</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(props)>0 }">
						<c:forEach var="props" items="${props }">
							<tr>
								<td>${props.PROP_NAME }</td>
								<td>${props.CODE }</td>
								<td>${props.BUY_DATE }</td>
								<td>${props.EMP_NAME } </td>
								<td>${props.PROP_DATE }</td>
								<td>${props.REMARK }</td>
								<td>
									<c:choose>
										<c:when test="${props.EMP_NAME != null }">
											사용
										</c:when>
										<c:otherwise>
											미사용
										</c:otherwise>
									</c:choose>
								</td>
								<td><button onclick="propertyModify(${props.NO })">수정</button></td>
							</tr>
						</c:forEach>
					</c:when>
						<c:otherwise>
							<tr>
								<td colspan="8">조회된 결과가 없습니다.</td>
							</tr>					
						</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div align="center">
			<c:if test="${!empty props }">
				<c:if test="${pagination.cb gt 1 }">
					<a href="property?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
				</c:if>
				<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
					<a href="property?cp=${num}">${num }</a>
				</c:forEach>
				<c:if test="${pagination.cb lt pagination.totalBlocks }">
					<a href="property?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
				</c:if>
			</c:if>
		</div>
	</div>
	</div>
</div>
	
</body>
</html>