<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>비트닷컴 쇼핑몰</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
	<script>
		function totalPrice() {
			var count = $('input[name="num2"]');
			var price = $('span.price');
			console.log(price);
			console.log(count);
			var sum = 0;
			
			for(var i = 0; i < count.length; i++){
				sum += parseInt(count[i].value) * parseInt(price[i].innerText);
			}
		/* 	if(sum<=0){
				
			} */
			$('#total').text(sum);
			$('#totalPrice').text(sum+2500);
			
			
		}
	
		$(function(){
			totalPrice();
			
			 $("input[src='${pageContext.servletContext.contextPath}/assets/images/b_edit1.gif']").click(function(event){
				/*closest 는 가장가까운 부모 요소 , find 자식요소들중에서 찾기*/
					event.preventDefault();
				var $num2 = $(this).closest("tr").find("input[name=num2]");
				var count = $num2.val(); /*수량*/
				var productNo = ($(this).attr('id'));
				var preTotalPrice= $("#"+productNo+"_totalPrice").text();
				var prePrice= $("#"+productNo+"_price").text();
				if(count===null||productNo===null){
					return;
				}
				if(count<=0){
					alert("수량은 1개 이상이어야 합니다.")
					$num2.val(preTotalPrice/prePrice);
					return;
				}
				$.ajax({
					url : "${pageContext.servletContext.contextPath}/api/cart/modify", //요청할 URL
					dataType : "json", //응답받을 데이터타입
					type : "post", //요청 방식
					data : {
						"productNo" : productNo,
						"count" : count
					}, //서버에 요청시 보낼 파라미터 ex) {name:홍길동}
					success : function(response) { //요청 및 응답에 성공했을 경우
						//$(this).closest("tr").find("input[name=num2]").val(count)
						//var prePrice= $("#"+productNo+"_totalPrice").text();
						$num2.text(count);
					    //var curPrice= count*response.data.price;
					    $("#"+productNo+"_totalPrice").text(count*response.data.price);
						
						//var sum = $("#sumPrice").data("sum");
						//sum = sum - prePrice + curPrice;
						//var totalSum = sum+2500;
						//$("#sumPrice").html('<font color="#0066CC"><b >총 합계금액</b></font> : 상품대금('+sum+'원) + 배송료(2,500원) = <font color="#FF3333"><b>'+totalSum+' 원</b></font>&nbsp;&nbsp');
						
					    totalPrice();
					},
					error : function(xhr, status, e) { //요청 및 응답에 실패 한 경우
						console.error(status + ":" + e);
					}
				}); 
			}); 
		
			 $("input[src='${pageContext.servletContext.contextPath}/assets/images/b_delete1.gif']").click(function( event ){
					event.preventDefault();
				 /*closest 는 가장가까운 부모 요소 , find 자식요소들중에서 찾기*/
					var count = $(this).closest("tr").find("input[name=num2]").val(); /*수량*/
					var productNo = ($(this).attr('id'));
					var $tmp = $(this); 
					console.log(count);
					console.log(productNo);
					if(count===null||productNo===null){
						return;
					}
					$.ajax({
						url : "${pageContext.servletContext.contextPath}/api/cart/delete", //요청할 URL
						dataType : "json", //응답받을 데이터타입
						type : "post", //요청 방식
//						data : "productNo=" + productNo + "&count=" + count, //서버에 요청시 보낼 파라미터 ex) {name:홍길동}
						data : {
							"productNo" : productNo,
							"count" : count
						},
						success : function(response) { //요청 및 응답에 성공했을 경우
							//$(this).closest("tr").find("input[name=num2]").val(count)
							alert("["+response.data.title+"]을(를) 삭제 하였습니다.")
							/* var sum = $("#sumPrice").data("sum");
							console.log("preSum : "+sum);
							console.log("preSum : "+sum);
							sum-=count*response.data.price;
							var totalSum = sum+2500;
							console.log("sum : "+sum);
							console.log("sum : "+sum);
							console.log("jstl : "+"${sum}"); */
							$tmp.closest("tr").remove();
							 totalPrice();
							/* if(sum<=0){
								$("#sumPrice").html('<font color="#0066CC"><b >총 합계금액</b></font> 0원<font color="#FF3333"><b></b></font>&nbsp;&nbsp');
							}else{
								$("#sumPrice").html('<font color="#0066CC"><b >총 합계금액</b></font> : 상품대금('+sum+'원) + 배송료(2,500원) = <font color="#FF3333"><b>'+totalSum+' 원</b></font>&nbsp;&nbsp');
							} */
						},
						error : function(xhr, status, e) { //요청 및 응답에 실패 한 경우
							console.error(status + ":" + e);
						}
					});
				}); 
				/* $("img[src='${pageContext.servletContext.contextPath }/assets/images/b_shopping.gif']").click(function(){
//					location.href = "${pageContext.servletContext.contextPath}/user/member_join";
					console.log( document.referrer);
				}); */
				
			 $("img[src='${pageContext.servletContext.contextPath}/assets/images/b_cartalldel.gif']").click(function(){
					var $tmp = $(this); 
					$.ajax({
						url : "${pageContext.servletContext.contextPath}/api/cart/alldelete", //요청할 URL
						dataType : "json", //응답받을 데이터타입
						type : "post", //요청 방식
						success : function(response) { //요청 및 응답에 성공했을 경우
								if (response.result == "success") {
									alert(response.message);
									totalPrice();
/* 									$("tr[name='cartRow']").each(function(){
										$(this).remove();
									});
									$("td[name=sumPrice]").text('');
									$("#sumPrice").html('<font color="#0066CC"><b >총 합계금액</b></font> 0원<font color="#FF3333"><b></b></font>&nbsp;&nbsp');
 */								}
	
						},
						error : function(xhr, status, e) { //요청 및 응답에 실패 한 경우
							console.error(status + ":" + e);
						}
					}); 
				});
		});
	</script>
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

			<table border="0" cellpadding="0" cellspacing="0" width="747">
				<tr><td height="13"></td></tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="746">
				<tr>
					<td height="30" align="left"><img src="${pageContext.servletContext.contextPath }/assets/images/cart_title.gif" width="746" height="30" border="0"></td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="747">
				<tr><td height="13"></td></tr>
			</table>

			<table border="0" cellpadding="0" cellspacing="0" width="710" class="cmfont">
				<tr>
					<td><img src="${pageContext.servletContext.contextPath }/assets/images/cart_title1.gif" border="0"></td>
				</tr>
			</table>

			<table border="0" cellpadding="0" cellspacing="0" width="710">
				<tr><td height="10"></td></tr>
			</table>

			<table border="0" cellpadding="5" cellspacing="1" width="710" class="cmfont" bgcolor="#CCCCCC">
				<tr bgcolor="F0F0F0" height="23" class="cmfont">
					<td width="420" align="center">상품</td>
					<td width="70"  align="center">수량</td>
					<td width="80"  align="center">가격</td>
					<td width="90"  align="center">합계</td>
					<td width="50"  align="center">삭제</td>
				</tr>
				<c:set var="sum" value="0" />
				<c:forEach items="${list}" var="vo" varStatus="status">
				<tr name="cartRow">
					<form name="form2" method="post" action="">
					<td height="60" align="center" bgcolor="#FFFFFF">
						<table cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td width="60">
									<a href="product/product_detail?no=${map[vo.productNo].no}"><img src="${pageContext.servletContext.contextPath }/assets/images/product/${vo.productNo}.jpg" width="50" height="50" border="0"></a>
								</td>
								<td class="cmfont">
									<a href="product/product_detail?no=${map[vo.productNo].no}">${map[vo.productNo].title}</a><br>
									<font color="#0066CC"> </font>
								</td>
							</tr>
						</table>
					</td>
					<td align="center" bgcolor="#FFFFFF">
						<input type="text" name="num2" size="3" value="${vo.count}" class="cmfont1">&nbsp<font color="#464646">개</font>
					</td>
					<td id="${vo.productNo}_price" data-price="${map[vo.productNo].price}" align="center" bgcolor="#FFFFFF"><font color="#464646"><span class="price">${map[vo.productNo].price}</span></font></td>
					<td id="${vo.productNo}_totalPrice" data-totalPrice="${(map[vo.productNo].price)*vo.count}" align="center" bgcolor="#FFFFFF" value="${(map[vo.productNo].price)*vo.count}"><font color="#464646">${(map[vo.productNo].price)*vo.count}</font></td>
					<td align="center" bgcolor="#FFFFFF">
						<input id="${vo.productNo}"type="image" src="${pageContext.servletContext.contextPath }/assets/images/b_edit1.gif" border="0">&nbsp<br>
						<input id="${vo.productNo}"type="image" src="${pageContext.servletContext.contextPath }/assets/images/b_delete1.gif" border="0">&nbsp<br>
					</td>
					</form>
				</tr>
				<c:set var= "sum" value="${sum + (map[vo.productNo].price)*vo.count}"/>
				</c:forEach>
				
				<tr>
					<td colspan="5" bgcolor="#F0F0F0">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="cmfont">
							<tr>
								<td bgcolor="#F0F0F0"><img src="${pageContext.servletContext.contextPath }/assets/images/cart_image1.gif" border="0"></td>
								<td id="sumPrice" data-sum="${sum}" align="right" bgcolor="#F0F0F0">
									<font color="#0066CC"><b >총 합계금액</b></font> : 상품대금(<span id="total"></span>원) + 배송료(2,500원) = <font color="#FF3333"><b><span id="totalPrice"></span> 원</b></font>&nbsp;&nbsp
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table width="710" border="0" cellpadding="0" cellspacing="0" class="cmfont">
				<tr height="44">
					<td width="710" align="center" valign="middle">
						<a href="main"><img src="${pageContext.servletContext.contextPath }/assets/images/b_shopping.gif" border="0"></a>&nbsp;&nbsp;
						<a href="#"><img src="${pageContext.servletContext.contextPath }/assets/images/b_cartalldel.gif" width="103" height="26" border="0"></a>&nbsp;&nbsp;
						<a href="order"><img src="${pageContext.servletContext.contextPath }/assets/images/b_order1.gif" border="0"></a>
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