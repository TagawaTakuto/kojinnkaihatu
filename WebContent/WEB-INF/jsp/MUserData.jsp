<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>ユーザ詳細(マスター用)</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="box c">ユーザ詳細(マスター用)</h1>
	<div class="shadow" style="width: 500px; margin: auto;">
	<br>
		<table class="T">
			<tr>
				<td class="R">ユーザID:</td>
				<td class="">${userd.id}</td>
			</tr>
			<tr>
				<td>　</td>
			</tr>
			<tr>
				<td class="R">ログインID:</td>
				<td class="">${userd.loginId}</td>
			</tr>
			<tr>
				<td>　</td>
			</tr>
			<tr>
				<td class="R">ユーザ名:</td>
				<td class="">${userd.name}</td>
			</tr>
			<tr>
				<td>　</td>
			</tr>
			<tr>
				<td class="R">生年月日:</td>
				<td class="">${userd.getBirthFormatDate()}</td>
			</tr>
			<tr>
				<td>　</td>
			</tr>
			<tr>
				<td class="R">登録日時:</td>
				<td class="">${userd.getCreateFormatDate()}</td>
			</tr>
			<tr>
				<td>　</td>
			</tr>
			<tr>
				<td class="R">更新日時:</td>
				<td class="">${userd.getUpdateFormatDate()}</td>
			</tr>
		</table>
		<br>
	</div>
	<br>
	<div class="c">
		<a class="his_btn" href="UserList">戻る</a>　　　 <a class="his_btn"
			href="MUserUpdate?id=${userd.id}">更新する</a>
	</div>
</body>
</html>