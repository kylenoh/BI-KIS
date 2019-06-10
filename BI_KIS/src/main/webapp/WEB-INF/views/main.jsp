<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="resources/css/index.css">
<title>테스트 페이지</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
			제목 라인
		</div>
		<div class="nav">
			네이버게이션
		</div>
		<div class="content">
			<form action="login" method="post">
					<label>ID</label>
					<input type="text" name="empId">
					<label>Password</label>
					<input type="password" name="pwd">
				<button type="submit" >등록</button>
			</form>	
		</div>
		<div class="footer">
			푸터라인
		</div>
	</div>
	
</body>
</html>