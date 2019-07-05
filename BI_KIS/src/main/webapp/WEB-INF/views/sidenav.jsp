<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidenav">
	<c:forEach var="categoryList" items="${CATEGORY_LIST}">
		<c:if test="${LOGIN_EMP.auth.no le categoryList.CATE_AUTH_NO }">
			<div class="dropdown-div">
				<span id="dropdown-span-${categoryList.CATE_DIVISION_LEVEL }" class="dropdown-span">${categoryList.CATE_DIVISION_NAME }<i class="fa fa-caret-down"></i></span>    
		        <div id="dropdown-container-${categoryList.CATE_DIVISION_LEVEL }"class="dropdown-container"></div>
		    </div>
	    </c:if>
	</c:forEach>
</div>
<script type="text/javascript">
	$(function(){
		$('.summernote').summernote({
			height: 300,
			lang : 'ko-KR',
			callbacks: { // 콜백을 사용
	                // 이미지를 업로드할 경우 이벤트를 발생
			    onImageUpload: function(files, editor, welEditable) {
				    sendFile(files[0], this);
				}
			}
		});
		  /* summernote에서 이미지 업로드시 실행할 함수 */
	 	function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
	 		data = new FormData();
	 	    data.append("uploadFile", file);
	 	    $.ajax({ // ajax를 통해 파일 업로드 처리
	 	        data : data,
	 	        type : "POST",
	 	        url : "imageUpload",
	 	        cache : false,
	 	        contentType : false,
	 	        processData : false,
	 	        enctype : 'multipart/form-data',
	 	        success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
                    alert(data);
	 	        	$(editor).summernote('editor.insertImage', data);
	 	        }
	 	    });
	 	} 
		$(".dropdown-div").on('click','[id^=dropdown-span-]',function(){
			var divisionName = $(this).text().trim();
			var divisionLevel = $(this).attr('id').replace('dropdown-span-','');
	        $(this).toggleClass("active");
	        if($(this).hasClass("active")){
	            $(this).siblings().css("display","block");
	        }else{
	        	$(this).siblings().css("display","none");
	        }
	        $.ajax({
	        	url: "getCateSectionListByDivisionName",
	        	data:{divisionName:divisionName},
	        	dataType: "json",
	        	success:function(SectionList){
	        		var rows = "";
	        		$.each(SectionList, function(index, section){
	        			if(section.cate_SECTION_NAME != null){
		        			rows += '<a class="cateList" href="' + section.cate_VALUE + '?cateNo=' + section.cate_NO + '"> ' + section.cate_SECTION_NAME + ' </a>';
	        			}else {
	        				location.href = section.cate_VALUE + '?cateNo=' + section.cate_NO;
	        			}
	        		});
	        		$('#dropdown-container-' + divisionLevel).empty();
	        		$('#dropdown-container-' + divisionLevel).append(rows);
	        	}
	        })
	   });
	});
</script>