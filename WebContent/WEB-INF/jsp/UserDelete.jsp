<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ情報削除</title>
</head>
<body>
	<form action="UserDelete" method="post">
		<input type="hidden" value=${LoginInfo.id} name="UserId">
		<jsp:include page="/layout/hedder.jsp" />
		<h1 class="c">ユーザ情報削除</h1>

		<div class="c">

			ログインID：${LoginInfo.loginId} <br> <br>
			ユーザ名:${LoginInfo.name} <br> <br>
		</div>
		<div class="c">本当に削除してよろしいですか？</div>
		<br>
		<div class="c">
			<input class="search_btn" type="button" value="キャンセル"
				onClick="location.href='User'"> <input class="del_btn"
				style="width: 90px; height: 32px;" type="submit" value="　OK　">
		</div>
	</form>
</body>
</html>