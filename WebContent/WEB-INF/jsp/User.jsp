<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="layout/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザページ</title>
</head>
<body>
	<input type="hidden" value="${LoginInfo.id}" name="UserId">
	<jsp:include page="/layout/hedder.jsp" />
	<div class="box17">
		<h1 class="box c">ユーザページ</h1>
	</div>
	<br>
	<div class="c">
		<a href="UserUpdate" class="Bbtn">更新</a> <a href="UserData"
			class="Gbtn">詳細</a> <a href="UserDelete" class="Rbtn">削除</a>
	</div>
	<br>
	<br>
	<table class="table table-striped">
		<tr>
			<th style="width: 100px;"></th>
			<th></th>
			<th>購入日時</th>
			<th>合計金額</th>
			<th>配送方法</th>
			<th style="width: 100px;"></th>
		</tr>
		<c:forEach var="buyhis" items="${UserBuy}" end="3">
			<tr>
				<td></td>
				<td><a href="BuyHistory?id=${buyhis.id}" class="his_btn">詳細→</a></td>
				<td class="">${buyhis.getFormatDate()}</td>
				<td class="">${buyhis.totalPrice}</td>
				<td class="">${buyhis.deliveryMethodName}</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:if test="${!UserBuy.isEmpty()}">
		<div class="pager center C" style="clear: both;">
			<ul>
				<c:choose>
					<c:when test="${pageNum == 1}">
						<li><span>&laquo; 前</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="User?page_num=${pageNum - 1}">&laquo; 前</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach varStatus="i" begin="0"
					end="${pageMax == 0 ? pageMax : pageMax - 1}">
					<c:choose>
						<c:when test="${pageNum != i.count}">
							<li><a href="User?page_num=${i.count}"><c:out
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
						<li><a href="User?page_num=${pageNum + 1}">次 &raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>
</body>
</html>