<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜별 섭취정보</title>
</head>
<body>
	<h4>조회하려는 날짜를 입력하세요</h4>
	<form method="POST">
		<input name="mf_year" maxlength="4" required/>년
		<input name="mf_month" maxlength="2" required/>월
		<input name="mf_day" maxlength="2" required/>일
		<button>조회</button>
	</form>
	
	<nav>
		<ul>
			<li><strong><a href="/food">HOME 으로 돌아가기</a></strong>		
		</ul>
	</nav>	
</body>
</html>