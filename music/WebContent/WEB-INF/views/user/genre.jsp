<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<title>Genre</title>
<body>
	<div class="content forGenreList">
    	<div class="content-item" style="">
        	<div class="block-box" style="margin-bottom:0">
            	<h2 class="heading">Tufy's Genre</h2>
           	</div>
              
            <div id="artist-list">
              	<c:forEach var="item" items="${Categories}">
              		<a href='<c:url value="/genre/${item.cateId}"/>' >
						<div class="artist x">
	                		<h3 class="artist-name y">${item.cateName}</h3>
	            		</div>
            		</a>
				</c:forEach>
            </div>
              
    	</div>
	</div>
</body>