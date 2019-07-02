<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="style.jsp" %>
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
				<c:if test="${param.login eq 'flag' }">
			   		<p style="color:red; font-size:14px;">탈퇴한 계정입니다.</p> 
				</c:if>
			</div>
		</div>
	</div>
	
</body>
</html>