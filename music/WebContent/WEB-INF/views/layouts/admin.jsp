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
<title>Quản trị - <decorator:title /></title>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link rel="shortcut icon" href="<c:url value="/assets/user/favicon/apple-touch-icon.png"/>" type="image/x-icon">
<link rel="stylesheet" href="<c:url value="/assets/user/manager-css/app.css"/>" />
<link rel="stylesheet" href="<c:url value="/assets/user/manager-css/footer.css"/>">

<script src="https://kit.fontawesome.com/ebdbf5f47d.js" crossorigin="anonymous"></script>

<style>
	.administrator{
	display: block;
		width: 100%;
		height: 40px;
		background-color: #070d50;
		color: #a4adc8;
		position: fixed;
		top: 0;
		text-align: center;
		line-height: 40px;
		font-size: 30px;
		z-index: 999;
	}
</style>
</head>
<body>

	<div class="administrator">
		Trang Quản Trị
	</div>

	<div class="wrapper" style="margin-top: 40px">
		<%@include file="/WEB-INF/views/layouts/admin/header.jsp"%>

		<div class="main">
			
			<decorator:body />
		</div>

	</div>

	<%@include file="/WEB-INF/views/layouts/admin/footer.jsp"%>
	<script type="text/javascript">
		const menu = document.querySelector(".menu");
		const butt = document.querySelector(".turnBack");
		const myLink = window.location.href;
		const myArr = myLink.split("/");
		if(myArr.length > 6){
			menu.classList.add("disable");
			butt.classList.add("enable");
		}
	</script>
</body>
</html>