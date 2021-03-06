<%@page import="com.cafe24.bitmall.vo.ProductVo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("newline","\n");
%>
<html>
<head>
	<title>비트닷컴 쇼핑몰</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.servletContext.contextPath }/assets/css/table.css" rel="stylesheet" type="text/css">
</head>
<body style="margin:0">
<jsp:include page="/WEB-INF/views/include/head.jsp"/>
<jsp:include page="/WEB-INF/views/include/search.jsp"/>
<table width="959" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr><td height="10" colspan="2"></td></tr>
	<tr>
		<td height="100%" valign="top">
			<jsp:include page="/WEB-INF/views/include/navigation.jsp"/>
		</td>
		<td width="10"></td>
		<td valign="top">


<!-------------------------------------------------------------------------------------------->	
<!-- 시작 : 다른 웹페이지 삽입할 부분                                                       -->
<!-------------------------------------------------------------------------------------------->	

      <!-- 하위 상품목록 -->

			<!-- form2 시작 -->
			<form name="form2" method="post" action="product.jsp">
			<input type="hidden" name="menu" value="1">

			</form>
			<!-- form2 -->
			<table border="0" cellpadding="0" cellspacing="0">
				<!--- 1 번째 줄 -->
				<c:set var="count" value="${fn:length(list) }" />
				<%-- <c:forEach var="num" begin="1" end="${count}/5" step="1"> --%>

					<c:forEach items="${list}" var="vo" varStatus="status">
						<c:if test='${("0" eq (status.index%5))}'>
						<tr>
						</c:if>
							<td  width="150" height="205" align="center" valign="top">
								<table border="0" cellpadding="0" cellspacing="0" width="100" class="cmfont">
										<tr> 
										<td align="center"> 
											<a href="product_detail?no=${vo.no}"><img class="circle" src="${pageContext.servletContext.contextPath }/uploads/images/${vo.path}" width="120" height="140" border="0"></a>
										</td>
									</tr>
									<tr><td height="5"></td></tr>
									<tr> 
										<td height="20" align="center">
											<a href="product_detail?no=${vo.no}"><font color="444444">${vo.title}</font></a>&nbsp; 
											<img src="${pageContext.servletContext.contextPath }/assets/images/i_hit.gif" align="absmiddle" vspace="1"> <img src="${pageContext.servletContext.contextPath }/assets/images/i_new.gif" align="absmiddle" vspace="1"> 
										</td>
										</tr> 
									<tr><td height="20" align="center"><b>${vo.price}원</br></b></td></tr>
								</table>
							</td>
							<c:if test='${"4" eq (status.index%5)}'>
								</tr>
								<tr><td height="10"></td></tr>
							</c:if>
					</c:forEach>
				<%-- </c:forEach> --%>


				

			</table>

			<table border="0" cellpadding="0" cellspacing="0" width="690">
				<tr>
					<td height="40" class="cmfont" align="center">
						<img src="${pageContext.servletContext.contextPath }/assets/images/i_prev.gif" align="absmiddle" border="0"> 
						<font color="#FC0504"><b>1</b></font>&nbsp;
						<a href="product.jsp?code1=1&code2=1"><font color="#7C7A77">[2]</font></a>&nbsp;
						<a href="product.jsp?code1=1&code2=1"><font color="#7C7A77">[3]</font></a>&nbsp;
						<img src="${pageContext.servletContext.contextPath }/assets/images/i_next.gif" align="absmiddle" border="0">
					</td>
				</tr>
			</table>

<!-------------------------------------------------------------------------------------------->	
<!-- 끝 : 다른 웹페이지 삽입할 부분                                                         -->
<!-------------------------------------------------------------------------------------------->	

		</td>
	</tr>
</table>
<br><br>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>