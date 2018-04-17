<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
<script language = "javascript">
$(function(){
	 $(".link-delete").click(function(){
		/*closest 는 가장가까운 부모 요소 , find 자식요소들중에서 찾기*/
		/*event.preventDefault();*/
		var $row = $(this);
		var no  = $(this).data("no");
		if(no==null)
			return;
		
		$.ajax({
			url : "${pageContext.servletContext.contextPath}/api/product/delete", //요청할 URL
			dataType : "json", //응답받을 데이터타입
			type : "post", //요청 방식
			data : {"no" : no}, //서버에 요청시 보낼 파라미터 ex) {name:홍길동}
			success : function(response) { //요청 및 응답에 성공했을 경우
				console.log(response);
				$row.closest("tr").remove();
			},
			error : function(xhr, status, e) { //요청 및 응답에 실패 한 경우
				console.error(status + ":" + e);
			}
		});  
	}); 
});
</script>
</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>
<form name="form1" method="get" action="">
<table width="800" border="0" cellspacing="0" cellpadding="0">
	<tr height="40">
		<td align="left"  width="150" valign="bottom">&nbsp 제품수 : <font color="#FF0000">20</font></td>
		<td align="right" width="550" valign="bottom">
			<select name="sel1">
				<option value="0" >상품상태</option>
				<option value="1" >판매중</option>
				<option value="2" >판매중지</option>
				<option value="3" >품절</option>
			</select> &nbsp 
			<select name="sel2">
				<option value="0" >아이콘선택</option>
				<option value="1" >New</option>
				<option value="2" >Hit</option>
				<option value="3" >Sale</option>
			</select> &nbsp 
			<select name="sel3">
				<option value="0" >분류선택</option>
				<option value="1" >바지</option>
				<option value="2" >코트</option>
				<option value="3" >브라우스</option>
			</select> &nbsp 
			<select name="sel4">
				<option value="1" selected>제품이름</option>
				<option value="2" >제품번호</option>
			</select>
			<input type="text" name="text1" size="10" value="">&nbsp
		</td>
		<td align="left" width="120" valign="bottom">
			<input type="submit" value="검색">
			&nbsp;
			<a href="product_new"><input type="button" value="새상품"></a>
		</td>
	</tr>
	<tr><td height="5"></td></tr>
</table>
</form>

<table width="800" border="1" cellspacing="0" bordercolordark="white" bordercolorlight="black">
	<tr bgcolor="#CCCCCC" height="23"> 
		<td width="100" align="center">제품분류</td>
		<td width="280" align="center">제품명</td>
		<td width="70"  align="center">판매가</td>
		<td width="50"  align="center">상태</td>
		<td width="80"  align="center">수정/삭제</td>
	</tr>
	<c:forEach var="vo" items="${list }" varStatus="status">
	<tr bgcolor="#F2F2F2" height="23">	
		<td width="100">&nbsp ${map[vo.no].name }</td>
		<td width="280">&nbsp ${vo.title}</td>	
		<td width="70"  align="right">${vo.price} &nbsp</td>	
		<td width="50"  align="center">판매중</td>	
		<td width="80"  align="center">
			<a href="product_edit?no=${vo.no}">수정</a>/
			<a class="link-delete" data-no="${vo.no}" style="cursor:pointer">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>

<br>
<table width="800" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30" class="cmfont" align="center">
			<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_prev.gif" align="absmiddle" border="0"> 
			<font color="#FC0504"><b>1</b></font>&nbsp;
			<a href="product.jsp?page=2&sel1=&sel2=&sel3=&sel4=&text1="><font color="#7C7A77">[2]</font></a>&nbsp;
			<a href="product.jsp?page=3&sel1=&sel2=&sel3=&sel4=&text1="><font color="#7C7A77">[3]</font></a>&nbsp;
			<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_next.gif" align="absmiddle" border="0">
		</td>
	</tr>
</table>
</body>
</html>