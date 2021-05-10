<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>섭취정보 등록</title>
</head>
<body>
	<h1>섭취정보를 입력하세요</h1>
	<form method="POST">
		<p><input name="mf_date"/>
		<p><input name="mf_name" value="${MFPCODE.mf_pcode}">
		<a href="intake?id=search">식품 검색</a>
		<p><input name="mf_intake"/>
		<button>등록</button>
	</form>
</body>
</html>