<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 정보입력 페이지</h1>
	
	<form action="/student/add" method="post">
		<div>
			<label for="num">번호</label>
			<input type="text" id="num" name="num" value="">
		</div>
		
		<div>
			<label for="name">이름</label>
			<input type="text" id="name" name="name">
		</div>
		
		<div>
			<label for="avg">평균</label>
			<input type="text" id="avg" name="avg">
		</div>
		
		<div>
		<label></label>
		<input type="radio" name="ch" value="여성">
		<input type="radio" name="ch" value="남성">
		</div>
		
		<div>
			<select name="mobile">
				<option value="KT">KT</option>
				<option value="SKT">SKT</option>
				<option value="LG">LG</option>		
			</select>
		</div>
		
		<div>
			<input type="checkbox" name="ch2" value="v1">
			<input type="checkbox" name="ch2" value="v2">
			<input type="checkbox" name="ch2" value="v3">
		</div>
		
		<div>
			<textarea rows="" cols="" name="contents"></textarea>
		</div>
		
		<div>
			<input type="submit" value="등록">
			<button type="submit">작성</button>
		
		</div>
	
	
	</form>
</body>
</html>