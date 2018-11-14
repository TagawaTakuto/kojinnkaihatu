
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
a {
	text-decoration: none;
}
-->
</style>
<title>ログイン画面</title>
</head>
<body>
	<div class="hedder">
		<ul style="float: left;">
			<li class="L"><a href="MasterList.html" class="Hsquare_btn">マスターリスト</a></li>
			<li class="L"><a href="UserList.html" class="Hsquare_btn">ユーザリスト</a></li>
		</ul>
		<div class="top-teisai">
			<a href="ItemList.html"  class="top">TOP</a>
		</div>
		<ul style="float: right;">
			<li><a href="cart.html" class="square_btn">カート</a></li>
			<li><a href="User.html" class="square_btn">ユーザ情報</a></li>
			<li><a href="Login.html" class="square_btn">ログイン</a></li>
		</ul>
	</div>
	<div class="box17">
		<h1 class="c">ログイン画面</h1>

		<font color="red"> <c:if test="${errMsg != null}">
				<div class="C" role="alert">${errMsg}</div>
			</c:if>
	</div>
	<div class="shadow">
		<br>
		<div class="c">
			<a href="UserCreate.html" class="new_btn">新規登録</a>
		</div>
		<br> <br>
		<form name="form1" action="Login" method="post">
			<div class="c">
				ログインID：<input class="" type="text" name="LoginId">
			</div>
			<br> <br>
			<div class="c">
				パスワード：<input class="" type="password" name="password">
			</div>

			<br> <br>
			<div class="c">
				<span><input type="submit" value="ログイン" class="login_btn"></span></a>
			</div>
		</form>
		<br> <br>

	</div>

</body>
</html>