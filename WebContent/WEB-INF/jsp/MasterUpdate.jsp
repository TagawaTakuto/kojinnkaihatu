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
	<div class="wrapper">
		<div class="box c">
			<h1>商品更新</h1>
		</div>
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
					<input type="radio" name="Hard" value="1"
						<c:if test="${Item.hardId == 1 }"> checked = "checked" </c:if>
						id="h_ch1" /><label for="h_ch1">PC</label> <input type="radio"
						name="Hard" value="2"
						<c:if test="${Item.hardId == 2 }"> checked = "checked" </c:if>
						id="h_ch2" /><label for="h_ch2">PS4</label> <input type="radio"
						name="Hard" value="3"
						<c:if test="${Item.hardId == 3 }"> checked = "checked" </c:if>
						id="h_ch3" /><label for="h_ch3">Swich</label> <input type="radio"
						name="Hard" value="4"
						<c:if test="${Item.hardId == 4 }"> checked = "checked" </c:if>
						id="h_ch4" /><label for="h_ch4">Xbox</label>
				</div>
				<br>
			</div>
			<br>
			<div class=" shadow c">
				<br> ジャンル:
				<div class="search_select">
					<c:forEach var="GL" items="GL">
						<input type="checkbox" name="Genre" value="1"
							<c:if test="${GL == 1}"> checked = "checked" </c:if> id="j_ch1" />
						<label for="j_ch1">アクション</label>
						<input id="j_ch2" name="Genre" value="2"
							<c:if test="${GL == 2}"> checked = "checked" </c:if>
							type="checkbox" />
						<label for="j_ch2">RPG</label>
						<input id="j_ch3" name="Genre" value="3"
							<c:if test="${GL== 3}"> checked = "checked" </c:if>
							type="checkbox" />
						<label for="j_ch3">格闘</label>
						<input id="j_ch4" name="Genre" value="4"
							<c:if test="${GL==4}"> checked = "checked" </c:if>
							type="checkbox" />
						<label for="j_ch4">シミュレーション</label>
						<input id="j_ch5" name="Genre" value="5"
							<c:if test="${GL==5}"> checked = "checked" </c:if>
							type="checkbox" />
						<label for="j_ch5">シューティング</label>
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