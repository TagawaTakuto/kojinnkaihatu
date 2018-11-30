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
		<form action="MasterList" method="post">
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
			<option value="id">ID昇順</option>
			<option value="id DESC">ID降順</option>
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
		</form>
	</div>
	<hr>
	<br>
	<div class="c">
		<input style="width: 150px;" class="search_btn" type="button"
			value="新規登録" onclick="location.href='MasterCreate'">
	</div>

	<br>
	<table class="tab" width=”50%”>
		<tr class="c">
			<td colspan="4">商品ID:0001</td>
		</tr>
		<tr class="c">
			<td class="c" colspan="2">発売日:20XX年XX月XX日</td>
			<td colspan="2">商品名：タイトル１</td>
		</tr>
		<tr class="c">
			<td rowspan="2" width="150px" height="150px">商品画像１</td>
			<td colspan="2">ハード:？？？</td>
			<td rowspan="1" colspam="1">価格：1111円
		</tr>
		<tr class="c">
			<td colspan="2">ジャンル:？？？ ？？？</td>
			<td rowspan="1" colspan="1">在庫:10個</td>
		</tr>
		<tr>
			<td colspan="4" height="200px" valign="top">商品説明: <br>ああああああああああああああああああああああああああああああああああああああああああああ
			</td>
		</tr>
		<tr>
			<td class="c" colspan="4">更新日時:20NN年NN月NN日</td>
		<tr>
			<td colspan="2" width="50%"><input class="full search_btn"
				type="button" value="更新" onClick="location.href='MasterUpdate'"></td>
			<td colspan="2" width="50%"><input class="full del_btn"
				type="button" value="削除" onClick="location.href='MasterDelete'"></td>
		</tr>
	</table>

	<br>
	<br>
	<table class="tab" width=”50%”>
		<tr class="c">
			<td colspan="4">商品ID:0002</td>
		</tr>
		<tr class="c">
			<td class="c" colspan="2">発売日:20XX年XX月XX日</td>
			<td colspan="2">商品名：タイトル２</td>
		</tr>
		<tr class="c">
			<td rowspan="2" width="150px" height="150px">商品画像２</td>
			<td colspan="2">ハード:？？？</td>
			<td rowspan="1" colspan="1">価格：2222円
		</tr>
		<tr class="c">
			<td colspan="2">ジャンル:？？？ ？？？</td>
			<td rowspan="1" colspan="1">在庫:20個</td>
		</tr>
		<tr>
			<td colspan="4" height="200px" valign="top">商品説明: <br>ああああああああああああああああああああああああああああああああああああああああああああ
			</td>
		</tr>
		<tr>
			<td class="c" colspan="4">更新日時:20NN年NN月NN日</td>
		<tr>
			<td colspan="2" width="50%"><input class="full search_btn"
				type="button" value="更新" onClick="location.href='MasterUpdate'"></td>
			<td colspan="2" width="50%"><input class="full del_btn"
				type="button" value="削除" onClick="location.href='MasterDelete'"></td>
		</tr>
	</table>
	<br>
	<br>
	<table class="tab" width=”50%”>
		<tr class="c">
			<td colspan="4">商品ID:0003</td>
		</tr>
		<tr class="c">
			<td class="c" colspan="2">発売日:20XX年XX月XX日</td>
			<td colspan="2">商品名：タイトル３</td>
		</tr>
		<tr class="c">
			<td rowspan="2" width="150px" height="150px">商品画像３</td>
			<td colspan="2">ハード:？？？</td>
			<td rowspan="1" colspan="1">価格：3333円
		</tr>
		<tr class="c">
			<td colspan="2">ジャンル:？？？ ？？？</td>
			<td rowspan="1" colspan="1">在庫:30個</td>
		</tr>
		<tr>
			<td colspan="4" height="200px" valign="top">商品説明: <br>ああああああああああああああああああああああああああああああああああああああああああああ
			</td>
		</tr>
		<tr>
			<td class="c" colspan="4">更新日時:20NN年NN月NN日</td>
		<tr>
			<td colspan="2" width="50%"><input class="full search_btn"
				type="button" value="更新" onClick="location.href='MasterUpdate.html'"></td>
			<td colspan="2" width="50%"><input class="full del_btn"
				type="button" value="削除" onClick="location.href='MasterDelete.html'"></td>
		</tr>
	</table>
	<br>
	<table class="tab" width=”50%”>
		<tr class="c">
			<td colspan="4">商品ID:0004</td>
		</tr>
		<tr class="c">
			<td colspan="2">発売日:20XX年XX月XX日</td>
			<td colspan="2">商品名：タイトル４</td>
		</tr>
		<tr class="c">
			<td rowspan="2" width="150px" height="150px">商品画像３</td>
			<td colspan="2">ハード:？？？</td>
			<td rowspan="1" colspam="1">価格：4444円
		</tr>
		<tr class="c">
			<td colspan="2">ジャンル:？？？ ？？？</td>
			<td rowspan="1" colspan="1">在庫:30個</td>
		</tr>
		<tr>
			<td colspan="4" height="200px" valign="top">商品説明: <br>ああああああああああああああああああああああああああああああああああああああああああああ
			</td>
		</tr>
		<tr>
			<td class="c" colspan="4">更新日時:20NN年NN月NN日</td>
		<tr>
			<td colspan="2" width="50%"><input class="full search_btn"
				type="button" value="更新" onClick="location.href='MasterUpdate.html'"></td>
			<td colspan="2" width="50%"><input class="full search_btn"
				type="button" value="削除" onClick="location.href='MasterDelete.html'"></td>
		</tr>
	</table>
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