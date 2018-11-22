<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="box c">
	<h1>商品一覧</h1>
	</div>
	<form action="ItemList" method="post">
	<div class="c">
		キーワード：<input type="text" name="Keyword">
	</div>
	<br>
	<br>
	<div class="c">
		発売日：<input type="date" name="Sdate"> ～ <input type="date"
			name="Edate">
	</div>
	<br>
	<div class="shadow c">
		<br> ハード：
		<div class="search_select">
			<input id="h_ch1" type="checkbox" name="Hard" value="1"/><label for="h_ch1">PC</label> <input
				id="h_ch2" type="checkbox" name="Hard" value="2"/><label for="h_ch2">PS4</label> <input
				id="h_ch3" type="checkbox" name="Hard" value="3"/><label for="h_ch3">Swich</label> <input
				id="h_ch4" type="checkbox" name="Hard" value="4"/><label for="h_ch4">Xbox</label>
		</div>
		<br>
	</div>
	<br>
	<div class="shadow c">
		<br> ジャンル:
		<div class="search_select">
			<input id="g_ch1" type="checkbox" name="Genre" value="1"/><label for="g_ch1">アクション</label>
			<input id="g_ch2" type="checkbox" name="Genre" value="2"/><label for="g_ch2">RPG</label> <input
				id="g_ch3" type="checkbox" name="Genre" value="3"/><label for="g_ch3">格闘</label> <input
				id="g_ch4" type="checkbox" name="Genre" value="4"/><label for="g_ch4">シミュレーション</label> <input
				id="g_ch5" type="checkbox" name="Genre" value="5"/><label for="g_ch5">シューティング</label>
		</div>
		<br>
	</div>
	<br>
	<div class="c">
		並び替え： <select name="sort">
			<option value="sale_date">発売日昇順</option>
			<option value="sale_date DESC">発売日降順</option>
			<option value="price">価格昇順</option>
			<option value="price DESC">価格降順</option>
			<option value="stock">在庫昇順</option>
			<option value="stock DESC">在庫降順</option>
		</select>
	</div>
	<br>
	<div class="bold c">検索結果：${page}件</div>
	<br>
	<div class="c">
		<input class="search_btn" type="submit" value="検索">
	</div>
	</form>
	<hr>
	<div class="c red big bold">
		<br> ${Mess} <br> <br>
	</div>
	<table class="T c">
		<tr>
			<td class="Img cell" colspan="2"><a href="ItemData.html">商品画像1</a></td>
			<td colspan="1">　　</td>
			<td class="cell Img" colspan="2"><a href="ItemData.html">商品画像2</a></td>
			<td colspan="1">　　</td>
			<td class="cell Img" colspan="2"><a href="ItemData.html">商品画像3</a></td>
			<td colspan="1">　　</td>
			<td class="cell Img" colspan="2"><a href="ItemData.html">商品画像4</a></td>
		</tr>
		<tr>
			<td class="cell" colspan="1">値段:${Item.price}円</td>
			<td class="cell" colspan="1">在庫数:${Item.stock}個</td>
			<td colspan="1"></td>
			<td class="cell" colspan="1">値段:2000円</td>
			<td class="cell" colspan="1">在庫数:2個</td>
			<td colspan="1"></td>
			<td class="cell" colspan="1">値段:3000円</td>
			<td class="cell" colspan="1">在庫数:3個</td>
			<td colspan="1"></td>
			<td class="cell" colspan="1">値段:4000円</td>
			<td class="cell" colspan="1">在庫数:4個</td>
		</tr>
		<tr>
			<td class="cell c" colspan="2">ハード:<select name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			<td colspan="1"></td>
			<td class="cell c" colspan="2">ハード:<select name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			<td colspan="1"></td>
			<td class="cell c" colspan="2">ハード:<select name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			<td colspan="1"></td>
			<td class="cell c" colspan="2">ハード:<select form="Item4" name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			</td>
		</tr>

		<tr>
			<td class="cell c" colspan="2">売り切れ
			<td colspan="1"></td>
			<td class="cell c" colspan="2"><select name="buycount">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select>個 <input type="button" value="カートに追加" class="buy_btn"></td>
			<td colspan="1"></td>
			<td class="cell c" colspan="2"><select name="buycount">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select>個 <input type="button" value="カートに追加" class="buy_btn">
			<td colspan="1"></td>
			<td class="cell c" colspan="2"><form action="Easybuy"
					method="post">
					<select name="buycount">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>個 <input id="Item4" type="submit" value="カートに追加" class="buy_btn">
				</form></td>
		</tr>
	</table>
	<br>
	<br>
	<table class="T c">
		<tr>
			<td class="cell Img" colspan="2"><a href="ItemData">商品画像5</a></td>
			<td colspan="1">　　</td>
			<td class="cell Img" colspan="2"><a href="ItemData.html">商品画像6</a></td>
			<td colspan="1">　　</td>
			<td class="cell Img" colspan="2"><a href="ItemData.html">商品画像7</a></td>
			<td colspan="1">　　</td>
			<td class="cell Img" colspan="2"><a href="ItemData.html">商品画像8</a></td>
		</tr>
		<tr>
			<td class="cell" colspan="1">値段:1000円</td>
			<td class="cell" colspan="1">在庫数:1個</td>
			<td colspan="1"></td>
			<td class="cell" colspan="1">値段:2000円</td>
			<td class="cell" colspan="1">在庫数:2個</td>
			<td colspan="1"></td>
			<td class="cell" colspan="1">値段:3000円</td>
			<td class="cell" colspan="1">在庫数:3個</td>
			<td colspan="1"></td>
			<td class="cell" colspan="1">値段:4000円</td>
			<td class="cell" colspan="1">在庫数:4個</td>
		</tr>
		<tr>
			<td class="cell c" colspan="2">ハード:<select name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			<td colspan="1"></td>
			<td class="cell c" colspan="2">ハード:<select name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			<td colspan="1"></td>
			<td class="cell c" colspan="2">ハード:<select name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			<td colspan="1"></td>
			<td class="cell c" colspan="2">ハード:<select name="hard_select">
					<option value="1">PC</option>
					<option value="2">PS4</option>
					<option value="3">Swich</option>
					<option value="4">Xbox</option>
			</select>
			</td>
		</tr>
		<tr>
			<td class="cell c" colspan="2"><select name="buycount">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select>個 <input type="button" value="カートに追加" class="buy_btn">
			<td colspan="1"></td>
			<td class="cell c" colspan="2"><select name="buycount">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select>個 <input type="button" value="カートに追加" class="buy_btn">
			<td colspan="1"></td>
			<td class="cell c" colspan="2"><select name="buycount">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select>個 <input type="button" value="カートに追加" class="buy_btn">
			<td colspan="1"></td>
			<td class="cell c" colspan="2"><select name="buycount">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select>個 <input type="button" value="カートに追加" class="buy_btn"></td>
		</tr>
	</table>
	<br>
	<div class="pager C">
		<ul>
			<li><a href="1.html">&laquo; 前</a></li>
			<li><a href="1.html">1</a></li>
			<li><span>2</span></li>
			<li><a href="3.html">3</a></li>
			<li><a href="4.html">4</a></li>
			<li><a href="5.html">5</a></li>
			<li><a href="6.html">6</a></li>
			<li><a href="3.html">次 &raquo;</a></li>
		</ul>
	</div>
</body>
</html>