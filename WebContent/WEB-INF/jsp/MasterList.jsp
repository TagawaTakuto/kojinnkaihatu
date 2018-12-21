<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>マスター商品リスト</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<div class="box c">
		<h1>マスター商品リスト</h1>
	</div>
	<form action="MasterList" method="post">
		<div class="c">
			キーワード：<input type="text" name="Keyword" value="${Keyword}">
		</div>
		<br> <br>
		<div class="c">
			発売日：<input type="date" name="Sdate" value="${Sdate}"> ～ <input
				type="date" name="Edate" value="${Edate}">
		</div>
		<br>
		<div class="c shadow">
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
		<div class="c shadow">
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
				<option value="sale_date DESC">発売日降順</option>
				<option value="sale_date">発売日昇順</option>
				<option value="price DESC">価格降順</option>
				<option value="price">価格昇順</option>
				<option value="stock DESC">在庫降順</option>
				<option value="stock">在庫昇順</option>
				<option value="item.id DESC">ID降順</option>
				<option value="item.id">ID昇順</option>
				<option value="update_date DESC">更新日降順</option>
				<option value="update_date">更新日昇順</option>



			</select>
		</div>

		<br>
		<div class="bold c">検索結果：${AllList.size()}件</div>
		<br>
		<div class="c">
			<input class="search_btn" type="submit" value="検索">
		</div>
	</form>
	<hr>
	<br>
	<div class="c">
		<input style="width: 150px;" class="search_btn" type="button"
			value="新規登録" onclick="location.href='MasterCreate'">
	</div>
	<br>
	<c:forEach var="ItemList" items="${ItemList}">
		<table class="tab" width=”50%”>
			<tr class="c">
				<td colspan="4">商品ID:${ItemList.id}</td>
			</tr>
			<tr class="c">
				<td class="c" colspan="2">発売日:${ItemList.saleDate}</td>
				<td colspan="2">商品名：${ItemList.name}</td>
			</tr>
			<tr class="c">
				<td rowspan="2" width="150px" height="150px"><img
					src="img/${ItemList.fileName}" style="width: 150px; height: 200px;"></td>
				<td colspan="2">ハード:${ItemList.hardName}</td>
				<td rowspan="1" colspan="1">価格：${ItemList.price}円
			</tr>
			<tr class="c">
				<td colspan="2">ジャンル:<c:forEach var="G"
						items="${ItemList.genreName}">${G}　</c:forEach></td>
				<td rowspan="1" colspan="1">在庫:${ItemList.stock}個</td>
			</tr>
			<tr>
				<td colspan="4" height="200px" valign="top">商品説明: <br>${ItemList.detail}</td>
			</tr>
			<tr>
				<td class="c" colspan="4">更新日時:${ItemList.updatedate}</td>
			<tr>
				<td colspan="2" width="50%"><input class="full search_btn"
					type="button" value="更新"
					onClick="location.href='MasterUpdate?id=${ItemList.id}'"></td>
				<td colspan="2" width="50%"><input class="full del_btn"
					type="button" value="削除"
					onClick="location.href='MasterDelete?id=${ItemList.id}'"></td>
			</tr>
		</table>
			<br>
		<br>
		</c:forEach>
		<br>
		<br>
	<c:if test="${!ItemList.isEmpty()}">
		<div class="pager center C" style="clear: both;">
			<ul>
				<c:choose>
					<c:when test="${pageNum == 1}">
						<li><span>&laquo; 前</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="MasterList?page_num=${pageNum - 1}">&laquo; 前</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach varStatus="i" begin="0"
					end="${pageMax == 0 ? pageMax : pageMax - 1}">
					<c:choose>
						<c:when test="${pageNum != i.count}">
							<li><a href="MasterList?page_num=${i.count}"><c:out
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
						<li><a href="MasterList?page_num=${pageNum + 1}">次 &raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>
</body>
</html>