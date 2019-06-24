<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidenav">
	<div class="dropdown-div">
		<span class="dropdown-span">
		BI 사업부 <i class="fa fa-caret-down"></i>
        </span>    
        <div class="dropdown-container">
        	<a href="project">프로젝트 관리</a>
            <a href="company">고객사 관리</a>
            <a href="request">기술지원이력</a>
        </div>
    </div>
     <div class="dropdown-div">
    	<span class="dropdown-span">
        솔류션 <i class="fa fa-caret-down"></i>
        </span>
        <div class="dropdown-container">
            <a href="#">WebMethods</a>
            <a href="#">iChain</a>
        </div>
    </div>
    <div class="dropdown-div">
    	<span class="dropdown-span">
       <a href="board">게시판</a>
        </span>
    </div>
    <div class="dropdown-div">
    	<span class="dropdown-span">
        직원관리 <i class="fa fa-caret-down"></i>
        </span>
        <div class="dropdown-container">
            <a href="#">직원 정보</a>
            <a href="property">자산 정보</a>
        </div>
    </div>
    <c:if test="${LOGIN_EMP.auth.no eq 1 || LOGIN_EMP.auth.no eq 2}">
	    <div class="dropdown-div">
	        <span class="dropdown-span">
	         	환경설정 
	        </span>
	        <div class="dropdown-container">
	            <a href="empAdmin">권한 관리</a>
	            <a href="property">분류 관리</a>
	        </div>
	    </div>
    </c:if>
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