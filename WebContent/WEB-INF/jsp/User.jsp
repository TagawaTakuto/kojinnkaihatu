<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザページ</title>
</head>
<body>
<input type="hidden" value="${LoginInfo.id}" name="UserId">
<jsp:include page="/layout/hedder.jsp" />
<div class="box17">
<h1 class="c">ユーザページ</h1>
</div>
<br>
<div class="c">
	<a href="UserUpdate" class="Bbtn">更新</a>
	<a href="UserData" class="Gbtn">詳細</a>
	<a href="UserDelete" class="Rbtn">削除</a>
</div>
<br>
<br>
<table width="50%" class="table table-striped">
		<tr>
			<th>
			<th>購入日時</th>
			<th>商品名</th>
			<th>合計金額</th>
			<th>配送方法</th>

		</tr>
		<tr>
			<td><a href="buyhistory" class="his_btn">詳細→</a></td>
			<td class="">20XX年XX月XX日</td>
			<td class="">あああああああああああ</td>
			<td class="">１１１１円</td>
			<td class="">通常配送</td>
		</tr>
		<tr>
			<td><a href="buyhistory" class="his_btn">詳細→</a></td>
			<td class="">20XX年XX月XX日</td>
			<td class="">いいいいいいいいいいいiii</td>
			<td class="">２２２２２円</td>
			<td class="">日時指定</td>
		</tr>
		<tr>
			<td><a href="buyhistory" class="his_btn">詳細→</a></td>
			<td class="">20XX年XX月XX日</td>
			<td class="">うううううううううううう</td>
			<td class="">３３３３円</td>
			<td class="">特急配送</td>
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