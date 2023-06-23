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
        <jsp:useBean id ="a" class="Model.Product" scope ="request"></jsp:useBean>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Product</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <%@include file="admin_header.jsp" %>
        <!-- Section: Design Block -->
        <section class="py-1">
            <!-- style="background-color: white"-->
            <div class="container d-flex " style="min-height: 800px;">

                <div class="col-md-12">
                    <h3 class="mt-5">Manage product </h3>

                    <div >
                        <h3 class="text-center mt-5" >Filter</h3>
                        <form action="manageProductControll" method="get" class="row">
                            <input hidden type="text form-control" value="1" name="page">
                            <a href="manageProductControll.java"></a>
                            <div class="col-3">
                                <label class="col-md-3">Name: </label>
                                <input class="col-md-8  form-control" type="text" value="${name}" name="name"/>
                            </div>
                            <div class="col-3">
                                <label class="col-md-3">Category: </label>
                                <select class="col-md-8 form-select"  name="category">
                                    <option value="" <c:if test="${category == ''}">selected</c:if> >All</option>
                                    <c:forEach items="${cat}" var="g">
                                        <option value="${g.categoryId}" <c:if test="${category == g.categoryName}">selected</c:if>>${g.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                                <div class="col-3 d-flex justify-content-center">
                                    <button type="submit" class="btn btn-primary" style="height: 35px; margin-top: 20px">Submit</button>
                                </div>
                            </form>
                        </div>
                        <div class="d-flex justify-content-between col-3 ">
                            <a href="createProductController" class="btn btn-success ">Add product</a>
                        </div>
                        <table class="table col-3 table-bordered" style="height: 100px">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Edit</th>
                                    <th scope="col">Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pro}" var="f">
                                <tr style="height: 60px">
                                    <th scope="row">${f.productId}</th>
                                    <th scope="row">  <a href="viewProductController?productId=${f.productId}">${f.productName}</a></th>
                                    <th scope="row">${f.category.categoryName}</th>
                                    <th scope="row">${f.price}</th>
                                    <th scope="row">${f.status}</th>
                                    <th scope="row">
                                        <a style="margin-left: 10px" href="updateProductController?productId=${f.productId}"><i class="fa fa-solid fa-pencil"></i></a>
                                        </th>
                                    <th scope="row">
                                        <button class="btn btn-link" type="button" class="btn btn-primary"
                                                data-bs-toggle="modal" data-bs-target="#exampleModal${f.productId}"><i
                                                class="fa fa-solid fa-trash mb-1"></i>
                                        </button>
                                    </th>

                                </tr>

                            <div class="modal fade" id="exampleModal${f.productId}" tabindex="-1"
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
                                            <form action="manageProductControll" method="post">
                                                <input hidden type="search" value="${f.productId}" name="productId" hidden>
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
                    </table>
                    <div class="d-flex justify-content-center">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${requestScope.total}" step="1" var="i">
                                    <li class="page-item <c:if test="${i == requestScope.page}"> active </c:if> " >
                                        <a class="page-link" href="manageProductControll?page=${i}&productName=${productName}&category=${category}">
                                            ${i}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </div>

            </div>
        </section>
        <%@include file="admin_footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Section: Design Block -->
    </body>

</html>
