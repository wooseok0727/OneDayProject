<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>섭취정보 등록</title>
</head>
<body>
	<h1>섭취정보를 입력하세요</h1>
	<form method="POST">
		<table>
			<tr>
				<th>날짜</th>
				<td><input type="date" name="mf_date" value="${FDATE}" /></td>
			</tr>
			<input type="hidden" name="mf_code" value="${FCODE}">

			<tr>
				<th>식품명</th>
				<td><input name="mf_name" value="${FNAME}" required />
					<button name="button" value="search">식품명 검색</button></td>
			</tr>

			<tr>
				<th>섭취량</th>
				<td><input name="mf_intake" />
					<button name="button" value="insert">등록</button></td>
			</tr>
		</table>
	</form>

	<nav>
		<ul>
			<li><strong><a href="/food">HOME 으로 돌아가기</a></strong>
		</ul>
	</nav>
</body>
</html>