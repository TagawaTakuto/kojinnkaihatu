<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ情報更新</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="wrapper">
		<h1>ユーザ情報更新</h1>
		<form action="UserUpdate" method="post">
		<input type="hidden" value="${LoginInfo.id}" name="userId">
			<p class="txt">
				ログインID: <br> <input type="text" value="${LoginInfo.loginId}"
					name="LoginId">
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
				ユーザ名: <br> <input type="text" value="${LoginInfo.name}"
					name="Name">
			</p>
			<br>
			<br>
			<div class="c">
				<a class="search_btn" href="User">戻る</a>　　　 <input class="his_btn"
					type="submit" value="更新">
			</div>
		</form>
	</div>
</body>
</html>