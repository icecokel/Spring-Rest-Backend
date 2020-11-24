
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>WebsocketViewPage</title>
</head>
<body>

	<h1>WebsocketViewPage</h1>

	<input type="text" id="sendMsg"></input>
	<button id="btnSend" onClick="sendTest()">send Massage</button>
	

	<script>
		var ws = new WebSocket("ws://localhost:8080/replyEcho?userId=icecokel");

		var sendMsg = document.getElementById("sendMsg");
		
		window.addEventListener('DOMContentLoaded', function(event){
			onOpen();		    
		});
			
		
		function onOpen(){
			ws.onopen = function() {
				console.log("connect!");
				setTimeout(function() {
					connect()
				}, 1000);
			};	
		}
	
		ws.onmessage = function(event) {
			console.log(event.data + '\n');
		};

		ws.onclose = function(event) {
			console.log("정상종료")
		}
		ws.onerror = function(event) {
			console.log("비정상종료")
		}

		var btnSend = document.getElementById("btnSend");


		btnSend.addEventListener("click", function(e) {
			e.preventDefault();
			console.log(sendMsg.value);
			ws.send(sendMsg.value);
		})
	</script>


</body>
</html>