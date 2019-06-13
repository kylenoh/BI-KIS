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
<style type="text/css">
.login {
   position: absolute;
   display: table;
   top: 0;
   left: 0;
   width: 100%;
   height: 100%
}
.login .login_inner {
   display: table-cell;
   text-align: center;
   vertical-align: middle
}
.login .login_form {
   display: inline-block;
}
.login_textForm{
	border: 1px solid #ccc;
	border-radius: 3px;
	float:right;
}
.login_form input {
	margin-bottom:10px;
	height:30px;
	text-indent: 10px;
}
.login_form button {
	border-radius: 5px;
	border: 2px solid lightgray;
	cursor: pointer;
	padding: 10px 25px 10px 25px;
	font-weight: bold;
	transition: 0.3s;
	width:100%;
}
</style>

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
	<div class="login">
		<div class="login_inner">
			<div class="login_form">
				<h2>North Star</h2>
				<form method="post" action="login">
					<div>
						<input type="text" name="id" id="id" class="login_textForm" placeholder="아이디">
					</div>
					<div>
						<input type="password" name="password" id="password" class="login_textForm" placeholder="비밀번호">
					</div>
					<div>
						<button type="submit" id="login-btn">로그인</button>
					</div>
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
		</div>
	</div>
	
</body>
</html>