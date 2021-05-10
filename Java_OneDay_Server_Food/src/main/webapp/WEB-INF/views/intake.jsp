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
		<p>날짜 <input name="mf_date"/>
		<p>식품코드<input name="mf_code" value="${FCODE}">
		<p>식품명 <input name="mf_name" value="${FNAME}"> 
			<button name="button" value="search">식품명 검색</button>
		<p>섭취량 <input name="mf_intake"/>
		<button name="button" value="insert">등록</button>
	</form>
</body>
</html>