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
	<h1>식품정보 리스트</h1>
	<C:if test="${empty FLIST}"> 검색결과가 없음</C:if>
	<table>
		<thead>
			<tr>
				<th>식품명</th>
				<th>출시연도</th>
				<th>제조사명</th>
				<th>분류명</th>
				<th>1회제공량</th>
				<th>에너지(kcal)</th>
				<th>단백질(g)</th>
				<th>지방(g)</th>
				<th>탄수화물(g)</th>
				<th>총당류(g)</th>
			</tr>
		</thead>
		<tbody>
			<C:forEach items="${FLIST}" var="FOOD">
				<form method="POST">
					<tr>
						<input type="hidden" name="f_code" value="${FOOD.f_code}" />
						<input type="hidden" name="f_name" value="${FOOD.f_name}" />
						<td><button name="button" value="select">${FOOD.f_name}</button></td>
						<td>${FOOD.f_date}</td>
						<td>${FOOD.c_name}</td>
						<td>${FOOD.t_name}</td>
						<td>${FOOD.f_aps}</td>
						<td>${FOOD.f_calories}</td>
						<td>${FOOD.f_protein}</td>
						<td>${FOOD.f_fat}</td>
						<td>${FOOD.f_carbohydrate}</td>
						<td>${FOOD.f_sugars}</td>
					</tr>
				</form>
			</C:forEach>
		</tbody>
	</table>

	<nav>
		<ul>
			<li><strong><a href="/food">HOME 으로 돌아가기</a></strong>
		</ul>
	</nav>
</body>
</html>