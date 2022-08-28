<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="css/menu.css" />
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<h2>Menu List</h2>
			<div class="menu">
				<div class="drink">
					<img src="img/img_menu_drink.jpg" alt="" width="300px" height="300px" />
				</div>
				<div class="food">
					<img src="img/img_menu_food.jpg" alt="" width="300px" height="300px" />
				</div>
				<div class="pasta">
					<img src="img/img_menu_pasta.jpg" alt="" width="300px" height="300px" />
				</div>
				<div class="dessert">
					<img src="img/img_menu_dessert.jpg" alt="" width="300px" height="300px" />
				</div>
				<div class="morning">
					<img src="img/img_menu_morning.jpg" alt="" width="300px" height="300px" />
				</div>
				<div class="alcohol">
					<img src="img/img_menu_alcohol.jpg" alt="" width="300px" height="300px" />
				</div>
			</div>
		</div>
	</div>
	<%@include file="common/footer.jsp" %>
</body>
</html>