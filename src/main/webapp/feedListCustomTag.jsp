<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="feed"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Title</th>
				<th>Desc</th>
				<th>Time</th>
			</tr>
		</thead>
		<tbody>
			<feed:feedList feeds="${feedList}">
				<tr>
					<td>${feed.title}</td>
					<td>${feed.description}</td>
					<td>${feed.date}</td>
				</tr>
			</feed:feedList>
		</tbody>
	</table>
</body>
</html>