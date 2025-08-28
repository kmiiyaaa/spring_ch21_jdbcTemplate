<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 회원 리스트</title>
</head>
<body>
	<h2>모든 회원 리스트</h2>
	<hr>
	<c:froEach items=${mDtos } var="mDto">
		<h3>
			${mDto.memberid } / ${mDto.membername } / ${dDto.memberage }
		</h3>
	</c:froEach>
</body>
</html>