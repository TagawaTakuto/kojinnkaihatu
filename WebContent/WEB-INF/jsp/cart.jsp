<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>カート画面</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="box c">カート画面</h1>
	<form action="buykakunin" method="post">
	<div class="c">
		<font color="red"> <c:if test="${CartMsg != null}">
				<div class="C" role="alert">${CartMsg}</div>
			</c:if></font> <br>
	</div>
		<c:forEach var="cart" items="${cart}">
			<table class="tab c">
				<tr>
					<td class="Img" rowspan="3"><img src="img/${cart.fileName}" style="width: 200px;"></td>
					<td rowspan="1" colspan="2">商品名：${cart.name}</td>
					<td rowspan="3">個数：<select name="kosuu">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select>
					</td>
					<td class="c" width="100" rowspan="3"><input class="del_btn"
						onclick="location.href='CratDel?id={cart.id}'" type="button"
						name="delete" value="削除する"></td>
				</tr>
				<tr>
					<td rowspan="1" colspan="2">価格：${cart.price}円</td>
				</tr>
				<tr class="c">
					<td rowspan="1" colspan="2">ハード：${cart.hardName}</td>
				</tr>
			</table>
			<br>
			<br>
		</c:forEach>
		<c:if test="${!empty cart}">
		<table class="table table-striped">
			<tr>
				<th class="R" style="vertical-align: middle;">配送方法：</th>
				<td><select name="haisou"
					style="font-size: 15px; height: 32px;">
						<option value="1">通常配送</option>
						<option value="2">特急配送</option>
						<option value="3">日時指定</option>
				</select>
		</table>
		<div class="c">
			<input class="buy_btn" type="submit" value="購入画面へ">
		</div>
		</c:if>
	</form>
</body>
</html>