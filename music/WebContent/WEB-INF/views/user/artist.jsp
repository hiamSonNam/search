<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<head>
	<title>Artists</title>
</head>

<body>
	<div class="content" style="grid-template-columns: auto;">
          <div class="content-item">
            <div class="block-box">
              <h2 class="heading">Tufy's Artists</h2>
            </div>
            <div id="artist-list">
              <!-- render here -->
              	<c:forEach var="item" items="${Artists}">
              		<a href='<c:url value="/artist/${p.currentPage}/${item.artistId}"/>'>
						<div class="artist">
	                		<img src="http://localhost/${item.artistAvatar}" alt="${item.artistName}" class="artist-image"/>
	                		<h3 class="artist-name">${item.artistName}</h3>
	            		</div>
            		</a>
				</c:forEach>
            </div>
          </div>
        </div>
	<div class="pagination">
		<c:forEach var="item" begin="1" end="${p.totalPage}" varStatus="loop">
			<c:if test="${(loop.index) == p.currentPage}">
				<a href='<c:url value="/artist/${loop.index}"/>' class="active">${loop.index}</a>
			</c:if>
			<c:if test="${(loop.index) != p.currentPage}">
				<a href='<c:url value="/artist/${loop.index}"/>'>${loop.index}</a>
			</c:if>
	  	</c:forEach>
	</div>
</body>