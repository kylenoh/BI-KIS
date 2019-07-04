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
<div class="wrap">
	<div class="header">
		<%@ include file="../emp-interface.jsp" %>
	</div>
	<div class="main">
	
	    <div class="container">
	      	<div>
		       	<label for="name">담당자 명</label><input type="text" id="name" name="name" value="${customer.name }"disabled="disabled" class="inputTitle">
		    </div>
		    <div>
		        <label for="rank">직급</label><input type="text" id="rank" name="rank" value="${customer.rank }" disabled="disabled" class="inputTitle">
		    </div>
		    <div>
		        <label for="dept">부서명</label><input type="text" id="dept" name="dept" value="${customer.dept }" disabled="disabled" class="inputTitle">
		    </div>
		    <div>
		        <label for="tel1">연락처1</label><input type="text" id="tel1" name="tel1" value="${customer.tel1 }" disabled="disabled" class="inputTitle">
		        <label for="tel2">연락처2</label><input type="text" id="tel2" name="tel2" value="${customer.tel2 }" disabled="disabled" class="inputTitle">
			</div>
		    <div>
		    	<label for="email">이메일</label><input type="text" id="email" name="email" value="${customer.email }" disabled="disabled" class="inputTitle">
		    </div>
		    <div>
		      	<label for="remark">비고</label>
		       	<textarea id="remark" name="remark" disabled="disabled" class="textContent">${customer.remark }</textarea>
		    </div>
		</div>
       	<div style="float:right;">
          	<c:if test="${LOGIN_EMP.auth.no eq 1 || LOGIN_EMP.id eq company.registrant}">
          		<button type="button" class="btn success" id="btn-modify-customer" value="${customer.no }">수정</button>
           		<button type="button" class="btn danger" id="btn-del-customer" value="${customer.no }">삭제</button>
           	</c:if>
           	<button class="btn warning" type="button" onclick="location.href='company'">목록</button>
        </div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#btn-del-customer').click(function(){
			var customerNo = $(this).val();
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href="customerDelete?customerNo=" + customerNo;
			}
		});
		$('#btn-modify-customer').click(function(){
			var customerNo = $(this).val();
			if (confirm("수정 페이지로 이동하시겠습니까?")){
				location.href="customerModify?customerNo=" + customerNo;
			}
		});
	});
</script>	
</html>