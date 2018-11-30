<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>マスター商品更新</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="wrapper">
		<div class="box c">
			<h1>商品更新</h1>
		</div>
		<p class="txt">
			商品ID:001 <br>
		<div class="shadow">
			<br>
			<p class="c">
				商品名:<input type="text" value="げーむめい" name="title"> <br>
			<p class="c">
				商品画像URL:<input type="text" name="fileName" style="width: 200px;">
			<p class="txt">
				商品説明:<br>
				<textarea name="setumei" rows="6" cols="40">
	</textarea>
			<p class="c">
				発売日:<input type="date" name="saleDate" style="width: 170px;">
			<p class="c">
				単価:<input type="text" value="10,000" name="price">円 <br>
				<br> 在庫:<input type="text" value="100" name="zaiko">個 <br>
			</p>
			<br>
		</div>
		<br>
		<div class="shadow c">
			<br> ハード：
			<div class="hard_select">
				<input type="radio" name="Hard" value="1" id="h_ch1" checked /><label
					for="h_ch1">PC</label> <input type="radio" name="Hard" value="2"
					id="h_ch2" /><label for="h_ch2">PS4</label> <input type="radio"
					name="Hard" value="3" id="h_ch3" /><label for="h_ch3">Swich</label>
				<input type="radio" name="Hard" value="4" id="h_ch4" /><label
					for="h_ch4">Xbox</label>
			</div>
			<br>
		</div>
		<br>
		<div class=" shadow c">
			<br> ジャンル:
			<div class="search_select">
				<input id="j_ch1" type="checkbox" /><label for="j_ch1">アクション</label>
				<input id="j_ch2" type="checkbox" /><label for="j_ch2">RPG</label>
				<input id="j_ch3" type="checkbox" /><label for="j_ch3">格闘</label> <input
					id="j_ch4" type="checkbox" /><label for="j_ch4">シミュレーション</label> <input
					id="j_ch5" type="checkbox" /><label for="j_ch5">シューティング</label>
			</div>
			<br>
		</div>
		<br>
		<div class="c">
			<input class="search_btn" type="button"
				onclick="location.href='MasterList'" value="更新完了">
		</div>
	</div>
</body>
</html>