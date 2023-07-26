<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jspf" %>
	<style>
		td, th	{ text-align: center; }
		.disabled-link	{ pointer-events: none; }
	</style>
</head>
<body>
	<%@ include file="../common/top.jspf" %>
	
    <div class="container" style="margin-top: 80px;">
        <div class="row">
        	<%@ include file="../common/aside.jspf" %>
        
        	<!-- ======================== main ======================== -->
        	<div class="col-sm-9">
        		<h3><strong>사용자 목록</strong></h3>
        		<hr>
        		<table class="table table-condensed table-hover" style="margin-bottom: 50px;">
        			<tr class="table-secondary">
        				<th style="width: 8%;">번호</th>
        				<th style="width: 10%;">uid</th>
        				<th style="width: 10%;">이름</th>
        				<th style="width: 24%;">이메일</th>
        				<th style="width: 16%;">가입일</th>
        				<th style="width: 24%;">주소</th>
        				<th style="width: 8%;">액션</th>
        			</tr>
        		<c:forEach var="user" items="${userList}" varStatus="loop">
        			<tr>
        				<td>${loop.count}</td>
        				<td>${user.uid}</td>
        				<td>${user.uname}</td>
        				<td>${user.email}</td>
        				<td>${user.regDate}</td>
        				<td>${user.addr}</td>
        				<td>
        					<%-- 본인만이 수정권한이 있음 --%>
        					<c:if test="${uid eq user.uid}">
        						<a href="/bbs/user/update?uid=${user.uid}"><i class="fas fa-user-edit me-1"></i></a>
        					</c:if>
        					<c:if test="${uid ne user.uid}">
        						<a href="#" class="disabled-link"><i class="fas fa-user-edit me-1"></i></a>
        					</c:if>
        					<%-- 관리자만이 삭제권한이 있음 --%>
        					<c:if test="${uid eq 'admin'}">
        						<a href="/bbs/user/delete?uid=${user.uid}"><i class="fas fa-user-minus"></i></a>
        					</c:if>
        					<c:if test="${uid ne 'admin'}">
        						<a href="#" class="disabled-link"><i class="fas fa-user-minus"></i></a>
        					</c:if>
        				</td>
        			</tr>
        		</c:forEach>
        		</table>
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
				<c:forEach var="page" items="${pageList}">
					<li class="page-item ${(currentUserPage eq page) ? 'active' : ''}">
						<a class="page-link" href="/bbs/user/list?page=${page}">${page}</a>
					</li>
				</c:forEach>
					<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
				</ul>       		
        	</div>
        </div>
    </div>
	
	<%@ include file="../common/bottom.jspf" %>
</body>
</html>