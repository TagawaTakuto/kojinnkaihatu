<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="layout/style.css">
<meta charset="UTF-8">
<title>マスター商品削除</title>
</head>
<body>
	<jsp:include page="/layout/hedder.jsp" />
	<h1 class="box c">商品削除</h1>
	<div class="c">この商品情報を削除してもよろしいですか？</div>
	<br>
	<form action="MasterDelete" method="post">
		<input type="hidden" value="${Item.id}" name="id">
		<table class="tab" width=”50%”>
			<tr class="c">
				<td colspan="4">商品ID:${Item.id}</td>
			</tr>
			<tr class="c">
				<td class="c" colspan="2">発売日:${Item.saleDate}</td>
				<td colspan="2">商品名：タイトル１</td>
			</tr>
			<tr class="c">
				<td rowspan="2" width="150px" height="150px">${Item.fileName}</td>
				<td colspan="2">ハード:？？？</td>
				<td rowspan="1" colspan="1">価格：${Item.price}円
			</tr>
			<tr class="c">
				<td colspan="2">ジャンル:？？？ ？？？</td>
				<td rowspan="1" colspan="1">在庫:${Item.stock}個</td>
			</tr>
			<tr>
				<td colspan="4" height="200px" valign="top">商品説明: <br>${Item.detail}
				</td>
			</tr>
			<tr>
				<td class="c" colspan="4">更新日時:${Item.updatedate}</td>
		</table>
		<br>
		<div class="c">
			<input type="button" class="search_btn" value="キャンセル"
				onClick="location.href='MasterList'"> <input type="submit"
				class="del_btn" style="width: 80px;" value="　ＯＫ　">
		</div>
	</form>
</body>
</html>