<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>マスター商品更新</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />

		<div class="box c">
			<h1>商品更新</h1>
		</div>
		<div class="wrapper">
		<form action="MasterUpdate" method="post">
			<p class="txt">
				商品ID:${Item.id}<br> <input type="hidden" value="${Item.id}"
					name="id">
			<div class="shadow">
				<br>
				<p class="c">
					商品名:<input type="text" value="${Item.name}" name="title"> <br>
				<p class="c">
					商品画像ファイル名:<input type="text" name="fileName"
						value="${Item.fileName}" style="width: 200px;">
				<p class="txt">
					商品説明:<br>
					<textarea name="setumei" rows="6" cols="40">${Item.detail}
	</textarea>
				<p class="c">
					発売日:<input type="date" name="saleDate" value="${Item.saleDate}"
						style="width: 170px;">
				<p class="c">
					単価:<input type="text" value="${Item.price}" name="price">円
					<br> <br> 在庫:<input type="text" value="${Item.stock}"
						name="zaiko">個 <br>
				</p>
				<br>
			</div>
			<br>
			<div class="shadow c">
				<br> ハード：
				<div class="hard_select">
					<c:forEach var="hard" items="${HL}">
						<input type="radio" name="Hard" value="${hard.id}"
							<c:if test="${Item.hardId == hard.id}"> checked = "checked" </c:if>
							id="h&${hard.id}" />
						<label for="h&${hard.id}">${hard.name}</label>
					</c:forEach>
				</div>
				<br>
			</div>
			<br>
			<div class=" shadow c">
				<br> ジャンル:
				<div class="search_select">
					<c:forEach var="GL" items="${GL}">
						<input type="checkbox" name="Genre" value="${GL.hikakuId}"
							<c:if test="${GL.genreId == GL.hikakuId}"> checked = "checked" </c:if>
							id="g&${GL.hikakuId}" />
						<label for="g&${GL.hikakuId}">${GL.name}</label>
					</c:forEach>
				</div>
				<br>
			</div>
			<br>
			<div class="c">
				<input class="search_btn" type="submit" value="更新完了">
			</div>
		</form>
	</div>
</body>
</html>