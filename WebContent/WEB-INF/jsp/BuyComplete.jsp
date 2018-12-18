<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>購完了画面</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="c">購入完了</h1>
	<div class="c">購入が完了しました</div>
	<br>
	<div class="c">
		<input class="back_btn" type="button" value="引き続き買い物する" onClick="location.href='ItemList'">
		　　　<input class="buy_btn" type="button" value="ユーザ情報へ" onClick="location.href='User'">
	</div>
	<br>
	<div class="c">
	<h3>購入詳細</h3>
	</div>
	<table class="table table-striped">
		<tr>
			<th>商品画像</th>
			<th>商品名</th>
			<th>価格</th>
			<th>個数</th>
			<th>ハード</th>
		</tr>
		<c:forEach var="buy" items="${buyIDBList}">
		<tr>
			<td class=""><img
						src="img/${buy.fileName}" style="width: 100px;"></td>
			<td class="">${buy.name}</td>
			<td class="">${buy.price}円</td>
			<td class="">${buy.buycount}個</td>
			<td class="">${buy.hardName}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<table class="table table-striped">
		<tr>
			<th>配送方法：</th>
			<th>配送単価：</th>
			<th>合計金額：</th>
		</tr>
		<tr>
			<td>${BuyResult.deliveryMethodName}</td>
			<td>${BuyResult.deliveryMethodPrice}円</td>
			<td>${BuyResult.totalPrice}円</td>
		</tr>
	</table>
</body>
</html>