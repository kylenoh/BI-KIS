<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/ym.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<title>테스트 페이지</title>
</head>
<script type="text/javascript">
	$(function(){
		$('#login-btn').on('click',function(){
			if($('#id').val().length < 1 || $('#password').val().length < 1){
				alert ('아이디 와 비밀번호를 입력해주세요.');
				return false;
			}
		})
	})
</script>
<body>
	<div class="main">
    	<h2>North Star</h2>
    	<form method="post" action="login">
        <label>아이디</label>
        <input type="text" name="id" id="id">
        <label>비밀번호</label>
        <input type="password" name="password" id="password">
        <button type="submit" id="login-btn">로그인</button>
		</form>
	</div>
	<div>
		<c:if test="${param.login eq 'fail' }">
	   		<p style="color:red; font-size:14px;">사용자 정보가 일치하지 않습니다.</p> 
		</c:if>
		<c:if test="${param.login eq 'expire' }">
	   		<p style="color:red; font-size:14px;">로그인이 필요한 페이지 입니다.</p> 
		</c:if>
	</div>
</body>
</html>