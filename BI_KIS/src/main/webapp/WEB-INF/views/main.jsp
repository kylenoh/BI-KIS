<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<title>테스트 페이지</title>
</head>
<body>
	<div class="wrap">

		<div class="sidenav">
			<button class="dropdown-btn">
				Dropdown <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-container">
				<a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a>
			</div>
			<a href="#contact">Search</a>
		</div>

		<div class="main">
			<div class="header">헤더라인</div>
			<div class="content">
				<form action="">
					<label>ID</label><input> <label>Password</label><input>
					<button>등록</button>
				</form>
			</div>
			<div class="footer">푸터라인</div>
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