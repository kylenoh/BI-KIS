<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/ym.css">
<link rel="stylesheet" href="resources/css/sh.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function () {

	$(".fileDrop").on("dragenter dragover", function(event){
		event.preventDefault();
	});
	
	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		
		var file = files[0];
		
		//console.log(file);
		
		var formData = new FormData(); // HTML5
		formData.append("file", file);
		
		$.ajax({
			url: '/sample/upload/uploadAjax',
			data: formData,
			dataType: 'text',
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data){
				//alert(data);
				//서버로 파일을 전송한 다음에 그 파일을 다시 받아온다.?
				
				//이미지 인경우 썸네일을 보여준다.
				if(checkImageType(data)){
					str = "<div>"
						+ "<a href='/sample/upload/displayFile?fileName=" + getImageLink(data) + "'>"
						+ "<img src='/sample/upload/displayFile?fileName=" + data + "'/>"
						+ "</a>"
						+ "<small data-src='" + data + "'>X</small></div>";
				}else {
					str = "<div>"
						+ "<a href='/sample/upload/displayFile?fileName=" + data + "'>"
						+ getOriginalName(data) + "</a>"
						+ "<small data-src='" + data + "'>X</small></div>";
				}//else
					
				$(".uploadedList").append(str);	
			},
		});// ajax
		
	});
	
	
	/* 컨트롤러로 부터 전송받은 파일이 이미지 파일인지 확인하는 함수 */
	function checkImageType(fileName){
		var pattern = /jpg$|gif$|png$|jpeg$/i;
		return fileName.match(pattern);
	}//checkImageType
	
	//파일 이름 처리 : UUID 가짜 이름 제거
	function getOriginalName(fileName){
		if(checkImageType(fileName)){
			return;
	}
		
		var idx = fileName.indexOf("_") + 1;
		return fileName.substr(idx);
			
	}//getOriginalName
	
	//이미지 원본 링크 제공
	function getImageLink(fileName){
		
		if(!checkImageType(fileName)){
			return;
		}//if
		
		var front = fileName.substr(0, 12);
		var end = fileName.substr(14);
		
		return front + end;
		
	}//getImageLink
	
	
	//업로드 파일 삭제 처리
	$(".uploadedList").on("click", "small", function(event){
		
		var that = $(this);
		
		alert($(this).attr("data-src"));
		
		$.ajax({
			url: "/sample/upload/deleteFile",
			type: "post",
			data: {fileName:$(this).attr("data-src")},
			dataType: "text",
			success : function(result){
				if(result == 'deleted'){
					//alert("deleted");
					that.parent("div").remove();
				}//
			},
		});
		
	});//uploadedList
	
});
</script>
<body>
<%@ include file="../sidenav.jsp" %>
<div class="wrap">
	<div class="header">
		<div class="header-left">
			<ul class="breadcrumb">
			  <li><a href="#">BI 기술 정보</a></li>
			  <li><a href="#">등록</a></li>
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
		
		<form method="post" action="upload" enctype="multipart/form-data">
		  <div class="container">
		  	<div class="container-header">
			    <label for="uploadtitle"><b>제목</b></label>
			    <input type="text" name="uploadtitle" class="boardTitle" required>
			    <label for="uploadtype"><b>분류</b></label>
			    <select class="boardType" name="uploadtype">
			    	<option selected value="문서">문서</option>
			    	<option value="교육">교육</option>
			    	<option value="영어">영어</option>
			    </select>
			</div>
			<div class="container-content">
			    <label for="content"><b>내용</b></label>
			    <textarea name="uploadcontent" class="boardContent"></textarea>
			    <label for="file"><b>첨부파일</b></label>
			    <input type="file" name="file" multiple="multiple" id="boardFile">
			</div>
			<div class="container-footer">
		    	<button type="submit" class="writebtn">등록</button>
		    </div>
		  </div>
		</form>
		<!-- 여기 -->
		 <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Ajax File Upload</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <!-- <form id="form1" action="/sample/upload/uploadForm" method="post" enctype="multipart/form-data"> -->
            <form id="form" action="/sample/upload/uploadForm" method="post" enctype="multipart/form-data">
              <div class="box-body">
                <div class="form-group">
				  <div class="fileDrop"></div>	
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <!-- <button type="submit" class="btn btn-warning">제출</button> -->
                <div class="uploadedList"></div>
              </div>
            </form>
          </div>
		
		
	</div>
	
	<div class="footer">
	</div>
</div>
	
</body>
</html>