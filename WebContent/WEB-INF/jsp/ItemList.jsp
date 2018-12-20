<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="box c">
		<h1>商品一覧</h1>
	</div>
	<form action="ItemList" method="post">
		<div class="c">
			キーワード：<input type="text" name="Keyword" value="${Keyword}">
		</div>
		<br> <br>
		<div class="c">
			発売日：<input type="date" name="Sdate" value="${Sdate}"> ～ <input
				type="date" name="Edate" value="${Edate}">
		</div>
		<br>
		<div class="shadow c">
			<br> ハード：
			<div class="search_select">
				<c:forEach var="HL" items="${HL}">
					<input type="checkbox" name="Hard" value="${HL.id}"
						<c:if test="${HL.id == HL.comparisonId}"> checked = "checked" </c:if>
						id="h&${HL.id}" />
					<label for="h&${HL.id}">${HL.name}</label>
				</c:forEach>
			</div>
			<br>
		</div>
		<br>
		<div class="shadow c">
			<br> ジャンル:
			<div class="search_select">
				<c:forEach var="GL" items="${GL}">
					<input type="checkbox" name="Genre" value="${GL.id}"
						<c:if test="${GL.id == GL.comparisonId}"> checked = "checked" </c:if>
						id="g&${GL.id}" />
					<label for="g&${GL.id}">${GL.name}</label>
				</c:forEach>
			</div>
			<br>
		</div>
		<br>
		<div class="c">
			並び替え： <select name="sort">
				<option value="sale_date">発売日昇順</option>
				<option value="sale_date DESC">発売日降順</option>
				<option value="price">価格昇順</option>
				<option value="price DESC">価格降順</option>
				<option value="stock">在庫昇順</option>
				<option value="stock DESC">在庫降順</option>
			</select>
		</div>
		<br>
		<div class="bold c">検索結果：${ItemList.size()}件</div>
		<br>
		<div class="c">
			<input class="search_btn" type="submit" value="検索">
		</div>
	</form>
	<hr>
	<div class="c red big bold">
		<br> ${Mess} <br> <br>
	</div>
	<div class="left" style="width: 65px; height: 700px;"></div>
	<c:forEach var="Item" end="7" items="${ItemList}">
		<form action="Easybuy?id=${Item.id}" method="post">
			<input type="hidden" value="${Item.id}" name="id">
			<div class="c left shadow">
				<br> <a href="ItemData?id=${Item.id}"><img
					src="img/${Item.fileName}" style="width: 250px; height: 300px;"></a>
				<br>
				<p>${Item.name}</p>
				<p>発売日:${Item.getSaleFormatDate()}</p>
				<p>値段:${Item.price}円</p>
				<p>ハード:${Item.hardName}</p>
				<p>在庫数:${Item.stock}個</p>
				<br>
				<c:if test="${Item.stock == 0}">
					売り切れ
				</c:if>
				<c:if test="${Item.stock != 0}">
					<select name="buycount">
						<c:forEach begin="0" end="${Item.stock - 1}" varStatus="count">
							<option value="<c:out value="${count.count}"/>"><c:out
									value="${count.count}" /></option>
						</c:forEach>
					</select>個 <input type="submit" value="カートに追加" class="buy_btn">
					<br>
				</c:if>
				<br>
			</div>
		</form>
	</c:forEach>
	<br>
	<br>
	<div class="pager center C" style="clear: both;">
		<ul>
		<c:choose>
		<c:when test="${pageNum == 1}">
			<li><span>&laquo; 前</span></li>
			</c:when>
			<c:otherwise>
			<li><a href="ItemList?page_num=${pageNum - 1}">&laquo; 前</a></li>
			</c:otherwise>
			</c:choose>
			<c:forEach varStatus="i" begin="0" end="${pageMax}">
				<li><a href="1.html"><c:out value="${i.count}" /></a></li>
			</c:forEach>
			<c:choose>
			<c:when test="${pageNum == pageMax || pageMax == 0}">
			<li><span>次 &raquo;</span></li>
		</c:when>
		<c:otherwise>
		<li><a href="ItemList?page_num=${pageNum + 1}">次 &raquo;</a></li>
		</c:otherwise>
		</c:choose>
		</ul>
	</div>
</body>
</html>