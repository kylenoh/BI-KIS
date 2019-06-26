<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../style.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../sidenav.jsp" %>
<input type="hidden" id="login-auth" value="${LOGIN_EMP.auth.no }">
<div class="wrap">
	<div class="header">
		<%@ include file="../emp-interface.jsp" %>
	</div>
	
	<div class="main">
	    <form method="post" action="empAdmin" id="searchForm">
            <fieldset>
                <legend>검색라인</legend>
                <div>
                    <label for="name">사원 명</label><input type="text" class="inputSearch" id="name" name="name">
                </div>
                <div>
                    <button class="ym-search-btn" type="submit">검색</button>
                </div>
            </fieldset>
		</form>
		<div>
			<button type="button" onclick="location.href='addEmp'" class="write">사원 등록</button>
		</div>
		<div>
			<span> 사원 수 : ${totalRows}</span>
		</div>
		<table border="1">
			<thead>
				<tr>
					<th>아이디</th>
					<th>사원명</th>
					<th>직책</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>권한</th>
					<th>수정</th>
					<th>사용여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${empList }">
					<tr>
						<td><a class="no-link" href="empDetail?empId=${emp.id}">${emp.id}</a></td>
						<td>${emp.name}</td>
						<td>${emp.rank}</td>
						<td>${emp.tel}</td>
						<td>${emp.email}</td>
						<td>
							<select class="empAuth" name="empAuth" id="td-emp-${emp.id }">
								<c:forEach var="listAuth" items="${authList }">
									<option value="${listAuth.no }" <c:if test="${emp.auth.no eq listAuth.no }">selected</c:if>>${listAuth.name}</option>
								</c:forEach>
							</select>
							<input type="hidden" id="bef-auth-${emp.id }" value="${emp.auth.no }">
						</td>
						<td><button class="ym-btn" type="button" id="btn-modify-emp-${emp.id }" value="${emp.id }">수정</button></td>
						<td><span>${emp.flag eq 'Y' ? '사용중' : '사용안함'}</span><button class="ym-btn" type="button" id="btn-delete-emp-${emp.id }" value="${emp.id }">${emp.flag eq 'Y' ? '미사용' : '사용' }</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="footer">
		<div align="center">
			<c:if test="${!empty empList}">
				<c:if test="${pagination.cb gt 1 }">
					<a href="empAdmin?cp=${pagination.beginPageIndex - 1}">&laquo;</a>
				</c:if>
				<c:forEach var="num" begin="${pagination.beginPageIndex}" end="${pagination.endPageIndex }">
					<a href="empAdmin?cp=${num}">${num }</a>
				</c:forEach>
				<c:if test="${pagination.cb lt pagination.totalBlocks }">
					<a href="empAdmin?cp=${pagination.endPageIndex + 1 }">&raquo;</a>
				</c:if>
			</c:if>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$('[id^=btn-delete-emp-]').click(function(){
			var empId = $(this).val();
			var flagCheck = $(this).text();
			location.href="empDelete?empId=" + empId + "&flagCheck=" + flagCheck;
		});
		$('[id^=btn-modify-emp-]').click(function(){
			var empId = $(this).val();
			location.href="empModify?empId=" + empId;
		});
		$('.empAuth').on('change',function(){
			var new_authNo = $(this).val();
			var empId = $(this).attr('id').replace('td-emp-','');
			
			var bef_authNo = $('#bef-auth-'+empId).val();
			var login_authNo = $('#login-auth').val();
			
			var result = accessPossible(bef_authNo, new_authNo, login_authNo);
			if(result){
				$.ajax({
					url: "empAuthUpdate",
					data: {authNo:new_authNo,empId:empId},
					success:function(){
						alert("권한이 수정되었습니다.")
						$('#bef-auth-'+empId).val(new_authNo);
					}			
				})
			}
		});
		
	});
var accessPossible = function (bef_authNo, new_authNo, login_authNo){
	if(login_authNo > new_authNo){
		alert("자기 권한 보다 높은 권한은 부여할 수 없습니다.")
		return false;
	}
	if(bef_authNo < login_authNo){
		alert("상위 권한자의 권한을 변경할 수 없습니다.")
		return false;
	}
	if(login_authNo <= new_authNo){
		return true;
	}
};
</script>	
</body>

</html>