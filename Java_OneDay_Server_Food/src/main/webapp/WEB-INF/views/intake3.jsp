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
	<C:if test="${empty FLIST}"> 검색결과가 없음</C:if>
	<C:forEach items="${FLIST}" var="FOOD">
		<p><a href="intake?f_code=${FOOD.f_code}">${FOOD.f_name}</a>
	</C:forEach>
</body>
</html>