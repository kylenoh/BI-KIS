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
		
		<form method="POST" action="PropertyModify">
		  <div class="container">
		  	<div class="container-header">
		  		<input type="hidden" name="NO" value="${prop.NO }">
		  		<input type="hidden" id="idcheck" value="${prop.ID }">
			    <label><b>품명</b></label>
			    <input type="text" name="PROP_NAME" class="inputTitle" value="${prop.PROP_NAME }" required>
   			    
   			    <label><b>자산번호</b></label>
			    <input type="text" name="CODE" class="inputTitle" value="${prop.CODE }" required>
   			    
   			    <label><b>구입일자</b></label>
			    <input type="date" name="BUY_DATE" class="inputTitle" value="${prop.BUY_DATE }" required>
			    
			    <label><b>사용자</b></label>
			    <select id="emp" name="ID" class="inputTitle">
		                		<option></option>
		                		<c:forEach var="emp" items="${empList }">
		                				<option id="emp-id-${emp.id }" value="${emp.id }">${emp.name }</option>
		                		</c:forEach>
		                	</select>
			    
			    <label for="uploadtitle"><b>지급일자</b></label>
			    <input type="date" name="PROP_DATE" value="${prop.PROP_DATE }" class="inputTitle">
			</div>
			<div class="container-content">
			    <label for="content"><b>내용</b></label>
			    <textarea name="REMARK" class="summernote">${prop.REMARK }</textarea>
				
			</div>
			<div class="container-footer">
		    	<button type="submit" class="btn success">수정</button>
		    	<button type="button" class="btn danger" onclick="propertyDelete(${prop.NO })">삭제</button>
		    	<button type="button" class="btn warning" onclick="getList()">목록으로</button>
		    </div>
		  </div>
		</form>
	</div>
	
	<div class="footer">
	</div>
</div>
<script type="text/javascript">
$(function(){
	var id = $("#idcheck").val();
		 $("select[name='ID'] option[value='"+id+"']").attr("selected", "selected");
});
function getList(){
	if (confirm("목록으로 돌아가시겠습니까?")) {
		location.href="property";
	}
}
function propertyDelete(no){
	if (confirm("삭제 하시겠습니까?")) {
		location.href="propertyDelete?no="+no;
	}
}
</script>
</body>
</html>