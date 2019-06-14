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
	    <form method="post" action="project" id="pjtForm">
            <fieldset>
                <legend>검색라인</legend>
                <div>
                    <label for="title">프로젝트 명</label><input type="text" id="title" name="title">
                </div>
                <div>
                    <label for="startDate"></label><input type="date" id="startDate" name="startDate">    
                    <label for="endDate"></label><input type="date" id="endDate" name="endDate">
                </div>
                <div>
                    <label for="company">고객사 명</label>
	                    <select id="company" name="companyNo">
		                        <option value="0"></option>
		                        <c:forEach var="comList" items="${companyList }">
		                        	<option value="${comList.no }">${comList.name }</option>
		                        </c:forEach>
	                    </select>      
                </div>
                <div>
                    <select id="project-flag" name="flag">
                        <option value="all">All</option>
                        <option value="Y">Expected</option>
                        <option value="P">Processing</option>
                        <option value="N">End</option>
                    </select>

                    <button type="submit">Search</button>
                </div>
            </fieldset>
		</form>
		<button type="button" onclick="location.href='addproject'" class="write">프로젝트 등록</button>
		
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
					<td><a href="pjtdetail?pjtNo=${project.no }">${project.title }</a></td>
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
		<div align="center">
			<c:if test="${pagination.cb gt 1 }">
				<a href="project?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
			</c:if>
			<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
				<a href="project?cp=${num}">${num }</a>
			</c:forEach>
			<c:if test="${pagination.cb lt pagination.totalBlocks }">
				<a href="project?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
			</c:if>
	</div>
	</div>
</div>
	
</body>
</html>