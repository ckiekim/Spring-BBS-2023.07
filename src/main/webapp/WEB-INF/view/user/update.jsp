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
        		<h3><strong>사용자 수정</strong></h3>
        		<hr>
        		<div class="row">
        			<div class="col-3"></div>
        			<div class="col-6">
        				<form action="/bbs/user/update" method="post" enctype="multipart/form-data">
        					<input type="hidden" name="uid" value="${user.uid}">
        					<input type="hidden" name="hashedPwd" value="${user.pwd}">
        					<input type="hidden" name="filename" value="${user.profile}">
	                		<table class="table table-borderless">
	                			<tr>
			                        <td style="width:35%"><label class="col-form-label">사용자 ID</label></td>
			                        <td style="width:65%"><input type="text" class="form-control" value="${user.uid}" disabled></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">패스워드</label></td>
			                        <td><input type="password" name="pwd" class="form-control"></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">패스워드 확인</label></td>
			                        <td><input type="password" name="pwd2" class="form-control"></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">이름</label></td>
			                        <td><input type="text" name="uname" class="form-control" value="${user.uname}"></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">이메일</label></td>
			                        <td><input type="text" name="email" class="form-control" value="${user.email}"></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">프로필 사진</label></td>
			                        <td><input type="file" name="profile" class="form-control"></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">주소</label></td>
			                        <td><input type="text" name="addr" class="form-control" value="${user.addr}"></td>
			                    </tr>
			                    <tr>
			                        <td colspan="2" style="text-align: center;">
			                            <input class="btn btn-primary" type="submit" value="제출">
			                            <input class="btn btn-secondary" type="reset" value="취소">
			                        </td>
			                    </tr>
	                		</table>
	                	</form>
        			</div>
        			<div class="col-3"></div>
        		</div>      		
        	</div>
        </div>
    </div>
	
	<%@ include file="../common/bottom.jspf" %>
</body>
</html>