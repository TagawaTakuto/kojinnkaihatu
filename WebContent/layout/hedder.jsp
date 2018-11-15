<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>ヘッダー</title>
</head>
<body>
	<!-- ▼▼/layout/hedder.htmlの内容▼▼ -->
	<div class="hedder">
		<ul style="float: left;margin-top: 16px;">
			<li class="L"><a href="MasterList.html" class="Hsquare_btn">マスターリスト</a></li>
			<li class="L"><a href="UserList.html" class="Hsquare_btn">ユーザリスト</a></li>
		</ul>
		<div class="top-teisai">
			<a href="ItemList" class="top">TOP</a>
		</div>
		<ul style="float: right;margin-top: 16px;">
			<li><a href="cart.html" class="square_btn">カート</a></li>
			<li><a href="User" class="square_btn">ユーザ情報</a></li>
			<li><c:if test="${empty userInfo}">
					<a href="Login" class="square_btn">ログイン</a>
				</c:if>
				<c:if test="${not empty userInfo}">
					<a href="Logout" class="square_btn">ログアウト</a>
				</c:if></li>
		</ul>
	</div>
	<!-- ▲▲/layout/hedder.htmlの内容▲▲ -->
</body>
</html>