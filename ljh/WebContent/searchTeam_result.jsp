<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr>
		<th scope="row"><img src="${tVo.emblem}"
			style="width: 40px; height: 40px;"></th>
		<td>${tVo.teamName}</td>
		<td><c:if test="${tVo.ti.ranking != '0'}">${tVo.ti.ranking}</c:if>
			<c:if test="${tVo.ti.ranking == '0'}">랭킹자료없음</c:if></td>
		<td>${tVo.ti.memberNum}</td>
		<td><c:if test="${tVo.stadiumId != null}">유</c:if> <c:if
				test="${tVo.stadiumId == null}">무</c:if></td>
		<td>
			<button type="submit" class="btn btn-light px-5" id="requestToJoin"
				value="${tVo.teamId}">
				<i class="icon-lock"></i> 가입 신청
			</button>
		</td>
	</tr>

</body>
</html>