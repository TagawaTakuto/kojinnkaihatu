<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>ユーザ情報更新(マスター用)</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="wrapper">
		<h1>ユーザ情報更新(マスター用)</h1>
		<div class="wrapper">ユーザID：${</div>
		<br>
		<p class="txt">
			ログインID: <br> <input type="text" name="UserName">
		</p>
		<br>
		<p class="txt">
			パスワード: <br> <input type="password" name="Password">
		</p>
		<br>
		<p class="txt">
			パスワード(確認用): <br> <input type="password" name="Kpassword">
		</p>
		<br>
		<p class="txt">
			ユーザ名: <br> <input type="text" name="UserName">
		</p>
		<br>
		<p class="txt">
			生年月日: <br> <input type="Date" style="width: 170px;" name="BirthDate">
		</p>
		<br>
		<div class="c">
			<input type="submit" class="his_btn" value="更新">
		</div>
		<br>
		<div class="c">
			<a class="search_btn" href="UserList">戻る</a>
		</div>
	</div>
</body>
</html>