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
	<h1 class="box c">ユーザ一覧</h1>
	<table class="tab c">
		<form action="UserList" method="post">
			<div class="c">
				ログインID<input type="text" name="loginId" value="${loginId}">
			</div>
			<br>
			<div class="c">
				ユーザ名<input type="text" name="userName" value="${userName}">
			</div>
			<br>
			<div class="c">
				生年月日<input type="Date" name="birthDateS" value="${birthDateS}">～<input type="Date"
					name="birthDateE" value="${birthDateE}">
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
		<c:forEach var="user" items="${UserList}" end="3">
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
	<c:if test="${!UserList.isEmpty()}">
		<div class="pager center C" style="clear: both;">
			<ul>
				<c:choose>
					<c:when test="${pageNum == 1}">
						<li><span>&laquo; 前</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="UserList?page_num=${pageNum - 1}">&laquo; 前</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach varStatus="i" begin="0"
					end="${pageMax == 0 ? pageMax : pageMax - 1}">
					<c:choose>
						<c:when test="${pageNum != i.count}">
							<li><a href="UserList?page_num=${i.count}"><c:out
										value="${i.count}" /></a></li>
						</c:when>
						<c:otherwise>
							<li><span><c:out value="${i.count}" /></span></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${pageNum == pageMax || pageMax == 0}">
						<li><span>次 &raquo;</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="UserList?page_num=${pageNum + 1}">次 &raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>
</body>
</html>