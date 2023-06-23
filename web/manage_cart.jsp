<%-- 
    Document   : managa_product
    Created on : Mar 1, 2023 9:17:24 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Show</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <%@include file="setupCss.jsp" %>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <!-- Section: Design Block -->
        <section class="py-1">
            <!-- style="background-color: white"-->
            <div class="container d-flex " style="min-height: 800px;">

                <div class="col-md-12">
                    <h3 class="mt-5">Cart</h3>

                    <div >

                        <table class="table col-3 table-bordered" style="height: 100px">
                            <thead>
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total price</th>
                                    <th scope="col">Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="o" value="${requestScope.cart}"/>
                                <c:set var="tt" value="0"/>
                                <c:forEach items="${o.items}" var="f">
                                    <c:set var="tt" value="${tt+1}"/>
                                    <tr style="height: 60px">
                                        <th scope="row">${tt}</th>
                                        <th scope="row">  <a href="productController?productId=${f.product.productId}">${f.product.productName}</a></th>
                                        <th scope="row">${f.price/2}</th>
                                        <th scope="row">
                                            <button class=""><a href="processController?st=-1&num=${f.quantity}&productId=${f.product.productId}">-</a></button>
                                            <input type="text" value="${f.quantity}">
                                            <button class=""><a href="processController?st=1&num=${f.quantity}&productId=${f.product.productId}">+</a></button>
                                        <th scope="row">${(f.price*f.quantity)/2}</th>
                                        <th scope="row">
                                            <button class="btn btn-link" type="button" class="btn btn-primary"
                                                    data-bs-toggle="modal" data-bs-target="#exampleModal${f.product.productId}"><i
                                                    class="fa fa-solid fa-trash mb-1"></i>
                                            </button>
                                        </th>

                                    </tr>

                                <div class="modal fade" id="exampleModal${f.product.productId}" tabindex="-1"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel"><i class="bi bi-trash-fill"></i>
                                                    Delete</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                Are you sure to delete this product?
                                            </div>
                                            <div class="modal-footer">
                                                <form action="processController" method="post">
                                                    <input type="hidden" name="id" value="${f.product.productId}"/>
                                                    <button type="submit" class="btn btn-primary">Yes</button>
                                                    <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">No</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>                      
                            </tbody>
                            <div class="d-flex justify-content-between col-3 ">
                                <a href="menuController" class="btn btn-success">Menu</a>
                            </div>
                        </table>
                        <div class="d-flex justify-content-center">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <c:forEach begin="1" end="${requestScope.total}" step="1" var="i">
                                        <li class="page-item <c:if test="${i == requestScope.page}"> active </c:if> " >
                                            <a class="page-link" href="cartControll?page=${i}&productName=${productName}&category=${category}">
                                                ${i}
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <form action="checkoutController" method="post">
                        <input class="btn btn-primary" type="submit" value="Check out"/>
                    </form>
                    <div class="d-flex justify-content-between col-3 " style="right">
                        <a href="infoController" class="btn btn-success">Menu</a>
                    </div>

                </div>
        </section>
        <%@include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Section: Design Block -->
    </body>

</html>
