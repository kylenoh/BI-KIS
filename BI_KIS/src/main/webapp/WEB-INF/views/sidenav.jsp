<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidenav">
	<c:forEach var="categoryList" items="${CATEGORY_LIST}">
		<div class="dropdown-div">
			<span id="dropdown-span-${categoryList.CATE_DIVISION_LEVEL }" class="dropdown-span">${categoryList.CATE_DIVISION_NAME }<i class="fa fa-caret-down"></i></span>    
	        <div id="dropdown-container-${categoryList.CATE_DIVISION_LEVEL }"class="dropdown-container"></div>
	    </div>
	</c:forEach>
</div>
<script type="text/javascript">
	$(function(){
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
		        			rows += '<a href="' + section.cate_VALUE + '?categoryName=' + section.cate_SECTION_NAME + '"> ' + section.cate_SECTION_NAME + ' </a>';
	        			}else {
	        				location.href = section.cate_VALUE;
	        			}
	        		});
	        		$('#dropdown-container-' + divisionLevel).empty();
	        		$('#dropdown-container-' + divisionLevel).append(rows);
	        	}
	        })
	   });
	});
</script>