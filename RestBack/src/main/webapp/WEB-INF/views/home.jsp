<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<!-- 
<h1>

	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
 -->
 
 <input type="text" id = "sendMsg"></input>
 <button id="btnSend" onClick="sendTest()"> test </button>
 
  <script>
  	function test(){
  		alert("232")
  	}
 		var ws = new WebSocket("ws://localhost:8080/replyEcho?bno=1234");
 		
 		ws.onopen = function () {
 				console.log("connect!");
 				setTimeout(function(){
 					connect()
 					},1000);
 			};
 		
 		ws.onmessage = function(event){
 			console.log(event.data+'\n');
 		};
 		
 		ws.onclose = function (event) { console.log("정상종료")}
 		ws.onerror = function (event) { console.log("비정상종료")}
 		
	var btnSend = document.getElementById("btnSend");
	var sendMsg = document.getElementById("sendMsg");
	var msg = sendMsg.value;
	
	btnSend.addEventListener("click", function(e){
		e.preventDefault();
		ws.send(msg);
		
		sendMsg.value = "";
	})
	 
 </script>
</body> 

</html>
