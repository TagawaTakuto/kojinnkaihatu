<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>商品情報</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<br>
	<div>
		<h1 class="c box">商品詳細</h1>
		<form action="Cart" method="post">
			<input type="hidden" value="${itemd.id}" name="id">
			<table class="tab">
				<tr>
					<td colspan="3" class="c">商品名：${itemd.name}
				<tr>
					<td rowspan="4"><img src="img/${itemd.fileName}"
						style="width: 100%;"></td>
					<td colspan="2" class="c">価格：${itemd.price}円</td>
				</tr>
				<tr>
					<td colspan="2" class="c">在庫：${itemd.stock}個</td>
				</tr>
				<tr>
					<td colspan="2" class="c">ハード：${itemd.hardName}</td>
				</tr>
				<tr>
					<td colspan="2" class="c">ジャンル：<c:forEach var="GL"
							items="${GL}">${GL}　</c:forEach></td>
				</tr>
				<tr>
					<td class="L" colspan="3" height="200" valign="top">商品説明： <br>${itemd.detail}</td>
				</tr>
			</table>
			<br>
			<c:if test="${itemd.stock == 0}">
				<p class="c red big bold">品切れ中
			</c:if>
			<c:if test="${itemd.stock != 0}">
				<div class="c">
					購入数：<select name="buycount">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 個 <input class="buy_btn" type="submit" value="カートに追加"">
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>