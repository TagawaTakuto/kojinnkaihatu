<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="box c">購入確認画面</h1>
	<div class="c">以下の内容でよろしいですか？</div>
	<br>
	<form action="BuyComplete" method="post">
	<input type="hidden" value="${LoginInfo.id}" name="userId">
	<table class="table table-striped">
		<tr>
			<th style="width: 200px;"></th>
			<th>商品画像</th>
			<th>商品名</th>
			<th>価格</th>
			<th>個数</th>
			<th>ハード</th>
			<th style="width: 200px;"></th>
		</tr>
		<c:forEach var="item" items="${BuyList}">
			<tr>
				<td style="width: 200px;"></td>
				<td class=""><img src="img/${item.fileName}"
					style="width: 100px;"></td>
				<td style="valign: middle;">${item.name}</td>
				<td class="">${item.price}円</td>
				<td class="">${item.buycount}個</td>
				<td class="">${item.hardName}</td>
				<td style="width: 200px;"></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table class="table table-striped">
		<tr>
			<th style="width: 200px;"></th>
			<th>配送方法：</th>
			<th>配送単価：</th>
			<th>合計金額：</th>
			<th style="width: 200px;"></th>
		</tr>
		<tr>
			<td style="width: 200px;"></td>
			<td>${buydata.deliveryMethodName}</td>
			<td>${buydata.deliveryMethodPrice}円</td>
			<td>${buydata.totalPrice}円</td>
			<td style="width: 200px;"></td>
		</tr>
	</table>
	<br>
	<div class="c">
		<input class="back_btn" type="button" value="修正する"
			onClick="history.back()"> <input class="buy_btn"
			type="submit" value="購入確定">
	</div>
</form>
</body>
</html>