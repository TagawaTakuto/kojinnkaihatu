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
		<input class="back_btn" type="button" value="引き続き買い物する" onClick="location.href='ItemList.html'">
		　　　<input class="buy_btn" type="button" value="ユーザ情報へ" onClick="location.href='User.html'">
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
		<tr>
			<td class="">商品画像１</td>
			<td class="">あああああああああああ</td>
			<td class="">１１１１円</td>
			<td class="">１個</td>
			<td class="">？？？</td>
		</tr>
		<tr>
			<td class="">商品画像２</td>
			<td class="">いいいいいいいいいiii</td>
			<td class="">２２２２２円</td>
			<td class="">２個</td>
			<td class="">？？？</td>
		</tr>
		<tr>
			<td class="">商品画像３</td>
			<td class="">うううううううううううう</td>
			<td class="">３３３３円</td>
			<td class="">３個</td>
			<td class="">？？？</td>
		</tr>
	</table>
	<br>
	<table class="table table-striped">
		<tr>
			<th>配送方法：</th>
			<th>配送単価：</th>
			<th>合計金額：</th>
		</tr>
		<tr>
			<td>通常配送</td>
			<td>２００円</td>
			<td>１２３４５６円</td>
		</tr>
	</table>
</body>
</html>