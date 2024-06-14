<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 페이지</h1>
	
	
	<form action="./update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		
		<div>
			<label>도시명</label>
			<input type="text" name="city" value="${dto.city}">                       
		</div>
		
		<div>
			<label>기온</label>
			<input type="text" name="gion" value="${dto.gion}">                       
		</div>
		
		<div>
			<label>습도</label>
			<input type="text" name="huminity" value="${dto.huminity}">                       
		</div>
		
		<div>
			<label>날씨</label>
			<input type="text" name="status" value="${dto.status}">                       
		</div>
		
		
		
		<input type="submit" value="등록">
		<button type="submit">등록</button>
	
	
	</form>
</body>
</html>