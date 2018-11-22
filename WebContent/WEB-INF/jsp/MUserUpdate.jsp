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
		<h1 class="box c">ユーザ情報更新(マスター用)</h1>
		<div class="wrapper">ユーザID：${userU.id}</div>
		<br>
		<form name="form1" action="MUserUpdate" method="post">
			<div class="shadow" style="width: 500px; margin: auto;">
				<br>
				<p class="txt">
					ログインID: <br> <input type="text" placeholder="${userU.loginId}"
						name="UserName">
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
					ユーザ名: <br> <input type="text" placeholder="${userU.name}"
						name="UserName">
				</p>
				<br>
				<p class="txt">
					生年月日: <br> <input type="Date" style="width: 170px;"
						name="BirthDate">
				</p>
				<br> <br>
			</div>
			<br> <br>
			<div class="c">
				<a class="his_btn" href="UserList">戻る</a>
				　　　<a class="his_btn"
					href="javascript:document.form1.submit()">更新</a>
			</div>
		</form>
	</div>
</body>
</html>