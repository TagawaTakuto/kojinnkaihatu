<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>ユーザ詳細</title>
</head>
<body>
<jsp:include page="/layout/hedder.jsp" />

<h1 class="c">ユーザ詳細</h1>
<table class="T">
	<tr>
		<td class="">ログインID:</td>
		<td class="">${UserInfo.id}</td>
	</tr>
	<tr>
		<td>　</td>
	</tr>
	<tr>
		<td class="R">ユーザ名:</td>
		<td class="">{UserInfo.name}</td>
	</tr>
	<tr>
		<td>　</td>
	</tr>
	<tr>
		<td class="R">生年月日:</td>
		<td class="">{UserInfo.birthdate}</td>
	</tr>
	<tr>
		<td>　</td>
	</tr>
	<tr>
		<td class="R">登録日時:</td>
		<td class="">{UserInfo.createdate}</td>
	</tr>
	<tr>
		<td>　</td>
	</tr>
	<tr>
		<td class="R">更新日時:</td>
		<td class="">{UserInfo.updatedate}</td>
	</tr>
</table>
<br>
<div class="c"><a class="search_btn" href="User">戻る</a>
　　　<a class="his_btn" href="UserUpdate">更新する</a></div>
</body>
</html>