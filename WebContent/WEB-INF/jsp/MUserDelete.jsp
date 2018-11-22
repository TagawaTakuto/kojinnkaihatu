<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ情報削除</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="box c">ユーザ情報削除(マスター用)</h1>
	<form action="MUserDelete" method="post">
	<input type="hidden" value="${userd.id}" name="id">
		<div class="shadow c" style="width: 500px;">
			<br>ユーザID：${userd.id} <br> <br>
			ログインID：${userd.loginId} <br> <br> ユーザ名：${userd.name} <br>
			<br>
		</div>
		<br>
		<div class="c">本当に削除してよろしいですか？</div>
		<br>
		<div class="c">
			<input class="search_btn" type="button" value="キャンセル"
				onClick="location.href='UserList.html'"> <input
				type="submit" class="del_btn" style="width: 90px; height: 32px;"
				type="button" value="　OK　">
	</form>
	</div>
</body>
</html>