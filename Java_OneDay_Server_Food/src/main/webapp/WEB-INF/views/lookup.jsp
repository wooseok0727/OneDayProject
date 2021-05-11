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
		<input type="date" name="mf_date" value="${FDATE}"/>
		<button>조회</button>
	</form>
	
	<nav>
		<ul>
			<li><strong><a href="/food">HOME 으로 돌아가기</a></strong>		
		</ul>
	</nav>	
</body>
</html>