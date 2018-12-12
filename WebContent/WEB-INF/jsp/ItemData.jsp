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
		<form action="cart" method="post">
		<input type="hidden" value="${item.id}" name="Id">
		<table class="tab">
			<tr>
				<td colspan="3" class="c">商品名：${itemd.name}
			<tr>
				<td rowspan="4" align="center" valign="middle"><img src="img/${itemd.fileName}" style="width: 250px;"></td>
				<td colspan="2">価格：${itemd.price}円</td>
			</tr>
			<tr>
				<td colspan="1">在庫：${itemd.stock}個</td>
				<td colspan="1">購入数：<select name="buycount">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select> 個
				</td>
			</tr>
			<tr>
				<td colspan="2">ハード：${itemd.hardName}
				</td>
			</tr>
			<tr>
				<td colspan="2">ジャンル：<c:forEach var="GL" items="${GL}">${GL}　</c:forEach></td>
			</tr>
			<tr>
				<td class="L" colspan="3" height="200" valign="top">商品説明： <br>${Item.detail}</td>
			</tr>
		</table>
		<br>
		<div class="c">
			<input class="buy_btn" type="submit" value="カートに追加"">
		</div>
	</form>
	</div>
</body>
</html>