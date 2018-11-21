<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ一覧</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="c">ユーザ一覧</h1>

	<table class="tab c">
		<form action="UserList" method="post">
			<div class="c">
				ログインID<input type="text" name="loginId">
			</div>
			<br>
			<div class="c">
				ユーザ名<input type="text" name="userName">
			</div>
			<br>
			<div class="c">
				生年月日<input type="Date" name="birthDateS">～<input type="Date"
					name="birthDateE">
			</div>
			<br>
			<div class="c">
				<input class="search_btn" type="submit" value="検索">
			</div>
		</form>
		<hr>
		<tr class="tab">
			<th>ユーザID</th>
			<th>ログインID</th>
			<th>ユーザ名</th>
			<th>生年月日</th>
			<th></th>
		</tr>
		<c:forEach var="user" items="${UserList}">
			<br>
			<tr class="c">
				<td>${user.id}</td>
				<td>${user.login_id}</td>
				<td>${user.name}</td>
				<td>${user.birth_date}</td>
				<td class="c"><input class="ao" type="button" value="詳細"
					onClick="location.href='MUserData?id=${user.id}'"> <input
					class="midori" type="button" value="更新"
					onClick="location.href='MUserUpdate?id=${user.id}'"> <input
					class="aka" type="button" value="削除"
					onClick="location.href='MUserDelete?id=${user.id}'"></td>
			</tr>
		</c:forEach>
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