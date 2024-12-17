<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ajax.jsp -->
	<script>
	// Asynchronous Javascript And Xml
//	fetch('replyList.do')
//	.then(function(result){
//		console.log(result);
//		return result.json();
		
//	})
//	.then(function(result){
//		console.log(result);
//		let p = document.createElement("p");
//		p.innerText = '이름: ' + result.name + ", 나이: " + result.age;
//		document.querySelector('body').appendChild(p);
//	})
//	.catch(function(err){
//		console.log(err);
//	});
	
	console.log(1);
	fetch('fullData.do')
	.then(result => result.json())
	.then(result => {
		console.log(3);
	})
	.catch(err => console.log(err));
	
	console.log(2);
	
	
	</script>
</body>
</html>