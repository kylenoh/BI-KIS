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
		
		<form action="regProperty" method="POST">
		  <div class="container">
		  	<div class="container-header">
			    <label for="PROP_NAME"><b>품명</b></label>
			    <input type="text" name="PROP_NAME" class="inputTitle" required>
   			    
   			    <label for="CODE"><b>자산번호</b></label>
			    <input type="text" name="CODE" class="inputTitle" required>
   			    
   			    <label for="BUY_DATE"><b>구입일자</b></label>
			    <input type="date" name="BUY_DATE" class="inputTitle" value="${y}-${m}-${d}">
			    
			    <label for="ID"><b>사용자</b></label>
			    			<select id="emp" name="ID" class="inputTitle">
		                		<option></option>
		                		<c:forEach var="emp" items="${empList }">
		                			<option id="emp-id-${emp.id }" value="${emp.id }">${emp.name }</option>
		                		</c:forEach>
		                	</select>
			    
			    <label for="PROP_DATE"><b>지급일자</b></label>
			    <input type="date" name="PROP_DATE" class="inputTitle">
			</div>
			<div class="container-content">
			    <label for="REMARK"><b>비고</b></label>
			    <textarea name="REMARK" class="textContent"></textarea>
				
			</div>
			<div class="container-footer">
		    	<button type="submit" class="btn success">등록</button>
		    	<button type="button" class="btn warning" onclick="getList()">목록으로</button>
		    </div>
		  </div>
		</form>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
function getList(){
	if (confirm("목록으로 돌아가시겠습니까?")) {
		location.href="property";
	}
}
</script>
</body>
</html>