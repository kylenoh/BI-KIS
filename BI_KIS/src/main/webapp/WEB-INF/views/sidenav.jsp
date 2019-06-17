<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidenav">
	<div class="dropdown-div">
		<span class="dropdown-span">
		BI 기술 지원 <i class="fa fa-caret-down"></i>
        </span>    
        <div class="dropdown-container">
        	<a href="project">프로젝트 관리</a>
            <a href="company">고객사 관리</a>
            <a href="#">기술지원이력</a>
        </div>
    </div>
    <div class="dropdown-div">
    	<span class="dropdown-span">
        BI 기술정보 <i class="fa fa-caret-down"></i>
        </span>
        <div class="dropdown-container">
            <a href="board">문서</a>
            <a href="board">교육</a>
            <a href="board">영어</a>
        </div>
    </div>
    <div class="dropdown-div">
        <span class="dropdown-span">
         	환경설정 <i class="fa fa-caret-down"></i>
        </span>
        <div class="dropdown-container">
            <a href="#">사용자 관리</a>
            <a href="#">자산관리</a>
        </div>
    </div>
</div>
<script type="text/javascript">
	$(function(){
		$(".sidenav").on('click','[class^=dropdown-div]',function(){
	        $(this).find("span").toggleClass("active");
	        if($(this).find("span").hasClass("active")){
	            $(".dropdown-div > div").css("display","none");
	            $(this).children().css("display","block");
	            $(this).siblings().find("span").removeClass("active");    
	        }else{    
	            $(".dropdown-div > div").css("display","none");
	        }
	   });
	});
</script>