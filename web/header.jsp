
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="" />
            <meta name="author" content="" />
            <title>Dashboard - Admin</title>
            <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
            <link href="css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                  integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        </head>
    <body>
        <!-- header section strats -->
        <header class="header_section">
            <div class="container">
                <nav class="navbar navbar-expand-lg custom_nav-container ">
                    <a class="navbar-brand" href="home.jsp">
                        <span>
                            Mirano restaurant
                        </span>
                    </a>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class=""> </span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav  mx-auto ">
                            <li class="nav-item">
                                <a class="nav-link" href="homeController">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="menuController">Menu</a>
                            </li>
                            <c:if test="${sessionScope.id != null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="chooseTable.jsp">Booking</a>
                                </li> 
                                <li class="nav-item">
                                    <a class="nav-link" href="cartController">Carts</a>
                                </li>  
                            </c:if>
                        </ul>
                        <div class="user_option">

                            <c:if test="${sessionScope.id != null}">
                                <a href="profileController" class="order_online">
                                    Profile
                                </a>
                                <a class="order_online" href="changePassController">
                                    Change Pass
                                </a>
                                <a href="logoutController" class="order_online">
                                    logout
                                </a> 
                            </c:if>
                            <c:if test="${sessionScope.id == null}">
                                <a href="loginController" class="order_online">
                                    Login
                                </a> 
                                <a href="forgotPasswordController" class="order_online">
                                    Forgot Password
                                </a> 
                            </c:if>


                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <!-- end header section -->
    </body>
</html>
