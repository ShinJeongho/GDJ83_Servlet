<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>날씨 정보 리스트</h1>
	
	<table class="tb1">
	<thead>
		<tr>
			<th>Num</th>
			<th>City</th>
			<th>Gion</th>			
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${list}" var="w">
			<tr>
			<td>${pageScope.w.num}</td>
			<td><a href="./detail?num=${pageScope.w.num}">${pageScope.w.city}</a></td>
			<td>${pageScope.w.gion}</td>		
			</tr>		
		</c:forEach>
	</tbody>
	
	
	
	
	
	
	</table>
	
	<div>
		<a href="./add">날씨등록</a>
	</div>
	
	
	
</body>
</html>