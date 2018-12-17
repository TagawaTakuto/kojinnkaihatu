<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function goServletA() {
		document.getElementById('form').action = "CartDelete";
	}
	function goServletB() {
		document.getElementById('form').action = "BuyConfirm";
	}
</script>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>カート画面</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="box c">カート画面</h1>
	<div class="c red big bold">${Mess}</div>
	<div class="c">
		<font color="red"> <c:if test="${CartMsg != null}">
				<div class="c red big bold">${CartMsg}</div>
			</c:if></font> <br>
	</div>
	<form id='form' name='form' method="post" action="">
	<input type="hidden" name="userId" value="${LoginInfo.id}">
		<c:forEach var="cart" items="${cart}">
			<input type="hidden" name="id" value="${cart.id}">
			<table class="tab c">
				<tr>
					<td class="Img" rowspan="3" style="padding-top: 7px;"><img
						src="img/${cart.fileName}" style="width: 200px;"></td>
					<td rowspan="1" colspan="2">商品名：${cart.name}</td>
					<td rowspan="3">個数：<select name="count">
							<option value="1"
								<c:if test="${cart.buycount == 1}">selected</c:if>>1</option>
							<option value="2"
								<c:if test="${cart.buycount == 2}">selected</c:if>>2</option>
							<option value="3"
								<c:if test="${cart.buycount == 3}">selected</c:if>>3</option>
							<option value="4"
								<c:if test="${cart.buycount == 4}">selected</c:if>>4</option>
							<option value="5"
								<c:if test="${cart.buycount == 5}">selected</c:if>>5</option>
					</select>
					</td>
					<td class="c" width="100" rowspan="3"><div class="boxes">
							<input type="checkbox" name="del_list" value="${cart.id}"
								id="${cart.id}"> <label for="${cart.id}"></label>
						</div>
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
			<div class="c">
				<input class="del_btn" type="submit" value="　削除　"
					onclick="goServletA();">
			</div>
			<br>
			<table class="table table-striped">
				<tr>
					<th class="R" style="vertical-align: middle;">配送方法：</th>
					<td><select name="delivery"
						style="font-size: 15px; height: 32px;">
							<option value="1">通常配送</option>
							<option value="2">特急配送</option>
							<option value="3">日時指定</option>
					</select>
			</table>
			<div class="c">
				<input class="buy_btn" type="submit" value="購入画面へ"
					onclick="goServletB();">
			</div>
		</c:if>
	</form>
</body>
</html>