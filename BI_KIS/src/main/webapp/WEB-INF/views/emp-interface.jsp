<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<div class="header">
				<c:if test="${null ne HEADER_VALUE.CATE_SECTION_NAME}">
			  		<a href="#" class="active">${HEADER_VALUE.CATE_SECTION_NAME}</a>
			  	</c:if>
			  	<c:if test="${null eq HEADER_VALUE.CATE_SECTION_NAME}">
			  		<a href="#" class="active">${HEADER_VALUE.CATE_DIVISION_NAME}</a>
			  	</c:if>
			  <div class="header-right">
			  	<a href="empDetail?empId=${LOGIN_EMP.id }">회원정보</a>
  				<a href="logout">로그아웃</a>
			  </div>
			</div>
