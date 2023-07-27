<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jspf" %>
	<style>
		td, th	{ text-align: center; }
	</style>
	<script>
		function search() {
			const field = $('#field').val();
			const query = $('#query').val();
			//console.log("search()", field, query);
			location.href = '/sbbs/board/list?p=${currentBoardPage}&f=' + field + '&q=' + query;
		}
	</script>
</head>
<body>
	<%@ include file="../common/top.jspf" %>
	
    <div class="container" style="margin-top: 80px;">
        <div class="row">
        	<%@ include file="../common/aside.jspf" %>
        
        	<!-- ======================== main ======================== -->
        	<div class="col-sm-9">
        		<table class="table table-sm table-borderless">
                    <tr class="d-flex">
                        <td class="col-6" style="text-align: left;">
                            <h3><strong>게시글 목록</strong>
                                <span style="font-size: 0.6em;">
                                    <a href="/sbbs/board/write" class="ms-5"><i class="far fa-file-alt"></i> 글쓰기</a>
                                </span>
                            </h3>
                        </td>
                        <td class="col-2">
                            <select class="form-select me-2" id="field"">
                                <option value="title" ${field eq 'title' ? 'selected' : '' }>제목</option>
                                <option value="content" ${field eq 'content' ? 'selected' : '' }>본문</option>
                                <option value="uname" ${field eq 'uname' ? 'selected' : '' }>글쓴이</option>
                            </select>
                        </td>
                        <td class="col-3">
                            <input class="form-control me-2" type="search" placeholder="검색할 내용" value="${query}" id="query">
                        </td>
                        <td class="col-1">
                            <button class="btn btn-outline-primary" onclick="search()">검색</button>
                        </td>
                    </tr>
                </table>
        		<hr>
        		<table class="table mt-2">
        			<tr class="table-secondary">
        				<th style="width: 10%;">ID</th>
        				<th style="width: 50%;">제목</th>
        				<th style="width: 14%;">글쓴이</th>
        				<th style="width: 16%;">날짜/시간</th>
        				<th style="width: 10%;">조회수</th>
        			</tr>
        		<c:forEach var="board" items="${boardList}">
        			<tr>
        				<td>${board.bid}</td>
        				<td>
        					<a href="/bbs/board/detail/${board.bid}/${board.uid}">${board.title}
        					<c:if test="${board.replyCount ge 1}">
        						<span class="text-danger">[${board.replyCount}]</span>
        					</c:if>
        					</a>
        				</td>
        				<td>${board.uname}</td>
        				<td>
        				<c:if test="${fn:contains(board.modTime, today)}">
        					<c:if test="${fn:length(fn:substring(board.modTime, 11, 19)) lt 6}">
        						${fn:substring(board.modTime, 11, 19)}:00
        					</c:if>
        					<c:if test="${fn:length(fn:substring(board.modTime, 11, 19)) ge 6}">
        						${fn:substring(board.modTime, 11, 19)}
        					</c:if>
        				</c:if>
        				<c:if test="${!(fn:contains(board.modTime, today))}">
        					${fn:substring(board.modTime, 0, 10)}
        				</c:if>
        				</td>
        				<td>${board.viewCount}</td>
        			</tr>
        		</c:forEach>
        		</table>
        		<ul class="pagination justify-content-center mt-4">
        		<c:if test="${currentBoardPage gt 10}">
        			<li class="page-item"><a class="page-link" href="/sbbs/board/list?p=${startPage-1}&f=${field}&q=${query}">&laquo;</a></li>
        		</c:if>
        		<c:if test="${currentBoardPage le 10}">
        			<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
        		</c:if>
				<c:forEach var="page" items="${pageList}">
					<li class="page-item ${(currentBoardPage eq page) ? 'active' : ''}">
						<a class="page-link" href="/sbbs/board/list?p=${page}&f=${field}&q=${query}">${page}</a>
					</li>
				</c:forEach>
				<c:if test="${totalPages gt endPage}">
                    <li class="page-item"><a class="page-link" href="/sbbs/board/list?p=${endPage+1}&f=${field}&q=${query}">&raquo;</a></li>
				</c:if>
				<c:if test="${totalPages eq endPage}">
                    <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
				</c:if>
                </ul>
        	</div>
        	<!-- ======================== main ======================== -->
        </div>
    </div>
	
	<%@ include file="../common/bottom.jspf" %>
</body>
</html>