<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜별 섭취정보</title>
</head>
<body>
	<h1>일별섭취정보 리스트</h1>
			<table>
			<tr>
			<th>날짜</th><th>식품명</th><th>섭취량</th><th>총내용량</th><th>에너지(kcal)</th>
			<th>단백질(g)</th><th>지방(g)</th><th>탄수화물(g)</th><th>총당류(g)</th>
			</tr>
	<C:if test="${empty MFLIST}"> 등록된 섭취정보가 없습니다</C:if>
	<C:forEach items="${MFLIST}" var="MF">
		   <tr>		
		   <td>${MF.mf_date}</td>
		   <td>${MF.f_name}</td>
		   <td>${MF.mf_intake}</td>
		   <td>${MF.mf_spc}</td>
		   <td>${MF.mf_calories}</td>
		   <td>${MF.mf_protein}</td>
		   <td>${MF.mf_fat}</td>
		   <td>${MF.mf_carbohydrate}</td>
		   <td>${MF.mf_sugars}</td>
		   </tr>
	</C:forEach>
			</table>
		<nav>
		<ul>
			<li><strong><a href="/food">HOME 으로 돌아가기</a></strong>		
		</ul>
		</nav>		

</body>
</html>