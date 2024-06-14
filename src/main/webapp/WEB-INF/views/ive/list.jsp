<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<div>
	
	</div>
	
	<h1>아이브 멤버 리스트</h1>
	
	<table class="tb1">
	<thead>
		<tr>
		<th>Num</th>
		<th>Name</th>
		<th>Group</th>
	
		</tr>
	</thead>
	
	<tbody>
		<tr>
		<td>${pageScope.ive.num}</td>
		<td>${pageScope.ive.name}</td>
		<td>${pageScope.ive.group}</td>	
			
		</tr>
	
	
	</tbody>
	
	
	
	
	</table>
	
	
</body>
</html>