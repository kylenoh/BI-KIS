<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../style.jsp" %>
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
			  <li>프로젝트</li>
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
		<form method="post" action="pjtmodify" id="pjtForm">
			<input type="hidden" name="pjtNo" value="${pjt.no }">
		    <fieldset>
	        	<legend>프로젝트</legend>
	            <div id="PjtDetail">
		            <div>
		        	    <label for="title">프로젝트 명</label>
		        	    <input type="text" id="title" value="${pjt.title }" name="title">
		            </div>
		            <div>
		                <label for="company">고객사 명</label>
	                    <select id="company" name="companyNo">
	                        <c:forEach var="comList" items="${companyList }">
	                        	<option value="${comList.no }" <c:if test="${pjt.company.no eq comList.no }">selected</c:if>>${comList.name }</option>
	                        </c:forEach>
                    	</select>    
		            </div>
		            <div id="PjtDate">
		                <label for="startDate">시작일</label>
		                <input type="date" id="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${pjt.startDate }"/>" name="startDate">    
		                <label for="endDate">종료일</label>
		                <input type="date" id="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${pjt.endDate }"/>" name="endDate">
		            </div>
		            <div>
		            	<label for="flag">진행상황</label>
		            	<select id="flag" name="flag">
		            		<option value="Y" <c:if test="${pjt.flag eq 'Y' }">selected</c:if>>진행예정</option>
		            		<option value="P" <c:if test="${pjt.flag eq 'P' }">selected</c:if>>진 행 중</option>
		            		<option value="N" <c:if test="${pjt.flag eq 'N' }">selected</c:if>>종     료</option>
		            	</select>
		            </div>
		            <div id="emp-area">
		            	<label for="customer">담당자</label>
		            	<select id="emp">
	                		<option></option>
	                		<c:forEach var="emp" items="${empList }">
	                			<option id="emp-id-${emp.id }" value="${emp.id }">${emp.name }</option>
	                		</c:forEach>
	                	</select>
		            	<c:forEach var="choiceEmp" items="${pjt.emps }">
		            		<div style="display:inline-block; width: auto !important;">
		            			<span>${choiceEmp.name }</span>
		            			<a id="emp-info-${choiceEmp.id}" class="close" href="javascript:void(0)"> x</a>
		            			<input type="hidden" name="emp-info" value="${choiceEmp.id }">
		            		</div>
		            	</c:forEach>
		            </div>
		            <div>
		                <label for="content">내용</label>
		                <textarea id="content" name="content">${pjt.content }</textarea>
		            </div>
		            <div>
		            	<label for="remark">비고</label>
		              	<textarea id="remark" name="remark">${pjt.remark }</textarea>
		            </div>
		            <div style="float:right;">
		            	<button type="submit" >수정</button>
		            	<button type="button" onclick="location.href='pjtdetail?pjtNo='+${pjt.no}">뒤로 가기</button>
		            </div>
	            </div>
	        </fieldset>
        </form>
	</div>
</div>
	
</body>
<script type="text/javascript">
	$(function(){
		$('#emp').on('change',function(){
			var empId = $(this).val();
			var row ="";
			var hidden = "";
			$.ajax({
				url: "getEmpByEmpIdInfo",
				data: {empId:empId},
				dataType: 'json',
				success:function(result){
					row += '<div style="display:inline-block; width: auto !important;">';
					row += '<span>' + result.name + '</span>';
					row += '<a id="emp-info-' + result.id +'" class="close" href="javascript:void(0)" rele="button"> x </a>';
					row += '<input type="hidden" name="emp-info" value="' + result.id + '">';
					row += '</div>';
					
					$('#emp').find('option:first').prop('selected', 'selected');
					$('#emp-area').append(row);
				}
			});
			
		});
		$('#emp-area').on('click','[id^=emp-info-]',function(){
			$(this).parent().remove();
		})
	});
</script>
</html>