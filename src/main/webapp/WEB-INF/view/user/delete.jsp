<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jspf" %>
</head>
<body>
	<%@ include file="../common/top.jspf" %>
	
    <div class="container" style="margin-top: 80px;">
        <div class="row">
        	<%@ include file="../common/aside.jspf" %>
        
        	<!-- ======================== main ======================== -->
			<div class="col-sm-9">
        		<h3><strong>회원 탈퇴</strong></h3>
        		<hr>
        		<div class="row">
        			<div class="col-3"></div>
        			<div class="col-6">
        				<div class="card border-warning mt-3">
        					<div class="card-body">
        						<strong class="card-title">삭제하시겠습니까?</strong>
        						<p class="card-text text-center">
        							<br>
        							<button class="btn btn-primary" onclick="location.href='/bbs/user/deleteConfirm?uid=${param.uid}'">삭제</button>
        							<button class="btn btn-secondary" onclick="location.href='/bbs/user/list?page=${currentUserPage}'">취소</button>
        						</p>
        					</div>
        				</div>
        			</div>
        			<div class="col-3"></div>
        		</div>
        	</div>
        </div>
	</div>
	
	<%@ include file="../common/bottom.jspf" %>
</body>
</html>