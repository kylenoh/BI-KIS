<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<title>테스트 페이지</title>
</head>
<body>
   <div class="sidenav">
      <button class="dropdown-btn">
         BI 기술 지원 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-container">
         <a href="#">프로젝트 관리</a> <a href="#">고객사 관리</a> <a href="#">기술지원이력</a>
      </div>
      <button class="dropdown-btn">
         BI 기술정보 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-container">
         <a href="#">문서</a> <a href="#">교육</a> <a href="#">영어</a>
      </div>
      <button class="dropdown-btn">
         환경설정 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-container">
         <a href="#">사용자 관리</a> <a href="#">자산관리</a>
      </div>
   </div>

   <div class="main">
      <h2>North Star</h2>
      <form method="post" action="login">
         <label>아이디</label>
         <input type="text" name="id">
         <label>비밀번호</label>
         <input type="password" name="password">
         <button type="submit">로그인</button>
      </form>
   </div>
<script>
$(document).ready(function(){
   $(".dropdown-btn").click(function(){
      $(this).toggleClass("active");
         $(".dropdown-container").css("display","none");
         $(".dropdown-container").css("display","block");   
   });
});

</script>
</body>
</html>