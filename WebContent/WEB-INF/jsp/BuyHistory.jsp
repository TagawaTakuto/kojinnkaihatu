<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入履歴画面</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="box c">購入履歴</h1>
	<br>
	<table class="table table-striped c">
		<tr>
			<th>購入日時:${BuyHisDeli.getFormatDate()}</th>
			<th>配送方法:${BuyHisDeli.deliveryMethodName}</th>
		</tr>
	</table>
	<br>
	<table class="table table-striped">
		<tr>
			<th>商品画像</th>
			<th>商品名</th>
			<th>価格</th>
			<th>個数</th>
			<th>ハード</th>
		</tr>
		<c:forEach var="item" items="${BuyHisList}">
			<tr>
				<td class=""><img src="img/${item.fileName}"
					style="width: 100px;"></td>
				<td class="">${item.name}</td>
				<td class="">${item.price}円</td>
				<td class="">${item.buycount}個</td>
				<td class="">${item.hardName}</td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td>${BuyHisDeli.deliveryMethodName}</td>
			<td>${BuyHisDeli.deliveryMethodPrice}円</td>
			<td></td>
			<td></td>
		<tr>
			<th colspan="5" class="c">合計金額：${BuyHisDeli.totalPrice}円</th>
		</tr>

	</table>
	<br>
	<br>
	<div class="c">
		<a href="javascript:void(0);" class="his_btn" onClick="history.go(-1)">←戻る</a>
	</div>
</body>
</html>