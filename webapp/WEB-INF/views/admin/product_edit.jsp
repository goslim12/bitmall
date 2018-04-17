<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>

<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<form name="form1" method="post" action="product_edit" enctype="multipart/form-data">
<table width="800" border="1" cellspacing="0" cellpadding="3" bordercolordark="white" bordercolorlight="black">
	<tr height="23"> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품분류</td>
    	<td width="700" bgcolor="#F2F2F2">
			<select name="menu">
				<c:forEach var="categoryVo" items="${list }" varStatus="status">
					<c:if test='${(categoryVo.no eq vo.categoryNo)}'>
						<option value="${categoryVo.no}" selected >${categoryVo.name}</option>
					</c:if>
					<c:if test='${(categoryVo.no ne vo.categoryNo)}'>
						<option value="${categoryVo.no}">${categoryVo.name}</option>
					</c:if>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr> 	
		<td width="100" bgcolor="#CCCCCC" align="center">상품명</td>
		<td width="700"  bgcolor="#F2F2F2">
			<input type="text" name="name" value="${vo.title}" size="60" maxlength="60">
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">판매가</td>
		<td width="700"  bgcolor="#F2F2F2">
			<input type="text" name="price" value="${vo.price}" size="12" maxlength="12"> 원
		</td>
	</tr>
<!-- 	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">아이콘</td>
		<td width="700"  bgcolor="#F2F2F2">
			<input type="checkbox" name="icon_new" value="1"> New &nbsp;&nbsp	
			<input type="checkbox" name="icon_hit" value="1" checked> Hit &nbsp;&nbsp	
			<input type="checkbox" name="icon_sale" value="1" onclick="form1.discount.disabled=!form1.discount.disabled;"> Sale &nbsp;&nbsp
			할인율 : <input type="text" name="discount" value="10" size="3" maxlength="3" disabled> %
		</td>
	</tr> -->
	<!-- <tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">등록일</td>
		<td width="700"  bgcolor="#F2F2F2">
			<input type="text" name="regday1" value="2007" size="4" maxlength="4"> 년 &nbsp
			<input type="text" name="regday2" value="2007" size="2" maxlength="2"> 월 &nbsp
			<input type="text" name="regday3" value="2007" size="2" maxlength="2"> 일 &nbsp
		</td>
	</tr> -->
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">이미지</td>
		<td width="700"  bgcolor="#F2F2F2">

			<table border="0" cellspacing="0" cellpadding="0" align="left">
				<tr>
					<td>
						<table width="390" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<input type='hidden' name='imagename1' value='s001_1.jpg'>
									<input type='hidden' name='no' value='${vo.no}'>
									&nbsp;<input type="checkbox" name="checkno1" value="1"> <b>이미지</b>: ${vo.path}
									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="file" name="image1" size="20" value="찾아보기">
								</td>
							</tr> 
							<!-- <tr>
								<td>
									<input type='hidden' name='imagename2' value='s001_2.jpg'>
									&nbsp;<input type="checkbox" name="checkno2" value="1"checked> <b>이미지2</b>: s001_2.jpg
									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="file" name="image2" size="20" value="찾아보기">
								</td>
							</tr> 
							<tr>
								<td>
									<input type='hidden' name='imagename3' value=''>
									&nbsp;<input type="checkbox" name="checkno3" value="1"> <b>이미지3</b>:
									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="file" name="image3" size="20" value="찾아보기">
								</td>
							</tr> --> 
							<!-- <tr>
								<td><br>&nbsp;&nbsp;&nbsp;※ 삭제할 그림은 체크를 하세요.</td>
							</tr>  -->
				  	</table>
						<br><br><br><br><br>
						<table width="390" border="0" cellspacing="0" cellpadding="0">
							<%-- <tr>
								<td  valign="middle">&nbsp;
									<img src="${pageContext.servletContext.contextPath }/assets/images/product/s001_1.jpg" width="50" height="50" border="1" style='cursor:hand' onclick="imageView('${pageContext.servletContext.contextPath }/assets/images/product/s001_1.jpg')">&nbsp;
									<img src="${pageContext.servletContext.contextPath }/assets/images/product/s001_2.jpg" width="50" height="50" border="1" style='cursor:hand' onclick="imageView('${pageContext.servletContext.contextPath }/assets/images/product/s001_2.jpg')">&nbsp;
									<img src="${pageContext.servletContext.contextPath }/assets/images/product/nopic.jpg"  width="50" height="50" border="1" style='cursor:hand' onclick="imageView('${pageContext.servletContext.contextPath }/assets/images/product/nopic.jpg')">&nbsp;
								</td>
							</tr> --%>				 
						</table>
					</td>
					<td>
						<td align="right" width="310"><img name="big" src="${pageContext.servletContext.contextPath }/uploads/images/${vo.path}" width="300" height="300" border="1"></td>
					</td>
				</tr>
			</table>

		</td>
	</tr>
</table>
<br>
<table width="800" border="0" cellspacing="0" cellpadding="5">
	<tr> 
		<td align="center">
			<input type="submit" value="수정하기"> &nbsp;&nbsp
			<a href="product.jsp"><input type="button" value="이전화면"></a>
		</td>
	</tr>
</table>
</form>
</body>
</html>
