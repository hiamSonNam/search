<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Tufy - <decorator:title/></title>
<link rel="shortcut icon"
	href="<c:url value="/assets/user/favicon/apple-touch-icon.png"/>"
	type="image/x-icon">

<!-- font awesome -->
<script src="https://kit.fontawesome.com/ebdbf5f47d.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value="/assets/user/manager-css/app.css"/>" />
<link rel="stylesheet" href="<c:url value="/assets/user/manager-css/footer.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/manager-css/artist.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/manager-css/genre.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/manager-css/detailsArtist.css"/>">

<decorator:head/>
</head>
<body>
	<div class="wrapper">
		<%@include file="/WEB-INF/views/layouts/user/header.jsp" %>
		
		<div class="main">
			<div class="header">
				<form id="search" action="search" method="GET" style="width: 100%">
					<div class="search">
						<input type="text" name="keyword" placeholder="Search for song, arties etc..." class="search-input"/>
				    	<button style="background-color: transparent; border: none;"><i class="search-icon fa fa-search" id="searchBtn"></i></button>
					</div>
				</form>
			</div>
			<!-- render every content here -->
				<decorator:body/>
		</div>

	</div>
	
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp" %>
	<script src="<c:url value="/assets/user/manager-js/app.js"/>"></script>
	<script type="text/javascript">
		const menu = document.querySelector(".menu");
		const butt = document.querySelector(".turnBack");
		const myLink = window.location.href;
		const myArr = myLink.split("/");
		if(myArr.length > 5){
			menu.classList.add("disable");
			butt.classList.add("enable");
		}
	</script>
</body>
</html>

