<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>マスター商品リスト</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="box c">
		<h1>マスター商品リスト</h1>
	</div>
	<form action="MasterList" method="post">
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
		<div class="c shadow">
			<br> ハード：
			<div class="search_select">
				<input id="h_ch1" type="checkbox" name="Hard" value="1" /><label
					for="h_ch1">PC</label> <input id="h_ch2" type="checkbox"
					name="Hard" value="2" /><label for="h_ch2">PS4</label> <input
					id="h_ch3" type="checkbox" name="Hard" value="3" /><label
					for="h_ch3">Swich</label> <input id="h_ch4" type="checkbox"
					name="Hard" value="4" /><label for="h_ch4">Xbox</label>
			</div>
			<br>
		</div>
		<br>
		<div class="c shadow">
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
			並び替え： <select name="sort">
				<option value="item.id">ID昇順</option>
				<option value="item.id DESC">ID降順</option>
				<option value="sale_date">発売日昇順</option>
				<option value="sale_date DESC">発売日降順</option>
				<option value="update_date">更新日昇順</option>
				<option value="update_date DESC">更新日降順</option>
				<option value="price">価格昇順</option>
				<option value="price DESC">価格降順</option>
				<option value="stock">在庫昇順</option>
				<option value="stock DESC">在庫降順</option>
			</select>
		</div>

		<br>
		<div class="bold c">検索結果：300件</div>
		<br>
		<div class="c">
			<input class="search_btn" type="submit" value="検索">
		</div>
	</form>
	<hr>
	<br>
	<div class="c">
		<input style="width: 150px;" class="search_btn" type="button"
			value="新規登録" onclick="location.href='MasterCreate'">
	</div>
	<br>
	<c:forEach var="ItemList" items="${ItemList}">
		<table class="tab" width=”50%”>
			<tr class="c">
				<td colspan="4">商品ID:${ItemList.id}</td>
			</tr>
			<tr class="c">
				<td class="c" colspan="2">発売日:${ItemList.saleDate}</td>
				<td colspan="2">商品名：${ItemList.name}</td>
			</tr>
			<tr class="c">
				<td rowspan="2" width="150px" height="150px"><img
					src="img/${ItemList.fileName}" style="width: 150px; height: 200px;"></td>
				<td colspan="2">ハード:${ItemList.hardName}</td>
				<td rowspan="1" colspan="1">価格：${ItemList.price}円
			</tr>
			<tr class="c">
				<td colspan="2">ジャンル:？？？ ？？？</td>
				<td rowspan="1" colspan="1">在庫:${ItemList.stock}個</td>
			</tr>
			<tr>
				<td colspan="4" height="200px" valign="top">商品説明: <br>${ItemList.detail}</td>
			</tr>
			<tr>
				<td class="c" colspan="4">更新日時:${ItemList.updatedate}</td>
			<tr>
				<td colspan="2" width="50%"><input class="full search_btn"
					type="button" value="更新"
					onClick="location.href='MasterUpdate?id=${ItemList.id}'"></td>
				<td colspan="2" width="50%"><input class="full del_btn"
					type="button" value="削除"
					onClick="location.href='MasterDelete?id=${ItemList.id}'"></td>
			</tr>
		</table>
		<br>
	</c:forEach>
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