<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<h1>Hello Ice BE World</h1>
	<P>The time on the server is ${serverTime}.</P>
	<h3> TestList</h3>
	<ul>
		<li><button onClick="goPage('websocketPage')">WebsocketPage</button></li>
	</ul>
</body>
<script>
	function goPage(page){
		var path = "/" + page;
		console.log(path);
		location.href = path;
	}
</script>
</html>
