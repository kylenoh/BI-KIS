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
		<%@ include file="../emp-interface.jsp" %>
	</div>
	
	<div class="main">
		<div class="container">
		    <form method="post" action="addEmp" id="searchForm" onsubmit="registerCheck">
	        	<div>
	            	<label for="empId">아이디</label><input type="text" id="empId" name="empId" class="inputTitle" required="required">
	            	<div class="input-group-append">
					    <span class="input-group-text" id="joinIdOk">ID확인</span>
  					</div>
	            </div>
	        	<div>
	            	<label for="password">비밀번호</label><input type="text" id="password" name="password" class="inputTitle" required="required">
	            </div>
	        	<div>
	            	<label for="name">사원 명</label><input type="text" id="name" name="name" class="inputTitle" required="required">
	            </div>
	            <div>
	            	<label for="rank">직책</label><input type="text" id="rank" name="rank" class="inputTitle" required="required">
	            </div>
	            <div>
	            	<label for="tel">연락처</label><input type="text" id="tel" name="tel" class="inputTitle">
	            </div>
	            <div>
	            	<label for="addr">주소</label><input type="text" id="addr" name="addr" class="inputTitle">
	            </div>
	            <div>
	            	<label for="email">이메일</label><input type="text" id="email" name="email" class="inputTitle">
	            </div>
	            <div>
	                <button type="submit" class="btn success">등록</button>
	            </div>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	var check = null;
	
	$("#empId").keyup(function() {
		var id = $(this).val();
		$.ajax({
			url : "IdCheck",
			dataType:'json',
			data : {
				id : id
			}, 
			success : function(data) {
				check = data.emps[0].id;
				alert(JSON.stringify(check));
				if (id.length == 0) {
					$("#joinIdOk").text("ID입력");
				} else if (check.length > 1) {
					$("#joinIdOk").text("ID중복");
				} else {
					$("#joinIdOk").text("OK");
				}
			}
		});
	});
})
function registerCheck(){
	var id = $("#empId").val();
	var passWord = $("#password").val();
	var name = $("#name").val();
	var rank = $("#rank").val();

	if (isEmpty(id) || containsHS(id)) {
		alert("아이디를 입력해주세요");
		id.value = "";
		id.focus();
		return false;
	} else if (isEmpty(passWord)
			|| notContains(passWord, "1234567890")
			|| notContains(passWord, "qwertyuiopasdfghjklzxcvbnm")) {
		alert("비밀번호를 확인해주세요");
		passWord.value = "";
		passWord.focus();
		return false;
	} else if (isEmpty(name)) {
		alert("이름을 입력해주세요");
		name.value = "";
		name.focus();
		return false;
	} else if (isEmpty(rank)) {
		alert("직책을 설정해주세요");
		rank.value = "";
		rank.focus();
		return false;
	}

	return true;
}

</script>
</html>