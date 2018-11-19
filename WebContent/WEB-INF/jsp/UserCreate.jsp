<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ新規登録</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="wrapper">
		<h1 class="box17">新規登録</h1>
		<font color="red"> <c:if test="${errMsg != null}">
				<div class="C" >${errMsg}</div>
			</c:if></font> <br>
		<div class="shadow">
			<form action="UserCreate" method="post">
			<p class="txt">
				ログインID: <br> <input type="text" name="LoginId">
			</p>
			<br>
			<p class="txt">
				パスワード: <br> <input type="password" name="Password">
			</p>
			<br>
			<p class="txt">
				パスワード(確認): <br> <input type="password" name="Kpassword">
			</p>
			<br>
			<p class="txt">
				ユーザ名: <br> <input type="text" name="UserName">
			</p>
			<br>
			<p class="txt">
				生年月日: <br> <input type="date" name="BirthDate"
					style="width: 175px;">
			</p>
			<br><br>
			<p class="c">
				<input class="search_btn" type="submit" value="登録">
			</p>
			</form>
			<br>
		</div>
	</div>
</body>
</html>