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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function myPage(){
	var condition = $('#myPage').toggleClass("show");
	if (condition.hasClass("show")) {
		$('.dropdown-content').css("display","block");
	}else{
		$('.dropdown-content').css("display","none");
	}
}
$(document).ready(function(){
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
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li>BI 기술 지원</li>
			  <li>프로젝트 관리</li>
			</ul>
		</div>
		<div class="header-right">
			<ul class="userInterface">
				<li>
					<span id="myPage" onclick="myPage();" class="dropbtn"><i class="fas fa-cog">마이페이지</i></span>
				</li>
				<li><span><i class="fas fa-sign-in-alt">로그아웃</i></span></li>
			</ul>
            <div id="myDropdown" class="dropdown-content">
            	<a href="#home">Home</a>
                <a href="#about">About</a>
                <a href="#contact">Contact</a>
            </div>
		</div>
	</div>
	
	<div class="main">
	    <form method="post" action="pjtSearch" id="pjtForm">
            <fieldset>
                <legend>검색라인</legend>
                <div>
                    <label for="title">프로젝트 명</label><input type="text" id="title">
                </div>
                <div>
                    <label for="startDate"></label><input type="date" id="startDate">    
                    <label for="endDate"></label><input type="date" id="endDate">
                </div>
                <div>
                    <label for="company">고객사 명</label><input type="text" id="company">    
                </div>
                <div>
                    <select id="project-flag" name="pjtFlag">
                        <option value="all">All</option>
                        <option value="expected">Expected</option>
                        <option value="processing">Processing</option>
                        <option value="end">End</option>
                    </select>

                    <button type="submit">Search</button>
                </div>
            </fieldset>
		</form>
		<button type="button" onclick="location.href='addproject' " class="write">프로젝트 등록</button>
		
		<table border="1">
			<thead>
				<tr>
					<th>프로젝트 명</th>
					<th>고객사 명</th>
					<th>진행일자</th>
					<th>진행상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${pjtList }">
				<tr>
					<td>${project.title }</td>
					<td>${project.company.name }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${project.startDate }"/>
					  ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${project.endDate }"/></td>
					<td>
						<c:if test="${project.flag eq 'Y' }">
	                    	진행예정
	                    </c:if>
	                    <c:if test="${project.flag eq 'P' }">
	                    	진행중
	                    </c:if>
	                    <c:if test="${project.flag eq 'N' }">
	                    	종료
	                    </c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div class="pagination">
                  <a href="#">&laquo;</a>
                  <a href="#">1</a>
                  <a href="#" class="active">2</a>
                  <a href="#">3</a>
                  <a href="#">4</a>
                  <a href="#">5</a>  
                  <a href="#">&raquo;</a>
                </div>
	</div>
</div>
	
</body>
</html>