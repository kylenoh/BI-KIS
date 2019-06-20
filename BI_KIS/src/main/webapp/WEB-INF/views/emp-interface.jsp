<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header-right">
	<ul class="userInterface">
		<li>
			<span id="myPage" onclick="myPage();" class="dropbtn"><i class="fas fa-cog">마이페이지</i></span>
		</li>
		<li>
			<span><i class="fas fa-sign-in-alt"><a href="logout" class="no-link">로그아웃</a></i></span>
		</li>
	</ul>
    <div id="myDropdown" class="dropdown-content">
		<a href="#home">Home</a>
		<a href="#about">About</a>
		<a href="#contact">Contact</a>
	</div>
</div>
<script type="text/javascript">
function myPage(){
	var condition = $('#myPage').toggleClass("show");
	if (condition.hasClass("show")) {
		$('.dropdown-content').css("display","block");
	}else{
		$('.dropdown-content').css("display","none");
	}
}
</script>