<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MemberList</title>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$.get("/gradle_spring5_chap11/api/members",
					function(json) {
					var dataLength = json.length;
					if (dataLength >= 1) {
						var sCont = "";
						for (i = 0; i < dataLength; i++) {
							sCont += "<tr>";
							sCont += "<td>" + json[i] + "</td>";
							sCont += "<td><a href='members/"+json[i].id"'>"
									+ json[i].name + "</a></td>";
							sCont += "<td>" + json[i].email + "</td>";
							sCont += "<td>" + json[i].registerDateTime + "</td>"
							sCont += "</tr>"
						}
						$("#load:last-child").append(sCont);
					}
					
				});
				
			});
		</script>
	</head>
	
	<body>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
			<tbody id="load"></tbody>
		</table>
	</body>
</html>