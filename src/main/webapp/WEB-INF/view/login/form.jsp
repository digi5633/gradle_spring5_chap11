<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
	
	<body>
		<form:form modelAttribute="login" action="result">
		<p>
			<label for="loginType">로그인 타입</label>
			<form:select path="loginType">
				<option value="">-- 선택하세요 </option>
				<form:options items="${loginTypes}"/>
			</form:select> 
		</p>
		<p>
			<label for="jobCode">직군</label>
			<form:select path="jobCode">
				<option value="">-- 선택하세요 </option>
				<form:options items="${jobCodes}" itemLabel="label" itemValue="code"/>
			</form:select> 
		</p>
		<p>
			<label for=tool>주로 사용하는 개발 툴</label>
			<form:radiobuttons items="${tools}" path="tool"/>
		</p>
		<p>
			<label for=favoriteOs>선호 OS</label>
			<form:checkboxes items="${favoriteOsNames}" path="favoriteOs"/>
		</p>
		<p>
			<label for=likeOs>좋아하는 OS</label>
			<form:checkbox items="${likeOsNames}" path="likeOs" value="O1" label="윈도우10"/>
			<form:checkbox items="${likeOsNames}" path="likeOs" value="O2" label="리눅스"/>
			<form:checkbox items="${likeOsNames}" path="likeOs" value="O3" label="유닉스"/>
			<form:checkbox items="${likeOsNames}" path="likeOs" value="O4" label="칼리리눅스"/>
			<form:checkbox items="${likeOsNames}" path="likeOs" value="O5" label="우분투"/>
		</p>



		<input type="submit" value="결과보기">
	</form:form>
	</body>
</html>