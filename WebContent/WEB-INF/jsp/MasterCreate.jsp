<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>マスター商品登録</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="wrapper">
		<div class="box c">
			<h1>商品登録</h1>
		</div>
		<form action="MasterCreate" method="post">
			<div class="shadow">
				<br>
				<p class="c">
					商品名:<input type="text" value="" name="title"> <br>
				<p class="c">
					商品画像ファイル名: <input type="text" name="fileName" style="width: 200px;">
				<p class="txt">
					商品説明: <br>
					<textarea name="setumei" rows="6" cols="40"></textarea>
				<p class="c">
					発売日:<input type="date" name="saleDate" style="width: 170px;">
				<p class="c">
					単価:<input type="text" name="price">円 <br> <br>
					在庫:<input type="text" name="zaiko">個 <br>
				</p>
				<br>
			</div>

			<br>
			<div class="shadow c">
				<br> ハード:
				<div class="hard_select">
					<input type="radio" name="hard_select" name="Hard" value="1"
						id="h_ch1" /><label for="h_ch1">PC</label> <input type="radio"
						name="Hard" value="2" id="h_ch2" /><label for="h_ch2">PS4</label>
					<input type="radio" name="Hard" value="3" id="h_ch3" /><label
						for="h_ch3">Swich</label> <input type="radio" name="Hard"
						value="4" id="h_ch4" /><label for="h_ch4">Xbox</label>
				</div>
				<br>
			</div>
			<br>
			<div class="shadow c">
				<br> ジャンル:
				<div class="search_select">
					<input id="j_ch1" type="checkbox" name="Genre" value="1" /><label
						for="j_ch1">アクション</label> <input id="j_ch2" type="checkbox"
						name="Genre" value="2" /><label for="j_ch2">RPG</label> <input
						id="j_ch3" type="checkbox" name="Genre" value="3" /><label
						for="j_ch3">格闘</label> <input id="j_ch4" type="checkbox"
						name="Genre" value="4" /><label for="j_ch4">シミュレーション</label> <input
						id="j_ch5" type="checkbox" name="Genre" value="5" /><label
						for="j_ch5">シューティング</label>
				</div>
				<br>
			</div>
			<br>
			<div class="c">
				<input class="search_btn" type="submit" value="登録">
			</div>
		</form>
	</div>
</body>
</html>