<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />

	<div class="box c">
		<h1>ログイン画面</h1>
	</div>
	<div class="c">
		<font color="red"> <c:if test="${errMsg != null}">
				<div class="C" role="alert">${errMsg}</div>
			</c:if></font> <br>
	</div>
	<div class="shadow">
		<br>
		<div class="c">
			<a href="UserCreate" class="new_btn">新規登録</a>
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
				<a class="login_btn" href="javascript:document.form1.submit()"><span>ログイン</span></a>
			</div>
		</form>
		<br>
	</div>
</body>
</html>