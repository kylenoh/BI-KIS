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
			  <li>기술 지원 이력</li>
			  <li>기술 지원 등록</li>
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
	    <form method="post" action="addRequest" id="requestForm">
            <fieldset>
                <legend>기술 지원 등록</legend>
                <div id="addForm">
	                <div>
	                    <label for="category">분류 명</label>
	                    <select id="category" name="categoryNo">
	                        <option value="all"></option>
	                        <c:forEach var="category" items="${categoryList }">
	                        	<option value="${category.no }">${category.name }</option>
	                        </c:forEach>
                    	</select>  
	                </div>
	                <div id="dropdownArea">
	                    <label for="pjtNo">프로젝트 명</label>
	                    <input type="text" id="pjtNo" name="pjtNo" placeholder="프로젝트를 입력해주세요">
	                </div>
	                <div>
	                    <label for="companyName">고객사 명</label><input type="text" id="companyName" name="companyName" readonly="readonly">
	                </div>
	                <div>
	                    <label for="customer">담당자 명</label>
						<select id="customer" name="customerNo">
	                        <option value="all">담당자 선택</option>
                    	</select>
	                </div>
	                <div id="requestDate">
	                    <label for="startDate">시작일</label><input type="date" id="startDate" name="startDate">    
	                    <label for="endDate">종료일</label><input type="date" id="endDate" name="endDate">
	                </div>
	                <div>
	                	<label for="flag">진행상황</label>
		            	<select id="flag" name="flag">
		            		<option value="Y">진행예정</option>
		            		<option value="P">진 행 중</option>
		            		<option value="N">종     료</option>
		            	</select>
	                </div>
	                <div>
	                	<label for="suggest">요청 내용</label>
	                	<textarea id="suggest" name="suggest"></textarea>
	                </div>
	                <div>
	                	<label for="handle">처리 내용</label>
	                	<textarea id="handle" name="handle"></textarea>
	                </div>
	                <button type="submit">등록</button>
                </div>
            </fieldset>
		</form>
	</div>
</div>
	
</body>
<script type="text/javascript">
$(function(){
	$("#addForm").on('focus','#pjtNo',function(){
		$(this).attr('aria-autocomplete','list').attr('aria-expanded','false').attr('role','combobox').attr('autocomplete','off').attr('autocorrect','off');
	});
	$('#addForm').on('keyup','#pjtNo',function(){
		$.ajax({
			url: "searchProject",
			data: {keyword:$('#pjtNo').val()},
			dataType: 'json',
			success: function(projects){
				var row ="";
				row += '<ul class="dropdown-menu" style="top:auto; left:auto">';
				$.each(projects, function(index, project){
					row += '<li id="project-drop-' + project.no + '">';
					row += '<a href="javascript:void(0)">';
					row += project.title + '</a></li>';
				})
				row += '</ul>';
				$('#dropdownArea').children('ul').remove();
				$('#dropdownArea').append(row);
			}
		});
	});
})
</script>
</html>